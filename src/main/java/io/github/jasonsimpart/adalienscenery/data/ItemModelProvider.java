package io.github.jasonsimpart.adalienscenery.data;

import io.github.jasonsimpart.adalienscenery.AdAlienScenery;
import io.github.jasonsimpart.adalienscenery.registry.AASItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AdAlienScenery.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(AASItems.LUNAR_SAPPHIRE_SHARD.get());
        basicItem(AASItems.LUNAR_SAPPHIRE_CLUSTER.get());
        basicItem(AASItems.LARGE_LUNAR_SAPPHIRE_BUD.get());
        basicItem(AASItems.MEDIUM_LUNAR_SAPPHIRE_BUD.get());
        basicItem(AASItems.SMALL_LUNAR_SAPPHIRE_BUD.get());
    }
}
