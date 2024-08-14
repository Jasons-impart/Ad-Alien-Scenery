package io.github.jasonsimpart.adalienscenery.data.language;

import io.github.jasonsimpart.adalienscenery.AdAlienScenery;
import io.github.jasonsimpart.adalienscenery.registry.AASBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class EnglishLanguageProvider extends LanguageProvider {
    public EnglishLanguageProvider(PackOutput output) {
        super(output, AdAlienScenery.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(AASBlocks.LUNAR_SAPPHIRE_BLOCK.get(), "Lunar Sapphire Block");
    }
}
