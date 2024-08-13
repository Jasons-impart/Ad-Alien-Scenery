package io.github.jasonsimpart.adalienscenery.data.language;

import io.github.jasonsimpart.adalienscenery.AdAlienScenery;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ChineseLanguageProvider extends LanguageProvider {
    public ChineseLanguageProvider(PackOutput output) {
        super(output, AdAlienScenery.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add();
    }
}
