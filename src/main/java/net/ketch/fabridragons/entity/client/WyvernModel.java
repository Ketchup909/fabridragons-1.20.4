package net.ketch.fabridragons.entity.client;

import net.ketch.fabridragons.FabriDragons;
import net.ketch.fabridragons.entity.custom.WyvernEntity;
import net.minecraft.util.math.MathHelper;

import net.minecraft.util.Identifier;

import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class WyvernModel extends GeoModel<WyvernEntity>{
	@Override
	public Identifier getModelResource(WyvernEntity animatable) {
		return new Identifier(FabriDragons.MOD_ID, "geo/wyvern.geo.json");
	}

	@Override
	public Identifier getTextureResource(WyvernEntity animatable) {
		return new Identifier(FabriDragons.MOD_ID, "textures/entity/wyvern/grey.png");
	}

	@Override
	public Identifier getAnimationResource(WyvernEntity animatable) {
		return new Identifier(FabriDragons.MOD_ID, "animations/wyvern.animation.json");
	}

	//@Override
//	public void setCustomAnimations(WyvernEntity animatable, long instanceId, AnimationState<WyvernEntity> animationState) {
//		CoreGeoBone head = getAnimationProcessor().getBone("head"); //so much more elegant than default minecraft getchild method
//
//		if (head != null) {
//			EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
//			head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
//			head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
//		}
//	}
}