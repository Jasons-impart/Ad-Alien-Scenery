package io.github.jasonsimpart.adalienscenery.registry;

import io.github.jasonsimpart.adalienscenery.AdAlienScenery;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class AASBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, AdAlienScenery.MODID);

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
