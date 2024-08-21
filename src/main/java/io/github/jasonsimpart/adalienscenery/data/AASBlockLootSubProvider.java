package io.github.jasonsimpart.adalienscenery.data;

import io.github.jasonsimpart.adalienscenery.registry.AASBlocks;
import io.github.jasonsimpart.adalienscenery.registry.AASItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class AASBlockLootSubProvider extends BlockLootSubProvider {
    protected AASBlockLootSubProvider() {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS);
    }

    private void addOre(Block oreBlock, Item oreItem) {
        add(oreBlock, b -> createOreDrop(b, oreItem));
    }

    @Override
    protected void generate() {
        // Lunar Sapphire
        dropSelf(AASBlocks.LUNAR_SAPPHIRE_BLOCK.get());
        add(AASBlocks.LUNAR_SAPPHIRE_CLUSTER.get(), b -> createSilkTouchDispatchTable(b, LootItem.lootTableItem(AASItems.LUNAR_SAPPHIRE_SHARD.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES))).otherwise(this.applyExplosionDecay(b, LootItem.lootTableItem(AASItems.LUNAR_SAPPHIRE_SHARD.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))));
        dropWhenSilkTouch(AASBlocks.SMALL_LUNAR_SAPPHIRE_BUD.get());
        dropWhenSilkTouch(AASBlocks.MEDIUM_LUNAR_SAPPHIRE_BUD.get());
        dropWhenSilkTouch(AASBlocks.LARGE_LUNAR_SAPPHIRE_BUD.get());
        add(AASBlocks.BUDDING_LUNAR_SAPPHIRE_BLOCK.get(), noDrop());

        // Ores
        addOre(AASBlocks.MOON_ILMENITE_ORE.get(), AASItems.RAW_ILMENITE.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return AASBlocks.BLOCKS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .toList();
    }
}
