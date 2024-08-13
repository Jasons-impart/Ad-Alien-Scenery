package io.github.jasonsimpart.adalienscenery.registry;

import io.github.jasonsimpart.adalienscenery.AdAlienScenery;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AASItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, AdAlienScenery.MODID);

    // Lunar Sapphire
    public static final RegistryObject<Item> LUNAR_SAPPHIRE_SHARD = register("lunar_sapphire_shard");
    public static final RegistryObject<Item> LUNAR_SAPPHIRE_BLOCK = register(AASBlocks.LUNAR_SAPPHIRE_BLOCK);
    public static final RegistryObject<Item> BUDDING_LUNAR_SAPPHIRE_BLOCK = register(AASBlocks.BUDDING_LUNAR_SAPPHIRE_BLOCK);
    public static final RegistryObject<Item> LUNAR_SAPPHIRE_CLUSTER = register(AASBlocks.LUNAR_SAPPHIRE_CLUSTER);
    public static final RegistryObject<Item> LARGE_LUNAR_SAPPHIRE_BUD = register(AASBlocks.LARGE_LUNAR_SAPPHIRE_BUD);
    public static final RegistryObject<Item> MEDIUM_LUNAR_SAPPHIRE_BUD = register(AASBlocks.MEDIUM_LUNAR_SAPPHIRE_BUD);
    public static final RegistryObject<Item> SMALL_LUNAR_SAPPHIRE_BUD = register(AASBlocks.SMALL_LUNAR_SAPPHIRE_BUD);

    public static RegistryObject<Item> register(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }
    public static RegistryObject<Item> register(RegistryObject<Block> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
