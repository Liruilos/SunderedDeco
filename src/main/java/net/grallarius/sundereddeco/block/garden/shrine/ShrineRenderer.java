package net.grallarius.sundereddeco.block.garden.shrine;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.opengl.GL11;

public class ShrineRenderer extends TileEntityRenderer<ShrineTileEntity> {

    @Override
    public void render(ShrineTileEntity te, double x, double y, double z, float partialTicks, int destroyStage) {
        ItemStack stack1 = te.inventory.getStackInSlot(0);

        if (!stack1.isEmpty()) {

            GlStateManager.enableRescaleNormal();
            GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
            GlStateManager.enableBlend();
            GlStateManager.disableLighting();
            GlStateManager.blendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);

            GlStateManager.pushMatrix();

            //checks if the item has a block and can be rendered '3D'
            if (stack1.getItem() instanceof BlockItem) {

                Block block = Block.getBlockFromItem(stack1.getItem());
                BlockState state = block.getStateContainer().getBaseState();

                GlStateManager.translated(x + 0.5, y + 0.55, z + 0.5);
                GlStateManager.rotatef(15, 0,1,0);

                GlStateManager.scaled(0.5, 0.5, 0.5);


                IBakedModel model = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(state);
                model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.FIXED, false);
                Minecraft.getInstance().getTextureManager().bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
                Minecraft.getInstance().getItemRenderer().renderItem(stack1, model);

                //item does not have a block and is rendered as it would be on the ground
            } else {
                GlStateManager.translated(x + 0.5, y + 0.4, z + 0.5);

                ShrineTileEntity tileEntity = (ShrineTileEntity) Minecraft.getInstance().world.getTileEntity(te.getPos());
                if (tileEntity.facing == 0 || tileEntity.facing == 2) {
                    GlStateManager.rotatef(15, 0, 1, 0);
                } else {
                    GlStateManager.rotatef(105, 0, 1, 0);

                }
                //GlStateManager.scaled(0.5, 0.5, 0.5);

                Minecraft.getInstance().getItemRenderer().renderItem(stack1, ItemCameraTransforms.TransformType.GROUND);
            }



            GlStateManager.popMatrix();

            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
        }
    }
}
