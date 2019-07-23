package net.grallarius.sundereddeco.block.garden.flowerbeds;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.block.Block;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.opengl.GL11;


public class FlowerbedRenderer extends TileEntityRenderer<TileEntityFlowerbed> {
    @Override
    public void render(TileEntityFlowerbed te, double x, double y, double z, float partialTicks, int destroyStage) {
        ItemStack stack1 = te.inventory.getStackInSlot(0);
        ItemStack stack2 = te.inventory.getStackInSlot(1);

        GlStateManager.enableRescaleNormal();
        GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
        GlStateManager.enableBlend();
        GlStateManager.disableLighting();
        GlStateManager.blendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);


        if (!stack1.isEmpty()) {
            GlStateManager.pushMatrix();

            GlStateManager.translated(x + 0.5, y + 1.0, z + 0.5);
            GlStateManager.rotatef(15, 0,1,0);

            Block block = Block.getBlockFromItem(stack1.getItem());
            BlockState state = block.getStateContainer().getBaseState();
            IBakedModel model = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(state);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getInstance().getTextureManager().bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
            Minecraft.getInstance().getItemRenderer().renderItem(stack1, model);

            GlStateManager.popMatrix();
        }

        if (!stack2.isEmpty()) {


            Block block = Block.getBlockFromItem(stack2.getItem());
            BlockState state = block.getStateContainer().getBaseState();
            IBakedModel model = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(state);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getInstance().getTextureManager().bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);

            GlStateManager.pushMatrix();

            GlStateManager.translated(x + 0.2, y + 0.85, z + 0.2);
            GlStateManager.rotatef(5, 0,1,0);
            GlStateManager.scaled(0.7, 0.7, 0.7);

            Minecraft.getInstance().getItemRenderer().renderItem(stack2, model);

            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();

            GlStateManager.translated(x + 0.2, y + 0.8, z + 0.8);
            GlStateManager.rotatef(15, 0,1,0);
            GlStateManager.scaled(0.75, 0.75, 0.75);

            Minecraft.getInstance().getItemRenderer().renderItem(stack2, model);

            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();

            GlStateManager.translated(x + 0.8, y + 0.8, z + 0.2);
            GlStateManager.rotatef(50, 0,1,0);
            GlStateManager.scaled(0.75, 0.75, 0.75);

            Minecraft.getInstance().getItemRenderer().renderItem(stack2, model);

            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();

            GlStateManager.translated(x + 0.8, y + 0.85, z + 0.8);
            GlStateManager.rotatef(35, 0,1,0);
            GlStateManager.scaled(0.7, 0.7, 0.7);

            Minecraft.getInstance().getItemRenderer().renderItem(stack2, model);

            GlStateManager.popMatrix();
        }


        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();

    }
}
