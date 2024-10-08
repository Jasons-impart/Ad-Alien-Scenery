package io.github.jasonsimpart.adalienscenery.data;

import io.github.jasonsimpart.adalienscenery.AdAlienScenery;
import io.github.jasonsimpart.adalienscenery.data.language.ChineseLanguageProvider;
import io.github.jasonsimpart.adalienscenery.data.language.EnglishLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = AdAlienScenery.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataEventHandler {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new AASBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new WorldGenerationProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), AASLootTableProvider.create(packOutput));
        generator.addProvider(event.includeClient(), new EnglishLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new ChineseLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new ItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new BlockModelProvider(packOutput, existingFileHelper));
    }
}
