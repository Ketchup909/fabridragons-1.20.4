package net.ketch.fabridragons.entity.client;

import net.ketch.fabridragons.FabriDragons;
import net.ketch.fabridragons.entity.custom.WyvernEntity;
//import net.minecraft.client.render.VertexConsumerProvider;
//import net.minecraft.client.render.entity.EntityRendererFactory;
//import net.minecraft.client.render.entity.MobEntityRenderer;
//import net.minecraft.client.util.math.MatrixStack;
//import net.minecraft.util.Identifier;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WyvernRenderer extends GeoEntityRenderer<WyvernEntity> {
    public WyvernRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new WyvernModel());
    }

    @Override
    public Identifier getTextureLocation(WyvernEntity animatable) {
        return new Identifier(FabriDragons.MOD_ID, "textures/entity/wyvern/grey.png");
    }

    @Override
    public void render(WyvernEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.2f, 0.2f, 0.2f); //make smol
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }


//    private static final Identifier TEXTURE = new Identifier(FabriDragons.MOD_ID, "textures/entity/wyvern/grey.png");
//
//    public WyvernRenderer(EntityRendererFactory.Context context) {
//        super(context, new WyvernModel<>(context.getPart(ModModelLayers.WYVERN)), 0.8f);
//    }
//
//    @Override
//    public Identifier getTexture(WyvernEntity entity) {
//        return TEXTURE;
//    }
//
//    @Override
//    public void render(WyvernEntity mobEntity, float f, float g, MatrixStack matrixStack,
//                       VertexConsumerProvider vertexConsumerProvider, int i){
//
//        if(mobEntity.isBaby()){
//            matrixStack.scale(0.5f, 0.5f, .5f);
//        }
//        else{
//            matrixStack.scale(1f, 1f, 1f);
//        }
//        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
//    }
}
