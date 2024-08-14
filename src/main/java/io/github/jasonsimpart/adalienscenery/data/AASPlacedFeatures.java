package io.github.jasonsimpart.adalienscenery.data;

import io.github.jasonsimpart.adalienscenery.AdAlienScenery;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class AASPlacedFeatures {
    public static final ResourceKey<PlacedFeature> LUNAR_SAPPHIRE_GEODE = register("lunar_sapphire_geode");

    public static ResourceKey<PlacedFeature> register(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(AdAlienScenery.MODID, name));
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        PlacementUtils.register(context, LUNAR_SAPPHIRE_GEODE, holderGetter.getOrThrow(AASConfiguredFeatures.LUNAR_SAPPHIRE_GEODE),
                RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(30)));
    }
}
