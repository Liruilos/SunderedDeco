package net.grallarius.sundereddeco.block.garden.windowbox;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.opengl.GL11;

public class TESRWindowbox extends TileEntitySpecialRenderer<TileEntityWindowbox> {
    @Override
    public void render(TileEntityWindowbox te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        ItemStack stack1 = te.inventory.getStackInSlot(0);
        ItemStack stack2 = te.inventory.getStackInSlot(1);

        if (!stack1.isEmpty() && BlockWindowbox.canBePotted(stack1)) {

                GlStateManager.enableRescaleNormal();
                GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
                GlStateManager.enableBlend();
                /*RenderHelper.enableStandardItemLighting();*/
                GlStateManager.disableLighting();
                GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
                GlStateManager.pushMatrix();
/*          double offset = Math.sin((te.getWorld().getTotalWorldTime() - te.lastChangeTime + partialTicks) / 8) / 4.0;
            GlStateManager.translate(x + 0.5, y + 1.25 + offset, z + 0.5);
            GlStateManager.rotate((te.getWorld().getTotalWorldTime() + partialTicks) * 4, 0, 1, 0);*/

                //* South */
                if (te.getFacing() == 0) {
                    GlStateManager.translate(x + 0.75, y + 1.35, z + 0.75);
                }
                //* West */
                else if (te.getFacing() == 1) {
                    GlStateManager.translate(x + 0.25, y + 1.35, z + 0.75);
                    GlStateManager.rotate(90, 0, 1, 0);
                }
                //* North */
                else if (te.getFacing() == 2) {
                    GlStateManager.translate(x + 0.25, y + 1.35, z + 0.25);
                }
                //* East */
                else if (te.getFacing() == 3) {
                    GlStateManager.translate(x + 0.75, y + 1.35, z + 0.25);
                    GlStateManager.rotate(90, 0, 1, 0);
                }

                IBlockState state = Block.getBlockFromItem(stack1.getItem()).getStateForPlacement(getWorld(), te.getPos(), EnumFacing.NORTH, 0, 0, 0, stack1.getMetadata(), null, null);
                IBakedModel model = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelForState(state);
                /*.getRenderItem().getItemModelWithOverrides (stack, te.getWorld(), null);*/
                model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

                Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                Minecraft.getMinecraft().getRenderItem().renderItem(stack1, model);


                GlStateManager.popMatrix();
                GlStateManager.disableRescaleNormal();
                GlStateManager.disableBlend();
        }

        if (!stack2.isEmpty() && BlockWindowbox.canBePotted(stack2)) {


            GlStateManager.enableRescaleNormal();
                GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
                GlStateManager.enableBlend();
/*
                RenderHelper.enableStandardItemLighting();
*/
                GlStateManager.disableLighting();
                GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
                GlStateManager.pushMatrix();
/*          double offset = Math.sin((te.getWorld().getTotalWorldTime() - te.lastChangeTime + partialTicks) / 8) / 4.0;
            GlStateManager.translate(x + 0.5, y + 1.25 + offset, z + 0.5);
            GlStateManager.rotate((te.getWorld().getTotalWorldTime() + partialTicks) * 4, 0, 1, 0);*/

                //* South */
                if (te.getFacing() == 0) {
                    GlStateManager.translate(x + 0.25, y + 1.35, z + 0.75);
                }
                //* West */
                else if (te.getFacing() == 1) {
                    GlStateManager.translate(x + 0.25, y + 1.35, z + 0.25);
                    GlStateManager.rotate(90, 0, 1, 0);
                }
                //* North */
                else if (te.getFacing() == 2) {
                    GlStateManager.translate(x + 0.75, y + 1.35, z + 0.25);
                }
                //* East */
                else if (te.getFacing() == 3) {
                    GlStateManager.translate(x + 0.75, y + 1.35, z + 0.75);
                    GlStateManager.rotate(90, 0, 1, 0);
                }


                IBlockState state = Block.getBlockFromItem(stack2.getItem()).getStateForPlacement(getWorld(), te.getPos(), EnumFacing.NORTH, 0, 0, 0, stack2.getMetadata(), null, null);
                IBakedModel model = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelForState(state);
                //* To make model into item model: */
                /*.getRenderItem().getItemModelWithOverrides (stack, te.getWorld(), null);*/
                model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

                Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                Minecraft.getMinecraft().getRenderItem().renderItem(stack2, model);

                GlStateManager.popMatrix();
                GlStateManager.disableRescaleNormal();
                GlStateManager.disableBlend();

        }
    }

}
