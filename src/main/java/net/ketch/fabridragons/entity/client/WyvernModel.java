package net.ketch.fabridragons.entity.client;

import net.ketch.fabridragons.entity.custom.WyvernEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class WyvernModel<T extends WyvernEntity> extends SinglePartEntityModel<T> {
	private final ModelPart wyvern;
	private final ModelPart head;

	public WyvernModel(ModelPart root) {
		this.wyvern = root.getChild("wyvern");
		this.head = wyvern.getChild("neck").getChild("neckbase").getChild("neck2").getChild("neck3").getChild("head");

	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData wyvern = modelPartData.addChild("wyvern", ModelPartBuilder.create().uv(121, 211).cuboid(-0.0583F, 5.6804F, -19.2452F, 0.0F, 17.0F, 28.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0583F, -23.8655F, -28.7501F));

		ModelPartData frill_r1 = wyvern.addChild("frill_r1", ModelPartBuilder.create().uv(0, 17).cuboid(-1.0F, -9.0F, -1.0F, 0.0F, 9.0F, 21.0F, new Dilation(0.0F)), ModelTransform.of(3.4466F, -3.3196F, -6.2452F, 0.0873F, 0.0F, 0.4363F));

		ModelPartData frill_r2 = wyvern.addChild("frill_r2", ModelPartBuilder.create().uv(0, 26).cuboid(1.0F, -9.0F, -1.0F, 0.0F, 9.0F, 21.0F, new Dilation(0.0F)), ModelTransform.of(-3.5632F, -3.3196F, -6.2452F, 0.0873F, 0.0F, -0.4363F));

		ModelPartData Chest_r1 = wyvern.addChild("Chest_r1", ModelPartBuilder.create().uv(253, 130).cuboid(-15.8414F, -22.0F, -3.1586F, 19.0F, 22.0F, 30.0F, new Dilation(0.0F)), ModelTransform.of(6.2831F, 14.9209F, -11.2452F, 0.0873F, 0.0F, 0.0F));

		ModelPartData neck = wyvern.addChild("neck", ModelPartBuilder.create(), ModelTransform.pivot(-0.0583F, 12.0459F, -11.2452F));

		ModelPartData neckbase = neck.addChild("neckbase", ModelPartBuilder.create(), ModelTransform.of(-0.0291F, -13.6064F, -4.7569F, 0.48F, 0.0F, 0.0F));

		ModelPartData frill_r3 = neckbase.addChild("frill_r3", ModelPartBuilder.create().uv(257, 276).cuboid(-1.0F, -7.0F, -1.0F, 0.0F, 7.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(2.9041F, -5.3936F, -4.2431F, -0.3927F, 0.3054F, 0.3927F));

		ModelPartData frill_r4 = neckbase.addChild("frill_r4", ModelPartBuilder.create().uv(46, 283).cuboid(1.0F, -7.0F, -1.0F, 0.0F, 7.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(-2.8459F, -5.3936F, -4.2431F, -0.3927F, -0.3054F, -0.3927F));

		ModelPartData twinspike_r1 = neckbase.addChild("twinspike_r1", ModelPartBuilder.create().uv(29, 212).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(5.9041F, -3.3936F, -1.2431F, -0.0873F, 0.3927F, 0.0F));

		ModelPartData twinspike_r2 = neckbase.addChild("twinspike_r2", ModelPartBuilder.create().uv(22, 242).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-5.8459F, -3.3936F, -1.2431F, -0.0873F, -0.3927F, 0.0F));

		ModelPartData cube_r1 = neckbase.addChild("cube_r1", ModelPartBuilder.create().uv(0, 147).cuboid(-1.5625F, -9.0F, -1.4375F, 3.0F, 9.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(5.1849F, 1.7939F, -12.4931F, -0.5672F, 0.1309F, 0.0F));

		ModelPartData cube_r2 = neckbase.addChild("cube_r2", ModelPartBuilder.create().uv(0, 173).cuboid(-1.5625F, -9.0F, -1.4375F, 3.0F, 9.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(-5.0026F, 1.7939F, -12.4931F, -0.5672F, -0.1309F, 0.0F));

		ModelPartData cube_r3 = neckbase.addChild("cube_r3", ModelPartBuilder.create().uv(321, 316).cuboid(-9.5601F, -15.0F, -3.1586F, 12.0F, 15.0F, 22.0F, new Dilation(0.0F)), ModelTransform.of(3.5893F, 6.4095F, -11.0362F, -0.5236F, 0.0F, 0.0F));

		ModelPartData cube_r4 = neckbase.addChild("cube_r4", ModelPartBuilder.create().uv(50, 263).cuboid(-3.0F, -6.0F, -1.0F, 4.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(1.0291F, 8.6064F, -7.2431F, -0.8727F, 0.0F, 0.0F));

		ModelPartData neck2 = neckbase.addChild("neck2", ModelPartBuilder.create(), ModelTransform.pivot(0.0291F, -1.3262F, -10.3958F));

		ModelPartData frill_r5 = neck2.addChild("frill_r5", ModelPartBuilder.create().uv(185, 258).cuboid(-1.0F, -6.0F, -1.0F, 0.0F, 6.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(1.875F, -11.0673F, -7.8473F, -0.3927F, 0.2618F, 0.4363F));

		ModelPartData frill_r6 = neck2.addChild("frill_r6", ModelPartBuilder.create().uv(240, 261).cuboid(1.0F, -6.0F, -1.0F, 0.0F, 6.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(-1.875F, -11.0673F, -7.8473F, -0.3927F, -0.2618F, -0.4363F));

		ModelPartData twinspike_r3 = neck2.addChild("twinspike_r3", ModelPartBuilder.create().uv(74, 285).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(3.875F, -8.0673F, -6.8473F, 0.0873F, 0.3927F, 0.0F));

		ModelPartData twinspike_r4 = neck2.addChild("twinspike_r4", ModelPartBuilder.create().uv(74, 263).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(3.875F, -5.0673F, 3.1527F, 0.0873F, 0.3927F, 0.0F));

		ModelPartData twinspike_r5 = neck2.addChild("twinspike_r5", ModelPartBuilder.create().uv(266, 278).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-3.875F, -5.0673F, 3.1527F, 0.0873F, -0.3927F, 0.0F));

		ModelPartData twinspike_r6 = neck2.addChild("twinspike_r6", ModelPartBuilder.create().uv(212, 306).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-3.875F, -8.0673F, -6.8473F, 0.0873F, -0.3927F, 0.0F));

		ModelPartData cube_r5 = neck2.addChild("cube_r5", ModelPartBuilder.create().uv(240, 250).cuboid(-5.8414F, -12.0F, -3.1586F, 9.0F, 12.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(1.3414F, -0.3027F, -10.6835F, -0.4363F, 0.0F, 0.0F));

		ModelPartData neck3 = neck2.addChild("neck3", ModelPartBuilder.create().uv(0, 56).cuboid(-3.5F, 0.0979F, -8.193F, 7.0F, 9.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -12.0152F, -13.7418F, -0.3491F, 0.0F, 0.0F));

		ModelPartData twinspike_r7 = neck3.addChild("twinspike_r7", ModelPartBuilder.create().uv(344, 48).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(2.875F, 1.9479F, -2.1055F, 0.3927F, 0.2618F, 0.0F));

		ModelPartData frill_r7 = neck3.addChild("frill_r7", ModelPartBuilder.create().uv(185, 265).cuboid(-1.0F, -6.0F, -1.0F, 0.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(1.875F, 0.9479F, -7.1055F, 0.0F, 0.0F, 0.48F));

		ModelPartData frill_r8 = neck3.addChild("frill_r8", ModelPartBuilder.create().uv(50, 269).cuboid(1.0F, -6.0F, -1.0F, 0.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(-1.875F, 0.9479F, -7.1055F, 0.0F, 0.0F, -0.48F));

		ModelPartData twinspike_r8 = neck3.addChild("twinspike_r8", ModelPartBuilder.create().uv(344, 58).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-2.875F, 1.9479F, -2.1055F, 0.3927F, -0.2618F, 0.0F));

		ModelPartData head = neck3.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 3.3138F, -4.8677F));

		ModelPartData cube_r6 = head.addChild("cube_r6", ModelPartBuilder.create().uv(0, 156).cuboid(-1.15F, -2.0F, -1.15F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(3.8299F, 4.6341F, -3.0378F, -0.3054F, 0.3491F, 0.0F));

		ModelPartData cube_r7 = head.addChild("cube_r7", ModelPartBuilder.create().uv(23, 147).cuboid(-1.15F, -1.0F, -1.15F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(4.9799F, 4.6341F, 0.4122F, -0.3491F, 0.3491F, 0.0F));

		ModelPartData cube_r8 = head.addChild("cube_r8", ModelPartBuilder.create().uv(94, 251).cuboid(-1.15F, -1.0F, -1.15F, 2.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(6.1299F, 0.0341F, 1.5622F, 0.0F, 0.3491F, 0.0F));

		ModelPartData cube_r9 = head.addChild("cube_r9", ModelPartBuilder.create().uv(23, 154).cuboid(-1.15F, -2.0F, -1.15F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.8299F, 1.1841F, -3.0378F, 0.0F, 0.3491F, 0.0F));

		ModelPartData cube_r10 = head.addChild("cube_r10", ModelPartBuilder.create().uv(311, 200).cuboid(-1.4375F, -2.0F, -1.4375F, 2.0F, 2.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(6.4174F, -4.4284F, 3.9997F, 0.2618F, 0.2618F, 0.0F));

		ModelPartData cube_r11 = head.addChild("cube_r11", ModelPartBuilder.create().uv(112, 339).cuboid(-1.4375F, -3.0F, -1.4375F, 2.0F, 3.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(4.4049F, -1.2659F, -5.0503F, 0.2618F, 0.2618F, 0.0F));

		ModelPartData cube_r12 = head.addChild("cube_r12", ModelPartBuilder.create().uv(139, 169).cuboid(-0.85F, -1.0F, -1.15F, 2.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-4.9799F, 4.6341F, 0.4122F, -0.3491F, -0.3491F, 0.0F));

		ModelPartData cube_r13 = head.addChild("cube_r13", ModelPartBuilder.create().uv(139, 161).cuboid(-0.85F, -2.0F, -1.15F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.8299F, 4.6341F, -3.0378F, -0.3054F, -0.3491F, 0.0F));

		ModelPartData cube_r14 = head.addChild("cube_r14", ModelPartBuilder.create().uv(68, 298).cuboid(-0.85F, -1.0F, -1.15F, 2.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-6.1299F, 0.0341F, 1.5622F, 0.0F, -0.3491F, 0.0F));

		ModelPartData cube_r15 = head.addChild("cube_r15", ModelPartBuilder.create().uv(23, 173).cuboid(-0.85F, -2.0F, -1.15F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-3.8299F, 1.1841F, -3.0378F, 0.0F, -0.3491F, 0.0F));

		ModelPartData cube_r16 = head.addChild("cube_r16", ModelPartBuilder.create().uv(253, 319).cuboid(-0.5625F, -2.0F, -1.4375F, 2.0F, 2.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(-6.4174F, -4.4284F, 3.9997F, 0.2618F, -0.2618F, 0.0F));

		ModelPartData cube_r17 = head.addChild("cube_r17", ModelPartBuilder.create().uv(142, 339).cuboid(-0.5625F, -3.0F, -1.4375F, 2.0F, 3.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(-4.4049F, -1.2659F, -5.0503F, 0.2618F, -0.2618F, 0.0F));

		ModelPartData upperjaw_r1 = head.addChild("upperjaw_r1", ModelPartBuilder.create().uv(0, 276).cuboid(-5.5625F, -6.0F, -1.4375F, 7.0F, 6.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(2.0625F, 5.7841F, -20.8628F, 0.2182F, 0.0F, 0.0F));

		ModelPartData cube_r18 = head.addChild("cube_r18", ModelPartBuilder.create().uv(170, 300).cuboid(-8.2813F, -10.0F, -1.4375F, 9.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(3.7813F, 7.2216F, -9.6503F, 0.1745F, 0.0F, 0.0F));

		ModelPartData lowerjaw = head.addChild("lowerjaw", ModelPartBuilder.create(), ModelTransform.pivot(-2.875F, 27.6341F, 33.7622F));

		ModelPartData cube_r19 = lowerjaw.addChild("cube_r19", ModelPartBuilder.create().uv(264, 302).cuboid(-5.2813F, -3.0F, -1.4375F, 6.0F, 3.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(5.0781F, -20.4125F, -54.625F, 0.0873F, 0.0F, 0.0F));

		ModelPartData abdomen = wyvern.addChild("abdomen", ModelPartBuilder.create().uv(321, 105).cuboid(-8.0817F, -1.5306F, -10.7917F, 16.0F, 15.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0234F, -7.4765F, 20.8589F));

		ModelPartData frill_r9 = abdomen.addChild("frill_r9", ModelPartBuilder.create().uv(0, 15).cuboid(-1.0F, -6.0F, -1.0F, 0.0F, 6.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(4.9183F, 0.1569F, -7.1042F, 0.0F, 0.0F, 0.4363F));

		ModelPartData frill_r10 = abdomen.addChild("frill_r10", ModelPartBuilder.create().uv(238, 58).cuboid(1.0F, -6.0F, -1.0F, 0.0F, 6.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(-5.0817F, 0.1569F, -7.1042F, 0.0F, 0.0F, -0.4363F));

		ModelPartData hips = abdomen.addChild("hips", ModelPartBuilder.create().uv(183, 336).cuboid(-9.2788F, -5.1654F, -7.4741F, 18.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.1971F, 4.0722F, 14.1824F));

		ModelPartData cube_r20 = hips.addChild("cube_r20", ModelPartBuilder.create().uv(0, 212).cuboid(-5.5625F, -9.0F, -1.4375F, 7.0F, 9.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(1.7837F, 10.8346F, -10.3491F, -0.4363F, 0.0F, 0.0F));

		ModelPartData frill_r11 = hips.addChild("frill_r11", ModelPartBuilder.create().uv(100, 285).cuboid(-1.0F, -6.0F, -1.0F, 0.0F, 6.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(4.7212F, -2.9154F, -5.2866F, 0.0F, 0.0F, 0.3491F));

		ModelPartData frill_r12 = hips.addChild("frill_r12", ModelPartBuilder.create().uv(198, 285).cuboid(1.0F, -6.0F, -1.0F, 0.0F, 6.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(-5.2788F, -2.9154F, -5.2866F, 0.0F, 0.0F, -0.3491F));

		ModelPartData tail = hips.addChild("tail", ModelPartBuilder.create().uv(115, 300).cuboid(-6.5556F, -2.1144F, -4.0894F, 13.0F, 10.0F, 29.0F, new Dilation(0.0F)), ModelTransform.of(-0.2857F, -1.3635F, 9.5529F, -0.4363F, 0.0F, 0.0F));

		ModelPartData twinspike_r9 = tail.addChild("twinspike_r9", ModelPartBuilder.create().uv(0, 339).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(6.0069F, 1.4481F, 3.1606F, 0.0F, 0.6545F, 0.0F));

		ModelPartData twinspike_r10 = tail.addChild("twinspike_r10", ModelPartBuilder.create().uv(253, 338).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(6.0069F, 1.4481F, 13.1606F, 0.0F, 0.5236F, 0.0F));

		ModelPartData twinspike_r11 = tail.addChild("twinspike_r11", ModelPartBuilder.create().uv(334, 86).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(5.0069F, 1.4481F, 23.1606F, 0.0F, 0.5236F, 0.0F));

		ModelPartData twinspike_r12 = tail.addChild("twinspike_r12", ModelPartBuilder.create().uv(235, 336).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(-4.9931F, 1.4481F, 23.1606F, 0.0F, -0.5236F, 0.0F));

		ModelPartData twinspike_r13 = tail.addChild("twinspike_r13", ModelPartBuilder.create().uv(285, 338).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(-5.9931F, 1.4481F, 13.1606F, 0.0F, -0.5236F, 0.0F));

		ModelPartData twinspike_r14 = tail.addChild("twinspike_r14", ModelPartBuilder.create().uv(32, 339).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(-5.9931F, 1.4481F, 3.1606F, 0.0F, -0.6545F, 0.0F));

		ModelPartData frill_r13 = tail.addChild("frill_r13", ModelPartBuilder.create().uv(50, 225).cuboid(-1.0F, -4.0F, -1.0F, 0.0F, 4.0F, 26.0F, new Dilation(0.0F)), ModelTransform.of(3.0069F, -0.5519F, 0.1606F, 0.0F, 0.0F, 0.4363F));

		ModelPartData frill_r14 = tail.addChild("frill_r14", ModelPartBuilder.create().uv(50, 229).cuboid(1.0F, -4.0F, -1.0F, 0.0F, 4.0F, 26.0F, new Dilation(0.0F)), ModelTransform.of(-2.9931F, -0.5519F, 0.1606F, 0.0F, 0.0F, -0.4363F));

		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(311, 200).cuboid(-5.0F, -2.0619F, -3.4167F, 10.0F, 9.0F, 26.0F, new Dilation(0.0F)), ModelTransform.of(0.0069F, -0.49F, 23.7647F, 0.1309F, 0.0F, 0.0F));

		ModelPartData frill_r15 = tail2.addChild("frill_r15", ModelPartBuilder.create().uv(0, 215).cuboid(-1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 21.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -1.0619F, 2.3958F, 0.0F, -0.0873F, 0.3491F));

		ModelPartData frill_r16 = tail2.addChild("frill_r16", ModelPartBuilder.create().uv(0, 218).cuboid(1.0F, -3.0F, -1.0F, 0.0F, 3.0F, 21.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -1.0619F, 2.3958F, 0.0F, 0.0873F, -0.3491F));

		ModelPartData twinspike_r15 = tail2.addChild("twinspike_r15", ModelPartBuilder.create().uv(333, 292).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 1.9381F, 5.3958F, 0.0F, 0.48F, 0.0F));

		ModelPartData twinspike_r16 = tail2.addChild("twinspike_r16", ModelPartBuilder.create().uv(194, 306).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 1.9381F, 16.3958F, 0.0F, 0.48F, 0.0F));

		ModelPartData twinspike_r17 = tail2.addChild("twinspike_r17", ModelPartBuilder.create().uv(271, 318).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 1.9381F, 16.3958F, 0.0F, -0.48F, 0.0F));

		ModelPartData twinspike_r18 = tail2.addChild("twinspike_r18", ModelPartBuilder.create().uv(334, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 1.9381F, 5.3958F, 0.0F, -0.48F, 0.0F));

		ModelPartData tail3 = tail2.addChild("tail3", ModelPartBuilder.create().uv(0, 183).cuboid(-0.0104F, -4.7604F, -0.2676F, 0.0F, 5.0F, 24.0F, new Dilation(0.0F))
		.uv(338, 49).cuboid(-3.4479F, -2.1979F, -2.0801F, 7.0F, 7.0F, 26.0F, new Dilation(0.0F)), ModelTransform.of(0.0104F, 0.6985F, 21.6634F, 0.0873F, 0.0F, 0.0F));

		ModelPartData cube_r21 = tail3.addChild("cube_r21", ModelPartBuilder.create().uv(86, 345).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(1.9896F, 1.2396F, 4.7324F, 0.0F, 0.48F, 0.0F));

		ModelPartData cube_r22 = tail3.addChild("cube_r22", ModelPartBuilder.create().uv(344, 37).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(1.9896F, 1.2396F, 13.7324F, 0.0F, 0.48F, 0.0F));

		ModelPartData cube_r23 = tail3.addChild("cube_r23", ModelPartBuilder.create().uv(64, 345).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-2.0104F, 1.2396F, 13.7324F, 0.0F, -0.48F, 0.0F));

		ModelPartData cube_r24 = tail3.addChild("cube_r24", ModelPartBuilder.create().uv(308, 345).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-2.0104F, 1.2396F, 4.7324F, 0.0F, -0.48F, 0.0F));

		ModelPartData tail4 = tail3.addChild("tail4", ModelPartBuilder.create().uv(0, 178).cuboid(-0.0104F, -3.9375F, -0.6114F, 0.0F, 5.0F, 24.0F, new Dilation(0.0F))
		.uv(53, 310).cuboid(-3.4479F, -1.8125F, -3.8614F, 7.0F, 6.0F, 29.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.1771F, 23.3437F, 0.0436F, 0.0F, 0.0F));

		ModelPartData cube_r25 = tail4.addChild("cube_r25", ModelPartBuilder.create().uv(159, 339).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(1.9896F, 1.0625F, 2.3886F, 0.0F, 0.48F, 0.0F));

		ModelPartData cube_r26 = tail4.addChild("cube_r26", ModelPartBuilder.create().uv(121, 316).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(1.9896F, 1.0625F, 13.3886F, 0.0F, 0.48F, 0.0F));

		ModelPartData cube_r27 = tail4.addChild("cube_r27", ModelPartBuilder.create().uv(199, 322).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-2.0104F, 1.0625F, 13.3886F, 0.0F, -0.48F, 0.0F));

		ModelPartData cube_r28 = tail4.addChild("cube_r28", ModelPartBuilder.create().uv(172, 341).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-2.0104F, 1.0625F, 2.3886F, 0.0F, -0.48F, 0.0F));

		ModelPartData tail5 = tail4.addChild("tail5", ModelPartBuilder.create().uv(0, 298).cuboid(-2.6554F, -1.7083F, -3.2083F, 5.0F, 5.0F, 36.0F, new Dilation(0.0F))
		.uv(149, 239).cuboid(-9.9223F, -0.3958F, 1.6042F, 9.0F, 0.0F, 36.0F, new Dilation(0.0F))
		.uv(85, 202).cuboid(1.0777F, -0.3958F, 1.6042F, 9.0F, 0.0F, 36.0F, new Dilation(0.0F)), ModelTransform.of(-0.0881F, 0.4583F, 23.7845F, 0.0873F, 0.0F, 0.0F));

		ModelPartData Rightleg = hips.addChild("Rightleg", ModelPartBuilder.create(), ModelTransform.pivot(-0.2788F, 52.0846F, -10.2866F));

		ModelPartData thigh = Rightleg.addChild("thigh", ModelPartBuilder.create().uv(0, 242).cuboid(-3.4688F, -4.2843F, -7.4872F, 6.0F, 24.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.1563F, -50.9032F, 8.8622F));

		ModelPartData cube_r29 = thigh.addChild("cube_r29", ModelPartBuilder.create().uv(0, 81).cuboid(-5.5625F, -21.0F, -1.4375F, 7.0F, 21.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(2.5313F, 18.2782F, -6.0497F, -0.3927F, 0.0F, 0.0F));

		ModelPartData midleg = thigh.addChild("midleg", ModelPartBuilder.create(), ModelTransform.pivot(-0.4688F, 16.2489F, -7.5092F));

		ModelPartData cube_r30 = midleg.addChild("cube_r30", ModelPartBuilder.create().uv(0, 298).cuboid(-4.5625F, -23.0F, -1.4375F, 6.0F, 23.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(1.5625F, 20.7168F, 10.0845F, 0.4363F, 0.0F, 0.0F));

		ModelPartData lowerleg = midleg.addChild("lowerleg", ModelPartBuilder.create(), ModelTransform.pivot(0.9674F, 17.0542F, 12.0133F));

		ModelPartData cube_r31 = lowerleg.addChild("cube_r31", ModelPartBuilder.create().uv(30, 56).cuboid(-1.5625F, -12.0F, -1.4375F, 3.0F, 12.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(2.0326F, 15.1627F, -3.3663F, -0.2618F, 0.0F, -0.1745F));

		ModelPartData cube_r32 = lowerleg.addChild("cube_r32", ModelPartBuilder.create().uv(310, 302).cuboid(-4.5625F, -21.0F, -1.4375F, 6.0F, 21.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.5951F, 15.1627F, -10.5538F, -0.4363F, 0.0F, 0.0F));

		ModelPartData foot = lowerleg.addChild("foot", ModelPartBuilder.create().uv(96, 310).cuboid(-4.0032F, -2.8547F, -8.0186F, 7.0F, 5.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.9642F, 15.8923F, -6.8477F));

		ModelPartData cube_r33 = foot.addChild("cube_r33", ModelPartBuilder.create().uv(25, 81).cuboid(0.4375F, -1.0F, -1.4375F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-4.1907F, 1.1453F, -13.7686F, 0.48F, 0.2182F, 0.0F));

		ModelPartData cube_r34 = foot.addChild("cube_r34", ModelPartBuilder.create().uv(351, 165).cuboid(-1.5625F, -3.0F, -1.4375F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.7532F, 2.1453F, -10.8936F, 0.1309F, 0.1745F, 0.0F));

		ModelPartData cube_r35 = foot.addChild("cube_r35", ModelPartBuilder.create().uv(0, 147).cuboid(0.4375F, -2.0F, -1.4375F, 1.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(2.9968F, 1.7078F, -16.6436F, 0.48F, -0.1745F, 0.0F));

		ModelPartData cube_r36 = foot.addChild("cube_r36", ModelPartBuilder.create().uv(129, 339).cuboid(-1.5625F, -4.0F, -1.4375F, 3.0F, 4.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(2.9968F, 2.1453F, -12.3311F, 0.0873F, -0.1745F, 0.0F));

		ModelPartData Leftleg = hips.addChild("Leftleg", ModelPartBuilder.create(), ModelTransform.pivot(-4.2788F, 28.0846F, -46.2866F));

		ModelPartData thigh2 = Leftleg.addChild("thigh2", ModelPartBuilder.create().uv(0, 113).cuboid(-2.5313F, -6.2843F, -6.4872F, 6.0F, 24.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(11.1563F, -24.9032F, 43.8622F));

		ModelPartData cube_r37 = thigh2.addChild("cube_r37", ModelPartBuilder.create().uv(0, 0).cuboid(-1.4375F, -21.0F, -1.4375F, 7.0F, 21.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(-2.5313F, 16.2782F, -5.0497F, -0.3927F, 0.0F, 0.0F));

		ModelPartData midleg2 = thigh2.addChild("midleg2", ModelPartBuilder.create(), ModelTransform.pivot(0.4687F, 16.2489F, -3.5092F));

		ModelPartData cube_r38 = midleg2.addChild("cube_r38", ModelPartBuilder.create().uv(203, 239).cuboid(-1.4375F, -23.0F, -1.4375F, 6.0F, 23.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-1.5625F, 18.7168F, 7.0845F, 0.4363F, 0.0F, 0.0F));

		ModelPartData lowerleg2 = midleg2.addChild("lowerleg2", ModelPartBuilder.create(), ModelTransform.pivot(-0.9674F, 14.0542F, 10.0133F));

		ModelPartData cube_r39 = lowerleg2.addChild("cube_r39", ModelPartBuilder.create().uv(0, 56).cuboid(-1.4375F, -12.0F, -1.4375F, 3.0F, 12.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-2.0326F, 16.1627F, -4.3663F, -0.2618F, 0.0F, 0.1745F));

		ModelPartData cube_r40 = lowerleg2.addChild("cube_r40", ModelPartBuilder.create().uv(238, 302).cuboid(-1.4375F, -21.0F, -1.4375F, 6.0F, 21.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-0.5951F, 16.1627F, -11.5538F, -0.4363F, 0.0F, 0.0F));

		ModelPartData foot2 = lowerleg2.addChild("foot2", ModelPartBuilder.create().uv(46, 310).cuboid(-2.9968F, -2.8547F, -8.0186F, 7.0F, 5.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.9642F, 16.8923F, -7.8477F));

		ModelPartData cube_r41 = foot2.addChild("cube_r41", ModelPartBuilder.create().uv(25, 0).cuboid(-1.4375F, -1.0F, -1.4375F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(4.1907F, 1.1453F, -13.7686F, 0.48F, -0.2182F, 0.0F));

		ModelPartData cube_r42 = foot2.addChild("cube_r42", ModelPartBuilder.create().uv(351, 155).cuboid(-1.4375F, -3.0F, -1.4375F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(2.7532F, 2.1453F, -10.8936F, 0.1309F, -0.1745F, 0.0F));

		ModelPartData cube_r43 = foot2.addChild("cube_r43", ModelPartBuilder.create().uv(22, 113).cuboid(-1.4375F, -2.0F, -1.4375F, 1.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.9968F, 1.7078F, -16.6436F, 0.48F, 0.1745F, 0.0F));

		ModelPartData cube_r44 = foot2.addChild("cube_r44", ModelPartBuilder.create().uv(18, 339).cuboid(-1.4375F, -4.0F, -1.4375F, 3.0F, 4.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-2.9968F, 2.1453F, -12.3311F, 0.0873F, 0.1745F, 0.0F));

		ModelPartData rightwing = wyvern.addChild("rightwing", ModelPartBuilder.create().uv(249, 75).cuboid(-32.5144F, -1.39F, -5.0419F, 32.0F, 0.0F, 25.0F, new Dilation(0.0F))
		.uv(321, 140).cuboid(-32.9856F, -1.61F, -11.9581F, 35.0F, 6.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-11.6689F, -6.0546F, -4.2034F, 0.251F, 0.4282F, -0.1625F));

		ModelPartData forearm = rightwing.addChild("forearm", ModelPartBuilder.create(), ModelTransform.of(-29.6549F, -0.3887F, -7.2756F, 0.4124F, -0.27F, -0.93F));

		ModelPartData cube_r45 = forearm.addChild("cube_r45", ModelPartBuilder.create().uv(298, 268).cuboid(-49.3612F, -5.0F, -1.6387F, 51.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.5331F, 3.5012F, -3.0437F, 0.0F, -0.3054F, 0.0F));

		ModelPartData membrane_r1 = forearm.addChild("membrane_r1", ModelPartBuilder.create().uv(118, 123).cuboid(-55.0F, 0.0F, -1.0F, 56.0F, 0.0F, 37.0F, new Dilation(0.0F)), ModelTransform.of(6.1406F, -1.0013F, 1.2338F, 0.0F, -0.3491F, 0.0F));

		ModelPartData finger4 = forearm.addChild("finger4", ModelPartBuilder.create(), ModelTransform.of(-44.301F, 0.3625F, -9.8299F, 0.0F, 0.3927F, 0.0F));

		ModelPartData cube_r46 = finger4.addChild("cube_r46", ModelPartBuilder.create().uv(243, 250).cuboid(-1.3612F, -3.0F, -1.6388F, 3.0F, 3.0F, 49.0F, new Dilation(0.0F)), ModelTransform.of(-1.0509F, 1.5F, -3.0464F, 0.0F, 0.2618F, 0.0F));

		ModelPartData fingertip4 = finger4.addChild("fingertip4", ModelPartBuilder.create(), ModelTransform.pivot(-1.0509F, 1.5F, -3.0464F));

		ModelPartData membrane_r2 = fingertip4.addChild("membrane_r2", ModelPartBuilder.create().uv(96, 38).cuboid(-47.0F, 0.0F, -1.0F, 48.0F, 0.0F, 46.0F, new Dilation(0.0F)), ModelTransform.of(28.0F, -2.0F, 24.0F, 0.0F, 0.2618F, 0.0F));

		ModelPartData cube_r47 = fingertip4.addChild("cube_r47", ModelPartBuilder.create().uv(271, 302).cuboid(-1.3613F, -3.0F, -1.6387F, 3.0F, 3.0F, 33.0F, new Dilation(0.0F)), ModelTransform.of(11.4712F, 0.0F, 44.2462F, 0.0F, 0.2618F, 0.0F));

		ModelPartData finger3 = forearm.addChild("finger3", ModelPartBuilder.create(), ModelTransform.of(-45.6747F, 0.8984F, -13.658F, 0.0F, 0.9163F, 0.0F));

		ModelPartData membrane_r3 = finger3.addChild("membrane_r3", ModelPartBuilder.create().uv(0, 202).cuboid(-32.0F, 0.0F, -1.0F, 33.0F, 0.0F, 49.0F, new Dilation(0.0F)), ModelTransform.of(11.5841F, -0.4306F, 13.9145F, 0.0F, -0.5672F, 0.0F));

		ModelPartData cube_r48 = finger3.addChild("cube_r48", ModelPartBuilder.create().uv(121, 239).cuboid(-1.3612F, -3.0F, -1.6388F, 3.0F, 3.0F, 58.0F, new Dilation(0.0F)), ModelTransform.of(0.6991F, 1.9306F, -0.5568F, 0.0F, -0.5672F, 0.0F));

		ModelPartData fingertip3 = finger3.addChild("fingertip3", ModelPartBuilder.create(), ModelTransform.pivot(-35.8688F, 0.8194F, 61.2221F));

		ModelPartData membrane_r4 = fingertip3.addChild("membrane_r4", ModelPartBuilder.create().uv(0, 161).cuboid(-48.0F, 0.0F, -1.0F, 49.0F, 0.0F, 41.0F, new Dilation(0.0F)), ModelTransform.of(31.4529F, -1.25F, -5.3076F, 0.0F, -0.5236F, 0.0F));

		ModelPartData cube_r49 = fingertip3.addChild("cube_r49", ModelPartBuilder.create().uv(50, 263).cuboid(-1.3612F, -3.0F, -1.6387F, 3.0F, 3.0F, 44.0F, new Dilation(0.0F)), ModelTransform.of(8.7092F, 0.75F, -17.5326F, 0.0F, -0.5236F, 0.0F));

		ModelPartData finger2 = forearm.addChild("finger2", ModelPartBuilder.create(), ModelTransform.of(-47.0985F, 0.3625F, -15.0805F, 0.0F, 1.309F, 0.0F));

		ModelPartData cube_r50 = finger2.addChild("cube_r50", ModelPartBuilder.create().uv(253, 188).cuboid(-60.3612F, -3.0F, -1.6388F, 62.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.1078F, 1.5F, 0.5656F, 0.0F, 0.48F, 0.0F));

		ModelPartData fingertip2 = finger2.addChild("fingertip2", ModelPartBuilder.create(), ModelTransform.pivot(47.6316F, 3.1388F, 12.0368F));

		ModelPartData membrane_r5 = fingertip2.addChild("membrane_r5", ModelPartBuilder.create().uv(0, 122).cuboid(-57.0F, 0.0F, -1.0F, 58.0F, 0.0F, 39.0F, new Dilation(0.0F)), ModelTransform.of(-104.0F, -4.0F, 2.0F, 0.0F, 0.48F, 0.0F));

		ModelPartData cube_r51 = fingertip2.addChild("cube_r51", ModelPartBuilder.create().uv(298, 262).cuboid(-56.3612F, -3.0F, -1.6388F, 58.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-98.325F, -1.6388F, 14.7488F, 0.0F, 0.48F, 0.0F));

		ModelPartData claw = forearm.addChild("claw", ModelPartBuilder.create().uv(98, 346).cuboid(-46.885F, -4.2775F, -29.4975F, 1.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5331F, 3.5012F, -3.0437F));

		ModelPartData cube_r52 = claw.addChild("cube_r52", ModelPartBuilder.create().uv(271, 338).cuboid(-1.3612F, -3.0F, -1.6388F, 3.0F, 3.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-47.5237F, -1.6388F, -21.3037F, 0.0F, 0.2182F, 0.0F));

		ModelPartData finger1 = forearm.addChild("finger1", ModelPartBuilder.create().uv(270, 25).cuboid(-53.6769F, -1.3181F, -1.2631F, 59.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 84).cuboid(-53.8231F, -0.1819F, 0.7631F, 60.0F, 0.0F, 38.0F, new Dilation(0.0F)), ModelTransform.of(-49.0363F, 0.1806F, -16.5294F, 0.0F, 1.4399F, 0.0F));

		ModelPartData subfinger = finger1.addChild("subfinger", ModelPartBuilder.create().uv(298, 286).cuboid(-49.3969F, -1.3181F, -9.7631F, 52.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(101, 201).cuboid(-51.1031F, -0.1819F, -10.7369F, 53.0F, 0.0F, 38.0F, new Dilation(0.0F)), ModelTransform.pivot(-49.72F, 0.0F, 8.5F));

		ModelPartData fingertip = subfinger.addChild("fingertip", ModelPartBuilder.create().uv(185, 291).cuboid(-30.1587F, -1.3181F, -7.5131F, 33.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(75, 263).cuboid(-27.3413F, -0.1819F, -6.4869F, 30.0F, 0.0F, 25.0F, new Dilation(0.0F)), ModelTransform.pivot(-47.7619F, 0.0F, -2.25F));

		ModelPartData leftwing = wyvern.addChild("leftwing", ModelPartBuilder.create().uv(245, 0).cuboid(1.5144F, -1.39F, -5.0419F, 32.0F, 0.0F, 25.0F, new Dilation(0.0F))
		.uv(311, 235).cuboid(-1.0144F, -1.61F, -11.9581F, 35.0F, 6.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(11.5523F, -7.0546F, -4.2034F, 0.2727F, -0.4F, 0.1625F));

		ModelPartData forearm2 = leftwing.addChild("forearm2", ModelPartBuilder.create(), ModelTransform.of(32.6549F, 2.6112F, -7.2756F, 0.3041F, 0.3087F, 1.0156F));

		ModelPartData cube_r53 = forearm2.addChild("cube_r53", ModelPartBuilder.create().uv(298, 250).cuboid(-1.6388F, -5.0F, -1.6387F, 51.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.5331F, 0.5013F, -3.0437F, 0.0F, 0.3054F, 0.0F));

		ModelPartData membrane_r6 = forearm2.addChild("membrane_r6", ModelPartBuilder.create().uv(121, 0).cuboid(-1.0F, 0.0F, -1.0F, 56.0F, 0.0F, 37.0F, new Dilation(0.0F)), ModelTransform.of(-8.1406F, -4.0012F, 1.2338F, 0.0F, 0.3491F, 0.0F));

		ModelPartData finger5 = forearm2.addChild("finger5", ModelPartBuilder.create(), ModelTransform.of(41.301F, -1.6375F, -11.8299F, 0.0F, -0.6981F, 0.0F));

		ModelPartData cube_r54 = finger5.addChild("cube_r54", ModelPartBuilder.create().uv(185, 239).cuboid(-1.6388F, -3.0F, -1.6388F, 3.0F, 3.0F, 49.0F, new Dilation(0.0F)), ModelTransform.of(2.0509F, 0.5F, -1.0464F, 0.0F, -0.2618F, 0.0F));

		ModelPartData fingertip5 = finger5.addChild("fingertip5", ModelPartBuilder.create(), ModelTransform.pivot(2.0509F, 0.5F, -1.0464F));

		ModelPartData membrane_r7 = fingertip5.addChild("membrane_r7", ModelPartBuilder.create().uv(0, 38).cuboid(-1.0F, 0.0F, -1.0F, 48.0F, 0.0F, 46.0F, new Dilation(0.0F)), ModelTransform.of(-28.0F, -2.0F, 24.0F, 0.0F, -0.2618F, 0.0F));

		ModelPartData cube_r55 = fingertip5.addChild("cube_r55", ModelPartBuilder.create().uv(199, 300).cuboid(-1.6387F, -3.0F, -1.6387F, 3.0F, 3.0F, 33.0F, new Dilation(0.0F)), ModelTransform.of(-11.4712F, 0.0F, 44.2462F, 0.0F, -0.2618F, 0.0F));

		ModelPartData finger6 = forearm2.addChild("finger6", ModelPartBuilder.create(), ModelTransform.of(43.0511F, -3.0681F, -11.9582F, 0.0F, -1.1781F, 0.0F));

		ModelPartData membrane_r8 = finger6.addChild("membrane_r8", ModelPartBuilder.create().uv(196, 201).cuboid(-1.0F, 0.0F, -1.0F, 33.0F, 0.0F, 49.0F, new Dilation(0.0F)), ModelTransform.of(-10.5841F, 0.5694F, 11.9145F, 0.0F, 0.5672F, 0.0F));

		ModelPartData cube_r56 = finger6.addChild("cube_r56", ModelPartBuilder.create().uv(57, 202).cuboid(-1.6388F, -3.0F, -1.6388F, 3.0F, 3.0F, 58.0F, new Dilation(0.0F)), ModelTransform.of(0.3009F, 1.9306F, -2.5568F, 0.0F, 0.5672F, 0.0F));

		ModelPartData fingertip6 = finger6.addChild("fingertip6", ModelPartBuilder.create(), ModelTransform.pivot(36.8688F, 0.8194F, 59.2221F));

		ModelPartData membrane_r9 = fingertip6.addChild("membrane_r9", ModelPartBuilder.create().uv(114, 160).cuboid(-1.0F, 0.0F, -1.0F, 49.0F, 0.0F, 41.0F, new Dilation(0.0F)), ModelTransform.of(-31.4529F, -0.25F, -5.3076F, 0.0F, 0.5236F, 0.0F));

		ModelPartData cube_r57 = fingertip6.addChild("cube_r57", ModelPartBuilder.create().uv(0, 251).cuboid(-1.6388F, -3.0F, -1.6387F, 3.0F, 3.0F, 44.0F, new Dilation(0.0F)), ModelTransform.of(-8.7092F, 1.75F, -17.5326F, 0.0F, 0.5236F, 0.0F));

		ModelPartData finger7 = forearm2.addChild("finger7", ModelPartBuilder.create(), ModelTransform.of(46.0985F, -2.6375F, -15.0805F, 0.0F, -1.4399F, 0.0F));

		ModelPartData cube_r58 = finger7.addChild("cube_r58", ModelPartBuilder.create().uv(253, 182).cuboid(-1.6388F, -3.0F, -1.6388F, 62.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.1078F, 1.5F, 0.5656F, 0.0F, -0.48F, 0.0F));

		ModelPartData fingertip7 = finger7.addChild("fingertip7", ModelPartBuilder.create(), ModelTransform.pivot(49.8448F, -0.4306F, 25.336F));

		ModelPartData membrane_r10 = fingertip7.addChild("membrane_r10", ModelPartBuilder.create().uv(119, 84).cuboid(-1.0F, 0.0F, -1.0F, 58.0F, 0.0F, 39.0F, new Dilation(0.0F)), ModelTransform.of(5.5236F, -0.4306F, -11.2992F, 0.0F, -0.48F, 0.0F));

		ModelPartData cube_r59 = fingertip7.addChild("cube_r59", ModelPartBuilder.create().uv(270, 31).cuboid(-1.6388F, -3.0F, -1.6388F, 58.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.1514F, 1.9306F, 1.4496F, 0.0F, -0.48F, 0.0F));

		ModelPartData claw2 = forearm2.addChild("claw2", ModelPartBuilder.create().uv(209, 277).cuboid(45.885F, -4.2775F, -29.4975F, 1.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5331F, 0.5013F, -3.0437F));

		ModelPartData cube_r60 = claw2.addChild("cube_r60", ModelPartBuilder.create().uv(311, 213).cuboid(-1.6388F, -3.0F, -1.6388F, 3.0F, 3.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(47.5237F, -1.6388F, -21.3037F, 0.0F, -0.2182F, 0.0F));

		ModelPartData finger8 = forearm2.addChild("finger8", ModelPartBuilder.create().uv(253, 194).cuboid(-4.3231F, -1.3181F, -1.2631F, 59.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-5.1769F, -0.1819F, 0.7631F, 60.0F, 0.0F, 38.0F, new Dilation(0.0F)), ModelTransform.of(46.0363F, -2.8194F, -16.5294F, 0.0F, -1.4835F, 0.0F));

		ModelPartData subfinger2 = finger8.addChild("subfinger2", ModelPartBuilder.create().uv(298, 280).cuboid(0.3969F, -1.3181F, -1.7631F, 52.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(200, 37).cuboid(1.1031F, -0.1819F, -2.7369F, 53.0F, 0.0F, 38.0F, new Dilation(0.0F)), ModelTransform.pivot(47.72F, 0.0F, 0.5F));

		ModelPartData fingertip8 = subfinger2.addChild("fingertip8", ModelPartBuilder.create().uv(100, 288).cuboid(-4.8412F, -1.3181F, -0.5131F, 33.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(249, 100).cuboid(-4.6587F, -0.1819F, 0.5131F, 30.0F, 0.0F, 25.0F, new Dilation(0.0F)), ModelTransform.pivot(52.7619F, 0.0F, -1.25F));
		return TexturedModelData.of(modelData, 512, 512);
	}
	@Override
	public void setAngles(WyvernEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		wyvern.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return wyvern;
	}
}