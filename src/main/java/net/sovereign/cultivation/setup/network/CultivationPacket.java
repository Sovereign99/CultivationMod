package net.sovereign.cultivation.setup.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.sovereign.cultivation.capabilities.Cultivation;

import java.util.function.Supplier;

public class CultivationPacket {
    private double cultivationAmount;

    public CultivationPacket(double cultivationAmount) {
        this.cultivationAmount = cultivationAmount;
    }

    public static void encode(CultivationPacket msg, PacketBuffer buf) {
        buf.writeDouble(msg.cultivationAmount);
    }

    public static CultivationPacket decode(PacketBuffer buf) {
        return new CultivationPacket(buf.readDouble());
    }

    public static class Handler {
        public static void handle( CultivationPacket msg, Supplier<NetworkEvent.Context> ctx) {
            Minecraft mc = Minecraft.getInstance();

            ctx.get().enqueueWork(() -> {
                mc.player.getCapability(Cultivation.CULTIVATION_CAP).ifPresent(cap -> cap.setCultivationAmount(msg.cultivationAmount));
            });

            ctx.get().setPacketHandled(true);
        }
    }

}
