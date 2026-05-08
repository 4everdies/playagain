package com.forever.playagain;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.client.ClientCommandHandler;

@Mod(modid = "playagain", name = "PlayAgain", version = "1.0", acceptedMinecraftVersions = "[1.8.9]")
public class Module {

    @Mod.Instance("playagain")
    public static Module instance;

    public static AutoPlay autoPlay = new AutoPlay();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(autoPlay);
        ClientCommandHandler.instance.registerCommand(new CommandPlayAgain());
    }
}
