package io.github.jasonsimpart.adalienscenery.block;

import io.github.jasonsimpart.adalienscenery.registry.AASBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class BuddingLunarSapphireBlock extends AmethystBlock {
    public static final int GROWTH_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingLunarSapphireBlock(Properties pProperties) {
        super(pProperties);
    }

    /**
     * Performs a random tick on a block.
     */
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(GROWTH_CHANCE) == 0) {
            Direction direction = DIRECTIONS[pRandom.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = pPos.relative(direction);
            BlockState blockstate = pLevel.getBlockState(blockpos);
            Block block = null;
            if (canClusterGrowAtState(blockstate)) {
                block = AASBlocks.SMALL_LUNAR_SAPPHIRE_BUD.get();
            } else if (blockstate.is(AASBlocks.SMALL_LUNAR_SAPPHIRE_BUD.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = AASBlocks.MEDIUM_LUNAR_SAPPHIRE_BUD.get();
            } else if (blockstate.is(AASBlocks.MEDIUM_LUNAR_SAPPHIRE_BUD.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = AASBlocks.LARGE_LUNAR_SAPPHIRE_BUD.get();
            } else if (blockstate.is(AASBlocks.LARGE_LUNAR_SAPPHIRE_BUD.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = AASBlocks.LUNAR_SAPPHIRE_CLUSTER.get();
            }

            if (block != null) {
                BlockState blockstate1 = block.defaultBlockState().setValue(AmethystClusterBlock.FACING, direction).setValue(AmethystClusterBlock.WATERLOGGED, Boolean.valueOf(blockstate.getFluidState().getType() == Fluids.WATER));
                pLevel.setBlockAndUpdate(blockpos, blockstate1);
            }

        }
    }

    public static boolean canClusterGrowAtState(BlockState pState) {
        return pState.isAir() || pState.is(Blocks.WATER) && pState.getFluidState().getAmount() == 8;
    }
}
