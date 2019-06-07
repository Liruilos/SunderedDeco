package net.grallarius.sundereddeco.block.garden.flowerbeds;

import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.block.ModBlocks;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiFlowerbed extends GuiContainer {
    private static final ResourceLocation BG_TEXTURE = new ResourceLocation(SunderedDeco.MODID, "textures/gui/flowerbed_gui.png");

    private InventoryPlayer playerInv;

    public GuiFlowerbed(Container container, InventoryPlayer playerInv) {
        super(container);
        this.playerInv =playerInv;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
      /*  GlStateManager.color(1, 1, 1, 1);
        mc.getTextureManager().bindTexture(BG_TEXTURE);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);*/
    }
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
       /* String name = I18n.format(ModBlocks.flowerbed.getUnlocalizedName() + ".name");
        fontRenderer.drawString(name, xSize / 2 - fontRenderer.getStringWidth(name) / 2, 6, 0x404040);
        fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 94, 0x404040);*/
    }
}
