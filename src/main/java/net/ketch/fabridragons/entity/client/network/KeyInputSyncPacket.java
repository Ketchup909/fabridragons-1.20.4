package net.ketch.fabridragons.entity.client.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.ketch.fabridragons.entity.custom.WyvernEntity;
import net.minecraft.util.Identifier;

public class KeyInputSyncPacket {

    public static final Identifier KEY_INPUT_PACKET = new Identifier("fabridragons", "key_input");
    public static void init() {
        ClientPlayNetworking.registerGlobalReceiver(KeyInputSyncPacket.KEY_INPUT_PACKET, (client, handler, buffer, sender) -> {
            boolean isJumpPressed = buffer.readBoolean();
            boolean isMoveForwardPressed = buffer.readBoolean();
            boolean isMoveBackPressed = buffer.readBoolean();
            //boolean isSprintPressed = buffer.readBoolean();
            boolean isMeleeAttackPressed = buffer.readBoolean();
            boolean isRangeAttackPressed = buffer.readBoolean();
            boolean isDownPressed = buffer.readBoolean();
            WyvernEntity dragon = (client.getNetworkHandler() != null) ?
                    (WyvernEntity) client.getInstance().world.getEntityById(buffer.readInt()) : null;
            client.execute(()->{
                if (dragon != null) {
                    // Handle the inputs here, e.g.:
                    dragon.updateInputs(isMoveForwardPressed, isMoveBackPressed, isJumpPressed, isDownPressed);
                }
            });
        });
    }
}
