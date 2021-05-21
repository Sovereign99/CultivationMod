package net.sovereign.cultivation.setup.network;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.sovereign.cultivation.capabilities.Affinity;

import java.util.function.Supplier;

public class AffinityPacket {
    private final CompoundNBT nbt;

    public AffinityPacket(CompoundNBT nbt) {
        this.nbt = nbt;
    }

    public static void encode(AffinityPacket msg, PacketBuffer buf) {
        buf.writeCompoundTag(msg.nbt);
    }

    public static AffinityPacket decode(PacketBuffer buf) {
        return new AffinityPacket(buf.readCompoundTag());
    }

    public static class Handler {
        public static void handle(AffinityPacket msg, Supplier<NetworkEvent.Context> ctx) {
            Minecraft mc = Minecraft.getInstance();

            ctx.get().enqueueWork(() -> {
                mc.player.getCapability(Affinity.AFFINITY_CAP).ifPresent(cap -> cap.deserializeNBT(msg.nbt));
            });

            ctx.get().setPacketHandled(true);
        }
    }
}
