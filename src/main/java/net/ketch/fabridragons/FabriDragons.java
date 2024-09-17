package net.ketch.fabridragons;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.ketch.fabridragons.entity.ModEntities;
import net.ketch.fabridragons.entity.custom.WyvernEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabriDragons implements ModInitializer {
	public static final String MOD_ID = "fabridragons";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {

		FabricDefaultAttributeRegistry.register(ModEntities.WYVERN, WyvernEntity.createWyvernAttributes());
		LOGGER.info("Wyvern registered from OnInitialize in FabriDragons.java ");
	}
}