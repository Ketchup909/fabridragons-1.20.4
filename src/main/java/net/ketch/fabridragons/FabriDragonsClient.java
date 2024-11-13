package net.ketch.fabridragons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.ketch.fabridragons.entity.ModEntities;
import net.ketch.fabridragons.entity.client.WyvernRenderer;
import net.ketch.fabridragons.entity.client.init.WyvernKeybinds;
import net.ketch.fabridragons.network.KeyInputC2SPacket;

public class FabriDragonsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.WYVERN, WyvernRenderer::new);
        WyvernKeybinds.init(); //initialize my controls for the dragon hopefully

        KeyInputC2SPacket.init();


    }
}
