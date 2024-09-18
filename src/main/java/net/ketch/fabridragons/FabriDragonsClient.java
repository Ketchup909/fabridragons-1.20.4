package net.ketch.fabridragons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.ketch.fabridragons.entity.ModEntities;
import net.ketch.fabridragons.entity.client.WyvernRenderer;

public class FabriDragonsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.WYVERN, WyvernRenderer::new);




        //EntityModelLayerRegistry.registerModelLayer(ModModelLayers.WYVERN, WyvernModel::getTexturedModelData);

        //EntityModelLayerRegistry.registerModelLayer(ModModelLayers.WYVERN, WyvernModel::getTexturedModelData);
    }
}
