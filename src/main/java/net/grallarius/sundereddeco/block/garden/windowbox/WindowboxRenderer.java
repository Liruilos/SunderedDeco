package net.grallarius.sundereddeco.block.garden.windowbox;

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
import net.minecraftforge.items.IItemHandler;
import org.lwjgl.opengl.GL11;

public class WindowboxRenderer extends TileEntityRenderer<TileEntityWindowbox> {

    @Override
    public void render(TileEntityWindowbox te, double x, double y, double z, float partialTicks, int destroyStage) {
        IItemHandler handler = te.getInventory();
        ItemStack stack1 = handler.getStackInSlot(0);
        ItemStack stack2 = handler.getStackInSlot(1);

        TileEntityWindowbox tileEntity = (TileEntityWindowbox) Minecraft.getInstance().world.getTileEntity(te.getPos());


        if (!stack1.isEmpty()) {
                GlStateManager.enableRescaleNormal();
                GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
                GlStateManager.enableBlend();
                GlStateManager.disableLighting();
                GlStateManager.blendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
                GlStateManager.pushMatrix();

                //South
                if (tileEntity.getFacing() == 0) {
                    GlStateManager.translated(x + 0.75, y + 1.35, z + 0.75);
                }
                // West
                else if (tileEntity.getFacing() == 1) {
                    GlStateManager.translated(x + 0.25, y + 1.35, z + 0.75);
                    GlStateManager.rotatef(90, 0, 1, 0);
                }
                // North
                else if (tileEntity.getFacing() == 2) {
                    GlStateManager.translated(x + 0.25, y + 1.35, z + 0.25);
                }
                //East
                else if (tileEntity.getFacing() == 3) {
                    GlStateManager.translated(x + 0.75, y + 1.35, z + 0.25);
                    GlStateManager.rotatef(90, 0, 1, 0);
                }

            Block block = Block.getBlockFromItem(stack1.getItem());
            BlockState state = block.getStateContainer().getBaseState();
                IBakedModel model = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(state);
                model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

                Minecraft.getInstance().getTextureManager().bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
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

                Block block = Block.getBlockFromItem(stack2.getItem());
                BlockState state = block.getDefaultState();
            IBakedModel model = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(state);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getInstance().getTextureManager().bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
            Minecraft.getInstance().getItemRenderer().renderItem(stack2, model);

            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();

        }
    }

}
