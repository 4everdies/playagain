package com.forever.playagain;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AutoPlay {
    private static final String TARGET_MESSAGE = "Deseja jogar novamente? CLIQUE AQUI!";
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    public long delayMs = 1500;
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String message = event.message.getUnformattedText();
        
        if (message.contains(TARGET_MESSAGE)) {
            trigger();
        }
    }

    @SubscribeEvent
    public void onCommand(net.minecraftforge.event.CommandEvent event) {
        if (event.command.getCommandName().equalsIgnoreCase("playagain")) {
            trigger();
        }
    }

    private void trigger() {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.thePlayer != null) {
            mc.thePlayer.addChatMessage(new ChatComponentText(
                EnumChatFormatting.BLUE + "[AutoPlay] " + 
                EnumChatFormatting.GRAY + "Sending you to the next game in " + 
                EnumChatFormatting.WHITE + (delayMs / 1000.0) + "s..."
            ));
        }

        executor.schedule(() -> {
            if (mc.thePlayer != null) {
                mc.thePlayer.sendChatMessage("/playagain");
            }
        }, delayMs, TimeUnit.MILLISECONDS);
    }
    public void setDelay(double seconds) {
        this.delayMs = (long) (seconds * 1000);
    }
}
