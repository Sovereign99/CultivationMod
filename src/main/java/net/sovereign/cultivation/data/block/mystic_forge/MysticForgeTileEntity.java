package net.sovereign.cultivation.data.block.mystic_forge;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import net.sovereign.cultivation.crafting.recipe.ForgingRecipe;
import net.sovereign.cultivation.setup.tile_entities.ModRecipes;
import net.sovereign.cultivation.setup.tile_entities.ModTileEntityTypes;
import org.jetbrains.annotations.Nullable;

public class MysticForgeTileEntity extends LockableTileEntity implements ISidedInventory, ITickableTileEntity {
    // Desired time in seconds * number of ticks per second
    static final int WORK_TIME = 2 * 20;

    private NonNullList<ItemStack> items;
    private final LazyOptional<? extends IItemHandler>[] handlers;

    private int progress = 0;

    private final IIntArray fields = new IIntArray() {
        @Override
        public int get(int index) {
            switch (index) {
                case 0:
                    return progress;
                default:
                    return 0;
            }
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0:
                    progress = value;
                    break;
            }
        }

        @Override
        public int size() {
            return 1;
        }
    };

    public MysticForgeTileEntity() {
        super(ModTileEntityTypes.MYSTIC_FORGE.get());
        this.handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
        this.items = NonNullList.withSize(2, ItemStack.EMPTY);
    }

    void encodeExtraData(PacketBuffer buffer) {
        buffer.writeByte(fields.size());
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return new int[]{0, 1};
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
        return isItemValidForSlot(index, itemStackIn);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        return index == 1;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.cultivation.mystic_forge");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        //return new MysticForgeContainer(id, player, this, this.fields);
        return null;
    }

    @Override
    public int getSizeInventory() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return getStackInSlot(0).isEmpty() && getStackInSlot(1).isEmpty();
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return items.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(items, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(items, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        items.set(index, stack);
    }

    @Override
    public boolean isUsableByPlayer(PlayerEntity player) {
        return world != null && world.getTileEntity(this.pos) == this && player.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ()) <= 64;
    }

    @Override
    public void clear() {
        items.clear();
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        this.items = NonNullList.withSize(2, ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(nbt, this.items);

        this.progress = nbt.getInt("Progress");
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt) {
        super.write(nbt);
        ItemStackHelper.saveAllItems(nbt, this.items);
        nbt.putInt("Progress", this.progress);
        return nbt;
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT nbt = this.getUpdateTag();
        ItemStackHelper.saveAllItems(nbt, this.items);
        return new SUpdateTileEntityPacket(this.pos, 1, nbt);
    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT nbt = super.getUpdateTag();
        nbt.putInt("Progress", this.progress);
        return nbt;
    }

    @Nullable
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        if (!this.removed && side != null && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (side == Direction.UP) {
                return this.handlers[0].cast();
            } else if (side == Direction.DOWN) {
                return this.handlers[1].cast();
            } else {
                return this.handlers[2].cast();
            }
        } else {
            return super.getCapability(cap, side);
        }
    }

    @Override
    public void remove() {
        super.remove();
        for (LazyOptional<? extends IItemHandler> handler : this.handlers) {
            handler.invalidate();
        }
    }

    @Override
    public void tick() {
        if(world == null || world.isRemote) {
            return;
        }

        ForgingRecipe recipe = getRecipe();
        if (recipe != null) {
            doWork(recipe);
        } else {
            stopWork();
        }
    }

    @Nullable
    public ForgingRecipe getRecipe () {
        if (world == null || getStackInSlot(0).isEmpty()) {
            return null;
        }

        return world.getRecipeManager().getRecipe(ModRecipes.Types.FORGING, this, world).orElse(null);
    }

    private ItemStack getWorkOutput(@Nullable ForgingRecipe recipe) {
        if (recipe != null) {
            return recipe.getCraftingResult(this);
        }

        return ItemStack.EMPTY;
    }

    private void doWork(ForgingRecipe recipe) {
        assert world != null;
        ItemStack current = getStackInSlot(1);
        ItemStack output = getWorkOutput(recipe);
        if (!current.isEmpty()) {
            int newCount = current.getCount() + output.getCount();

            if (!ItemStack.areItemsEqual(current, output) || newCount > output.getMaxStackSize()) {
                stopWork();
                return;
            }
        }

        if (progress < WORK_TIME) {
            ++progress;
        }

        if(progress >= WORK_TIME) {
            finishWork(recipe, current, output);
        }
    }

    private void finishWork(ForgingRecipe recipe, ItemStack current, ItemStack output) {
        if(!current.isEmpty()) {
            current.grow(output.getCount());
        } else {
            setInventorySlotContents(1, output);
        }

        progress = 0;
        this.decrStackSize(0, 1);
    }

    private void stopWork() {
        progress = 0;
    }
}
