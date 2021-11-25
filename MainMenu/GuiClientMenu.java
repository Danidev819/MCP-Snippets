package tucliente.gui.mainmenu;

import java.io.IOException;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Mouse;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumChatFormatting;
import tucliente.Cliente;
import net.minecraft.client.gui.GuiScreen;
//tucliente = yourclient
public class GuiClientMenu extends GuiScreen
{
    @Override
    public void initGui() {
        Cliente.getInstance().getDiscordRP().update("Inactivo", "Menu Principal"); //Idle, Main Menu
        this.buttonList.add(new ClientButtons(1, this.width / 2 - 50, this.height / 2 - 17, 98, 16, "Un Jugador")); //Singleplayer
        this.buttonList.add(new ClientButtons(2, this.width / 2 - 50, this.height / 2, 98, 16, "Multijugador")); //Multiplayer
        this.buttonList.add(new ClientButtons(3, this.width / 2 - 50, this.height / 2 + 17, 98, 16, "Ajustes")); //Settings
        this.buttonList.add(new ClientButtons(4, this.width - 23, 6, 17, 17, EnumChatFormatting.BOLD + ""));
        
        super.initGui();
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(new ResourceLocation("tucliente/yourbackground.png"));
        Gui.drawModalRectWithCustomSizedTexture(-21 + Mouse.getX() / 90, Mouse.getY() * -1 / 90, 0.0f, 0.0f, this.width + 20, this.height + 20, (float)(this.width + 21), (float)(this.height + 20));
        final String s1 = "Copyright " + EnumChatFormatting.RED + EnumChatFormatting.BOLD + "M" + EnumChatFormatting.RESET + "ojang AB";
        this.drawString(this.fontRendererObj, s1, this.width - this.fontRendererObj.getStringWidth(s1) - 2, this.height - 10, -1);
        this.drawCenteredString(this.mc.fontRendererObj, EnumChatFormatting.BOLD + "Fox" + EnumChatFormatting.RESET + "Client", this.width / 2 - 2, this.height / 2 - 30, -1);
        super.drawScreen(mouseX, mouseY, partialTicks);
        mc.getTextureManager().bindTexture(new ResourceLocation("tucliente/menu/exit.png"));
		Gui.drawModalRectWithCustomSizedTexture(width - 21, 6, 0, 0, 16, 17, 16, 17);
    }
    
    @Override
    protected void actionPerformed(final GuiButton button) throws IOException {
        switch (button.id) {
            case 1: {
                this.mc.displayGuiScreen(new GuiSelectWorld(this));
                break;
            }
            case 2: {
                this.mc.displayGuiScreen(new GuiMultiplayer(this));
                break;
            }
            case 3: {
                this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
                break;
            }
            case 4: {
                this.mc.shutdown();
                break;
            }
        }
        super.actionPerformed(button);
    }
}
