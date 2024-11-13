package net.ketch.fabridragons.network;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.ketch.fabridragons.entity.custom.WyvernEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class KeyInputSyncS2CPacket {public static final Identifier KEY_INPUT_SYNC_PACKET = new Identifier("fabridragons", "key_input_sync_packet");

    public static void send(ServerPlayerEntity player, WyvernEntity dragon) {
        if (dragon.canBeControlledByRider()) {
            PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
            buf.writeBoolean(dragon.isJumpPressed());
            buf.writeBoolean(dragon.isMoveForwardPressed());
            buf.writeBoolean(dragon.isMoveBackPressed());
//            buf.writeBoolean(dragon.isSprintPressed());
//            buf.writeBoolean(dragon.isSecondaryAttackPressed);
//            buf.writeBoolean(dragon.isPrimaryAttackPressed);
            buf.writeBoolean(dragon.isDownPressed());
            buf.writeInt(dragon.getId());
            ServerPlayNetworking.send(player, KEY_INPUT_SYNC_PACKET, buf);
        }
    }
}
