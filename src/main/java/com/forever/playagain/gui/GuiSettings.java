package com.forever.playagain.gui;

import com.forever.playagain.Module;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;

import java.io.IOException;

public class GuiSettings extends GuiScreen {

    @Override
    public void initGui() {
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        double currentDelay = Module.autoPlay.delayMs / 1000.0;

        this.buttonList.add(new GuiSlider(0, centerX - 75, centerY - 10, 150, 20, 
                "Delay: ", "s", 0.5, 5.0, currentDelay, true, true, 
                slider -> {
                    Module.autoPlay.delayMs = (long) (slider.getValue() * 1000);
                }));

        this.buttonList.add(new GuiButton(1, centerX - 75, centerY + 20, 150, 20, "Back"));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, EnumChatFormatting.BLUE + "" + EnumChatFormatting.BOLD + "PlayAgain Settings", this.width / 2, 40, 16777215);
        this.drawCenteredString(this.fontRendererObj, EnumChatFormatting.GRAY + "Adjust the delay before sending /playagain", this.width / 2, 55, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 1) {
            this.mc.displayGuiScreen(null);
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
