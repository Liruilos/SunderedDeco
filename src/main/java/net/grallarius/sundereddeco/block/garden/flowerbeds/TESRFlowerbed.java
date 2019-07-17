package net.grallarius.sundereddeco.block.garden.flowerbeds;

import net.minecraft.block.Block;

import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.opengl.GL11;

//extends TileEntitySpecialRenderer<TileEntityFlowerbed>
public class TESRFlowerbed  {
    /*
    @Override
    public void render(TileEntityFlowerbed te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        ItemStack stack1 = te.inventory.getStackInSlot(0);
        ItemStack stack2 = te.inventory.getStackInSlot(1);

        GlStateManager.enableRescaleNormal();
        GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
        GlStateManager.enableBlend();
        GlStateManager.disableLighting();
        GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);


        if (!stack1.isEmpty()) {
            GlStateManager.pushMatrix();

            GlStateManager.translate(x + 0.5, y + 1.0, z + 0.5);
            GlStateManager.rotate(15, 0,1,0);

            IBlockState state = Block.getBlockFromItem(stack1.getItem()).getStateForPlacement(getWorld(), te.getPos(), EnumFacing.NORTH, 0, 0, 0, stack1.getMetadata(), null, null);
            IBakedModel model = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelForState(state);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            Minecraft.getMinecraft().getRenderItem().renderItem(stack1, model);

            GlStateManager.popMatrix();
        }

        if (!stack2.isEmpty()) {



            IBlockState state = Block.getBlockFromItem(stack2.getItem()).getStateForPlacement(getWorld(), te.getPos(), EnumFacing.NORTH, 0, 0, 0, stack2.getMetadata(), null, null);
            IBakedModel model = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelForState(state);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

            GlStateManager.pushMatrix();

            GlStateManager.translate(x + 0.2, y + 0.85, z + 0.2);
            GlStateManager.rotate(5, 0,1,0);
            GlStateManager.scale(0.7, 0.7, 0.7);

            Minecraft.getMinecraft().getRenderItem().renderItem(stack2, model);

            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();

            GlStateManager.translate(x + 0.2, y + 0.8, z + 0.8);
            GlStateManager.rotate(15, 0,1,0);
            GlStateManager.scale(0.75, 0.75, 0.75);

            Minecraft.getMinecraft().getRenderItem().renderItem(stack2, model);

            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();

            GlStateManager.translate(x + 0.8, y + 0.8, z + 0.2);
            GlStateManager.rotate(50, 0,1,0);
            GlStateManager.scale(0.75, 0.75, 0.75);

            Minecraft.getMinecraft().getRenderItem().renderItem(stack2, model);

            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();

            GlStateManager.translate(x + 0.8, y + 0.85, z + 0.8);
            GlStateManager.rotate(35, 0,1,0);
            GlStateManager.scale(0.7, 0.7, 0.7);

            Minecraft.getMinecraft().getRenderItem().renderItem(stack2, model);

            GlStateManager.popMatrix();
        }


        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();

    }*/
}
