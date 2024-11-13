package net.ketch.fabridragons.network;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.ketch.fabridragons.entity.custom.WyvernEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class PosS2CSyncPacket {
    public static final Identifier POS_SYNC_PACKET = new Identifier("fabridragons", "pos_sync_packet");


    //this appears to only account for height.
    public static void send(ServerPlayerEntity player, WyvernEntity dragon) {
        if (dragon.canBeControlledByRider()) {
            PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
            buf.writeDouble(dragon.getPos().getY());
            buf.writeInt(dragon.getId());
            ServerPlayNetworking.send(player, POS_SYNC_PACKET, buf);
        }
    }
}
