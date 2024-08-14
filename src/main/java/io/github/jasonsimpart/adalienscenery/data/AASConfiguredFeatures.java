package io.github.jasonsimpart.adalienscenery.data;

import io.github.jasonsimpart.adalienscenery.AdAlienScenery;
import io.github.jasonsimpart.adalienscenery.registry.AASBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class AASConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> LUNAR_SAPPHIRE_GEODE = register("lunar_sapphire_geode");

    public static ResourceKey<ConfiguredFeature<?, ?>> register(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(AdAlienScenery.MODID, name));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, LUNAR_SAPPHIRE_GEODE, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(
                        BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(AASBlocks.LUNAR_SAPPHIRE_BLOCK.get()),
                        BlockStateProvider.simple(AASBlocks.BUDDING_LUNAR_SAPPHIRE_BLOCK.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(AASBlocks.SMALL_LUNAR_SAPPHIRE_BUD.get().defaultBlockState(), AASBlocks.MEDIUM_LUNAR_SAPPHIRE_BUD.get().defaultBlockState(), AASBlocks.LARGE_LUNAR_SAPPHIRE_BUD.get().defaultBlockState(), AASBlocks.LUNAR_SAPPHIRE_CLUSTER.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE,
                        BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1)
        );
    }
}
