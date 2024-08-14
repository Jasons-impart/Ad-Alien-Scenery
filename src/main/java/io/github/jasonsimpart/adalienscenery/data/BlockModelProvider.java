package io.github.jasonsimpart.adalienscenery.data;

import io.github.jasonsimpart.adalienscenery.AdAlienScenery;
import io.github.jasonsimpart.adalienscenery.registry.AASBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockModelProvider extends net.minecraftforge.client.model.generators.BlockStateProvider {
    public BlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AdAlienScenery.MODID, existingFileHelper);
    }

    private void crossCutoutBlock(Block block) {
        simpleBlock(block, models().cross(name(block), blockTexture(block)).renderType(new ResourceLocation("cutout")));
    }

    private void simpleBlockWithItem(Block block) {
        simpleBlockWithItem(block, cubeAll(block));
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(AASBlocks.LUNAR_SAPPHIRE_BLOCK.get());
        simpleBlockWithItem(AASBlocks.BUDDING_LUNAR_SAPPHIRE_BLOCK.get());

        crossCutoutBlock(AASBlocks.LUNAR_SAPPHIRE_CLUSTER.get());
        crossCutoutBlock(AASBlocks.LARGE_LUNAR_SAPPHIRE_BUD.get());
        crossCutoutBlock(AASBlocks.MEDIUM_LUNAR_SAPPHIRE_BUD.get());
        crossCutoutBlock(AASBlocks.SMALL_LUNAR_SAPPHIRE_BUD.get());
    }
}
