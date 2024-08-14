package io.github.jasonsimpart.adalienscenery.registry;

import io.github.jasonsimpart.adalienscenery.AdAlienScenery;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AASCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AdAlienScenery.MODID);
    public static final RegistryObject<CreativeModeTab> MAIN_TAB = CREATIVE_TABS.register("main",
            () ->  CreativeModeTab.builder()
                    .icon(() -> new ItemStack(AASItems.LUNAR_SAPPHIRE_SHARD.get()))
                    .displayItems((features, output) -> AASItems.addItemsToMainTab(output))
                    .build());

    public static void register(IEventBus bus) {
        CREATIVE_TABS.register(bus);
    }
}
