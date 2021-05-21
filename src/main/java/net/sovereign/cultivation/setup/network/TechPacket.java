package net.sovereign.cultivation.setup.network;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.sovereign.cultivation.capabilities.Tech;

import java.util.function.Supplier;

public class TechPacket {
    private final CompoundNBT nbt;

    public TechPacket(CompoundNBT nbt) {
        this.nbt = nbt;
    }

    public static void encode(TechPacket msg, PacketBuffer buf) {
        buf.writeCompoundTag(msg.nbt);
    }

    public static TechPacket decode(PacketBuffer buf) {
        return new TechPacket(buf.readCompoundTag());
    }

    public static class Handler {
        public static void handle(TechPacket msg, Supplier<NetworkEvent.Context> ctx) {
            Minecraft mc = Minecraft.getInstance();

            ctx.get().enqueueWork(() -> {
                mc.player.getCapability(Tech.TECH_CAP).ifPresent(cap -> cap.deserializeNBT(msg.nbt));
            });

            ctx.get().setPacketHandled(true);
        }
    }
}
