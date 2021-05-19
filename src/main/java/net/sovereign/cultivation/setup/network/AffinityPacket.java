package net.sovereign.cultivation.setup.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.sovereign.cultivation.capabilities.Affinity;

import java.util.function.Supplier;

public class AffinityPacket {
    private int affinity;

    public AffinityPacket(int affinity) {
        this.affinity = affinity;
    }

    public static void encode(AffinityPacket msg, PacketBuffer buf) {
        buf.writeInt(msg.affinity);
    }

    public static AffinityPacket decode(PacketBuffer buf) {
        return new AffinityPacket(buf.readInt());
    }

    public static class Handler {
        public static void handle(AffinityPacket msg, Supplier<NetworkEvent.Context> ctx) {
            Minecraft mc = Minecraft.getInstance();

            ctx.get().enqueueWork(() -> {
                mc.player.getCapability(Affinity.AFFINITY_CAP).ifPresent(cap -> cap.setAffinity(msg.affinity));
            });

            ctx.get().setPacketHandled(true);
        }
    }
}
