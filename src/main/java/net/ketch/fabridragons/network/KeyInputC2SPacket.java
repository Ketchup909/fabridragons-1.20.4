package net.ketch.fabridragons.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.ketch.fabridragons.entity.custom.WyvernEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class KeyInputC2SPacket {public static final Identifier KEY_INPUT_PACKET = new Identifier("fabridragons", "key_input");
    public static void init() {
        ServerPlayNetworking.registerGlobalReceiver(KEY_INPUT_PACKET, (server, player, handler, buffer, sender) -> {
            boolean isJumpPressed = buffer.readBoolean();
            boolean isMoveForwardPressed = buffer.readBoolean();
            boolean isMoveBackPressed = buffer.readBoolean();
//            boolean isSprintPressed = buffer.readBoolean();
//            boolean isSecondaryAttackPressed = buffer.readBoolean();
//            boolean isPrimaryAttackPressed = buffer.readBoolean();
            boolean isDownPressed = buffer.readBoolean();
            Entity entity = player.getServerWorld().getEntityById(buffer.readInt());
            if (entity instanceof WyvernEntity) {
                WyvernEntity dragon = (WyvernEntity)entity;
//                dragon.isSecondaryAttackPressed = isSecondaryAttackPressed;
//                dragon.isPrimaryAttackPressed = isPrimaryAttackPressed;
                dragon.updateInputs(isMoveForwardPressed, isMoveBackPressed, isJumpPressed, isDownPressed);
            }
        });
    }
}
