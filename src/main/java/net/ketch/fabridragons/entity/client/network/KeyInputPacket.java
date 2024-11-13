package net.ketch.fabridragons.entity.client.network;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.ketch.fabridragons.entity.custom.WyvernEntity;
import net.ketch.fabridragons.network.KeyInputC2SPacket;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;


//hope to fuck this all works I guess.
@Environment(EnvType.CLIENT)
public class KeyInputPacket {
    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;
            if (player != null) {
                Entity vehicle = player.getVehicle();
                if (vehicle instanceof WyvernEntity) {
                    WyvernEntity dragon = (WyvernEntity)vehicle;
                    PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
                    buf.writeBoolean(dragon.isJumpPressed());
                    buf.writeBoolean(dragon.isMoveForwardPressed());
                    buf.writeBoolean(dragon.isMoveBackPressed());
//                    buf.writeBoolean(dragon.isSprintPressed());
//                    buf.writeBoolean(dragon.isSecondaryAttackPressed);
//                    buf.writeBoolean(dragon.isPrimaryAttackPressed);
                    buf.writeBoolean(dragon.isDownPressed());
                    buf.writeInt(dragon.getId());
                    ClientPlayNetworking.send(KeyInputC2SPacket.KEY_INPUT_PACKET, buf);
                }
            }
        });
    }
}
