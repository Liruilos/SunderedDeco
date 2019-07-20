package net.grallarius.sundereddeco.block.garden.windowbox;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public class TESRWindowbox extends TileEntityRenderer<TileEntityWindowbox> {

    @Override
    public void render(TileEntityWindowbox te, double x, double y, double z, float partialTicks, int destroyStage) {
        IItemHandler handler = te.getInventory();
        ItemStack stack1 = handler.getStackInSlot(0);
        ItemStack stack2 = handler.getStackInSlot(1);


       /* if (!stack1.isEmpty()) {
                GlStateManager.enableRescaleNormal();
                GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
                GlStateManager.enableBlend();
                GlStateManager.disableLighting();
                GlStateManager.blendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
                GlStateManager.pushMatrix();

                //South
                if (te.getFacing() == 0) {
                    GlStateManager.translated(x + 0.75, y + 1.35, z + 0.75);
                }
                // West
                else if (te.getFacing() == 1) {
                    GlStateManager.translated(x + 0.25, y + 1.35, z + 0.75);
                    GlStateManager.rotatef(90, 0, 1, 0);
                }
                // North
                else if (te.getFacing() == 2) {
                    GlStateManager.translated(x + 0.25, y + 1.35, z + 0.25);
                }
                //East
                else if (te.getFacing() == 3) {
                    GlStateManager.translated(x + 0.75, y + 1.35, z + 0.25);
                    GlStateManager.rotatef(90, 0, 1, 0);
                }

                //IBlockState state = Block.getBlockFromItem(stack1.getItem()).getStateForPlacement(getWorld(), te.getPos(), EnumFacing.NORTH, 0, 0, 0, stack1. getMetadata(), null, null);
                //IBlockState state = Block.getBlockFromItem(stack1.getItem()).getStateForPlacement(Block.getBlockFromItem(stack1.getItem()).getDefaultState(), EnumFacing.NORTH, null, getWorld(), null, null, null);
                IBlockState state = Block.getBlockFromItem(stack1.getItem()).getStateContainer().getBaseState();
                IBakedModel model = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(state);
                model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

                Minecraft.getInstance().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                Minecraft.getInstance().getItemRenderer().renderItem(stack1, model);


                GlStateManager.popMatrix();
                GlStateManager.disableRescaleNormal();
                GlStateManager.disableBlend();
        }

        if (!stack2.isEmpty()) {
            GlStateManager.enableRescaleNormal();
                GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
                GlStateManager.enableBlend();

                GlStateManager.disableLighting();
                GlStateManager.blendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
                GlStateManager.pushMatrix();

                //South
                if (te.getFacing() == 0) {
                    GlStateManager.translated(x + 0.25, y + 1.35, z + 0.75);
                }
                //West
                else if (te.getFacing() == 1) {
                    GlStateManager.translated(x + 0.25, y + 1.35, z + 0.25);
                    GlStateManager.rotatef(90, 0, 1, 0);
                }
                //North
                else if (te.getFacing() == 2) {
                    GlStateManager.translated(x + 0.75, y + 1.35, z + 0.25);
                }
                //East
                else if (te.getFacing() == 3) {
                    GlStateManager.translated(x + 0.75, y + 1.35, z + 0.75);
                    GlStateManager.rotatef(90, 0, 1, 0);
                }

                //IBlockState state = Block.getBlockFromItem(stack2.getItem()).getStateForPlacement(getWorld(), te.getPos(), EnumFacing.NORTH, 0, 0, 0, stack2.getMetadata(), null, null);
            IBlockState state = Block.getBlockFromItem(stack2.getItem()).getDefaultState();
            IBakedModel model = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(state);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getInstance().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            Minecraft.getInstance().getItemRenderer().renderItem(stack2, model);

            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();

        }*/
    }

}
