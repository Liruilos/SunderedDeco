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

// extends TileEntitySpecialRenderer<TileEntityDenseFlowerbed>
public class DenseFlowerbedRenderer extends TileEntityRenderer<TileEntityDenseFlowerbed> {
    @Override
    public void render(TileEntityDenseFlowerbed te, double x, double y, double z, float partialTicks, int destroyStage) {
        ItemStack stack1 = te.inventory.getStackInSlot(0);
        ItemStack stack2 = te.inventory.getStackInSlot(1);
        ItemStack stack3 = te.inventory.getStackInSlot(2);
        ItemStack stack4 = te.inventory.getStackInSlot(3);

        GlStateManager.enableRescaleNormal();
        GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
        GlStateManager.enableBlend();
        GlStateManager.disableLighting();
        GlStateManager.blendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);


        if (!stack1.isEmpty()) {
            GlStateManager.pushMatrix();

                GlStateManager.translated(x + 0.75, y + 1.0, z + 0.75);
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
            GlStateManager.pushMatrix();

            GlStateManager.translated(x + 0.25, y + 0.95, z + 0.75);

            Block block = Block.getBlockFromItem(stack2.getItem());
            BlockState state = block.getStateContainer().getBaseState();
            IBakedModel model = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(state);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getInstance().getTextureManager().bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
            Minecraft.getInstance().getItemRenderer().renderItem(stack2, model);

            GlStateManager.popMatrix();
        }

        if (!stack3.isEmpty()) {
            GlStateManager.pushMatrix();

                GlStateManager.translated(x + 0.75, y + 0.95, z + 0.25);
            GlStateManager.rotatef(40, 0,1,0);

            Block block = Block.getBlockFromItem(stack3.getItem());
            BlockState state = block.getStateContainer().getBaseState();
            IBakedModel model = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(state);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getInstance().getTextureManager().bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
            Minecraft.getInstance().getItemRenderer().renderItem(stack3, model);

            GlStateManager.popMatrix();
        }

        if (!stack4.isEmpty()) {
            GlStateManager.pushMatrix();

                GlStateManager.translated(x + 0.25, y + 1.0, z + 0.25);
            GlStateManager.rotatef(25, 0,1,0);

            Block block = Block.getBlockFromItem(stack4.getItem());
            BlockState state = block.getStateContainer().getBaseState();
            IBakedModel model = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(state);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getInstance().getTextureManager().bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
            Minecraft.getInstance().getItemRenderer().renderItem(stack4, model);

            GlStateManager.popMatrix();
        }


        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();

    }
}
