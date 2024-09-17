package net.ketch.fabridragons.entity.client;

import net.ketch.fabridragons.FabriDragons;
import net.ketch.fabridragons.entity.custom.WyvernEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class WyvernRenderer extends MobEntityRenderer<WyvernEntity, WyvernModel<WyvernEntity>> {

    private static final Identifier TEXTURE = new Identifier(FabriDragons.MOD_ID, "textures/entity/wyvern/grey.png");

    public WyvernRenderer(EntityRendererFactory.Context context) {
        super(context, new WyvernModel<>(context.getPart(ModModelLayers.WYVERN)), 0.8f);
    }

    @Override
    public Identifier getTexture(WyvernEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(WyvernEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i){

        if(mobEntity.isBaby()){
            matrixStack.scale(0.5f, 0.5f, .5f);
        }
        else{
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
