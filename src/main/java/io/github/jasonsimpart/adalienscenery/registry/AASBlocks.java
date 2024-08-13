package io.github.jasonsimpart.adalienscenery.registry;

import io.github.jasonsimpart.adalienscenery.AdAlienScenery;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AASBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, AdAlienScenery.MODID);

    // Lunar Sapphire
    public static final RegistryObject<Block> LUNAR_SAPPHIRE_BLOCK = BLOCKS.register("lunar_sapphire_block", () -> new AmethystBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BUDDING_LUNAR_SAPPHIRE_BLOCK = BLOCKS.register("budding_lunar_sapphire_block", () -> new BuddingAmethystBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> LUNAR_SAPPHIRE_CLUSTER = BLOCKS.register("lunar_sapphire_cluster", () -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5F).lightLevel(blockState -> 5).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> LARGE_LUNAR_SAPPHIRE_BUD = BLOCKS.register("large_lunar_sapphire_bud", () -> new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(LUNAR_SAPPHIRE_CLUSTER.get()).sound(SoundType.MEDIUM_AMETHYST_BUD).forceSolidOn().lightLevel(blockState -> 4).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> MEDIUM_LUNAR_SAPPHIRE_BUD = BLOCKS.register("medium_lunar_sapphire_bud", () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(LUNAR_SAPPHIRE_CLUSTER.get()).sound(SoundType.LARGE_AMETHYST_BUD).forceSolidOn().lightLevel(blockState -> 2).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SMALL_LUNAR_SAPPHIRE_BUD = BLOCKS.register("small_lunar_sapphire_bud", () -> new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(LUNAR_SAPPHIRE_CLUSTER.get()).sound(SoundType.SMALL_AMETHYST_BUD).forceSolidOn().lightLevel(blockState -> 1).pushReaction(PushReaction.DESTROY)));

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
