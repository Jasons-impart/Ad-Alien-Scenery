package io.github.jasonsimpart.adalienscenery;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AdAlienScenery.MODID)
public class AdAlienScenery
{
    public static final String MODID = "adalienscenery";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AdAlienScenery()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    }
}