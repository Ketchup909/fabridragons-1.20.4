package net.ketch.fabridragons.entity.client.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.ketch.fabridragons.entity.custom.WyvernEntity;
import net.ketch.fabridragons.network.PosS2CSyncPacket;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

public class PositionSyncPacket {
    public static void init() {
        ClientPlayNetworking.registerGlobalReceiver(PosS2CSyncPacket.POS_SYNC_PACKET, (client, handler, buffer, sender) -> {
            Vec3d pos = new Vec3d(buffer.readDouble(), buffer.readDouble(), buffer.readDouble());
            WyvernEntity dragon = (WyvernEntity) MinecraftClient.getInstance().world.getEntityById(buffer.readInt());
            client.execute(()->{
                dragon.setPosition(pos.x, pos.y, pos.z);
            });
        });
    }
}
