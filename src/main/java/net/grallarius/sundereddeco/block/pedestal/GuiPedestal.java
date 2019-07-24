package net.grallarius.sundereddeco.block.pedestal;

import net.grallarius.sundereddeco.SunderedDeco;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.ResourceLocation;

public class GuiPedestal /*extends GuiContainer */{
    private static final ResourceLocation BG_TEXTURE = new ResourceLocation(SunderedDeco.MODID, "textures/gui/pedestal.png");

    private Inventory playerInv;

    public GuiPedestal(Container container, Inventory playerInv) {
        //super(container);
        this.playerInv =playerInv;
    }

   /* @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
       *//* GlStateManager.color(1, 1, 1, 1);
        mc.getTextureManager().bindTexture(BG_TEXTURE);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);*//*
    }
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        *//*String name = I18n.format(ModBlocks.bookPedestal.getUnlocalizedName() + ".name");
        fontRenderer.drawString(name, xSize / 2 - fontRenderer.getStringWidth(name) / 2, 6, 0x404040);
        fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 94, 0x404040);*//*
    }*/
}
