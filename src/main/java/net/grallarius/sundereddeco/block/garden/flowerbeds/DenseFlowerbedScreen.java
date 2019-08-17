package net.grallarius.sundereddeco.block.garden.flowerbeds;

import com.mojang.blaze3d.platform.GlStateManager;
import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.block.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class DenseFlowerbedScreen extends ContainerScreen<ContainerDenseFlowerbed> {
    private static final ResourceLocation BG_TEXTURE = new ResourceLocation(SunderedDeco.MODID, "textures/gui/denseflowerbed_gui.png");

    PlayerInventory playerInv;

    public DenseFlowerbedScreen(ContainerDenseFlowerbed container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
        this.playerInv = inv;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String name = I18n.format(ModBlocks.denseflowerbed.getTranslationKey());
        String invName = playerInv.getDisplayName().getUnformattedComponentText();
        drawString(Minecraft.getInstance().fontRenderer, name, 2, 6, 0x404040);
        //drawString(Minecraft.getInstance().fontRenderer, invName, 2, 6, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color4f(1, 1, 1, 1);
        this.minecraft.getTextureManager().bindTexture(BG_TEXTURE);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
    }
}
