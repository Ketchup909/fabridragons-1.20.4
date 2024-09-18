package net.ketch.fabridragons.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.ketch.fabridragons.FabriDragons;
import net.ketch.fabridragons.entity.custom.WyvernEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<WyvernEntity> WYVERN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(FabriDragons.MOD_ID, "wyvern"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WyvernEntity::new)
                    .dimensions(EntityDimensions.fixed(4f, 4f)).build());
}
