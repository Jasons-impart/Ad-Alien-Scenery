package io.github.jasonsimpart.adalienscenery.data;

import io.github.jasonsimpart.adalienscenery.AdAlienScenery;
import io.github.jasonsimpart.adalienscenery.registry.AASBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class AASBlockTagsProvider extends BlockTagsProvider {
    public AASBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AdAlienScenery.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                AASBlocks.LUNAR_SAPPHIRE_BLOCK.get(),
                AASBlocks.BUDDING_LUNAR_SAPPHIRE_BLOCK.get(),
                AASBlocks.SMALL_LUNAR_SAPPHIRE_BUD.get(),
                AASBlocks.MEDIUM_LUNAR_SAPPHIRE_BUD.get(),
                AASBlocks.LARGE_LUNAR_SAPPHIRE_BUD.get(),
                AASBlocks.MOON_ILMENITE_ORE.get()
        );
        tag(BlockTags.NEEDS_IRON_TOOL).add(
                AASBlocks.MOON_ILMENITE_ORE.get()
        );
        tag(Tags.Blocks.STORAGE_BLOCKS).add(
                AASBlocks.LUNAR_SAPPHIRE_BLOCK.get()
        );
        tag(Tags.Blocks.tag("storage_blocks/lunar_sapphire")).add(
                AASBlocks.LUNAR_SAPPHIRE_BLOCK.get()
        );
    }
}
