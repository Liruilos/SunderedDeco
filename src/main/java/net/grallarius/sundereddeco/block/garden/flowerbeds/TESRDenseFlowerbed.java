package net.grallarius.sundereddeco.block.garden.flowerbeds;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.opengl.GL11;

// extends TileEntitySpecialRenderer<TileEntityDenseFlowerbed>
public class TESRDenseFlowerbed {
   /* @Override
    public void render(TileEntityDenseFlowerbed te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        ItemStack stack1 = te.inventory.getStackInSlot(0);
        ItemStack stack2 = te.inventory.getStackInSlot(1);
        ItemStack stack3 = te.inventory.getStackInSlot(2);
        ItemStack stack4 = te.inventory.getStackInSlot(3);

        GlStateManager.enableRescaleNormal();
        GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
        GlStateManager.enableBlend();
        GlStateManager.disableLighting();
        GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);


        if (!stack1.isEmpty()) {
            GlStateManager.pushMatrix();

                GlStateManager.translate(x + 0.75, y + 1.0, z + 0.75);
                GlStateManager.rotate(15, 0,1,0);

            IBlockState state = Block.getBlockFromItem(stack1.getItem()).getStateForPlacement(getWorld(), te.getPos(), EnumFacing.NORTH, 0, 0, 0, stack1.getMetadata(), null, null);
            IBakedModel model = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelForState(state);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            Minecraft.getMinecraft().getRenderItem().renderItem(stack1, model);

            GlStateManager.popMatrix();
        }

        if (!stack2.isEmpty()) {
            GlStateManager.pushMatrix();

            GlStateManager.translate(x + 0.25, y + 0.95, z + 0.75);

            IBlockState state = Block.getBlockFromItem(stack2.getItem()).getStateForPlacement(getWorld(), te.getPos(), EnumFacing.NORTH, 0, 0, 0, stack2.getMetadata(), null, null);
            IBakedModel model = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelForState(state);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            Minecraft.getMinecraft().getRenderItem().renderItem(stack2, model);

            GlStateManager.popMatrix();
        }

        if (!stack3.isEmpty()) {
            GlStateManager.pushMatrix();

                GlStateManager.translate(x + 0.75, y + 0.95, z + 0.25);
            GlStateManager.rotate(40, 0,1,0);

            IBlockState state = Block.getBlockFromItem(stack3.getItem()).getStateForPlacement(getWorld(), te.getPos(), EnumFacing.NORTH, 0, 0, 0, stack3.getMetadata(), null, null);
            IBakedModel model = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelForState(state);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            Minecraft.getMinecraft().getRenderItem().renderItem(stack3, model);

            GlStateManager.popMatrix();
        }

        if (!stack4.isEmpty()) {
            GlStateManager.pushMatrix();

                GlStateManager.translate(x + 0.25, y + 1.0, z + 0.25);
            GlStateManager.rotate(25, 0,1,0);


            IBlockState state = Block.getBlockFromItem(stack4.getItem()).getStateForPlacement(getWorld(), te.getPos(), EnumFacing.NORTH, 0, 0, 0, stack4.getMetadata(), null, null);
            IBakedModel model = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelForState(state);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            Minecraft.getMinecraft().getRenderItem().renderItem(stack4, model);

            GlStateManager.popMatrix();
        }


        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();

    }*/
}
