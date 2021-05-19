package net.sovereign.cultivation.setup.network;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.sovereign.cultivation.CultivationMod;

public class PacketHandler {
    private static final String PROTOCOL_VERSION = Integer.toString(1);
    private static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(CultivationMod.MOD_ID, "network"))
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();

    public static void register() {
        HANDLER.registerMessage(1,
                CultivationPacket.class,
                CultivationPacket::encode,
                CultivationPacket::decode,
                CultivationPacket.Handler::handle);
        HANDLER.registerMessage(2,
                AffinityPacket.class,
                AffinityPacket::encode,
                AffinityPacket::decode,
                AffinityPacket.Handler::handle);
    }

    public static void sendTo(Object msg, ServerPlayerEntity player) {
        if(!(player instanceof FakePlayer)) {
            HANDLER.sendTo(msg, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
        }
    }
}
