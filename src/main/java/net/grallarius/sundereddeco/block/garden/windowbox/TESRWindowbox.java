package net.grallarius.sundereddeco.block.garden.windowbox;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.opengl.GL11;

public class TESRWindowbox extends TileEntitySpecialRenderer<TileEntityWindowbox> {
    @Override
    public void render(TileEntityWindowbox te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        ItemStack stack = te.inventory.getStackInSlot(0);
        if (!stack.isEmpty()) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
            GlStateManager.enableBlend();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
            GlStateManager.pushMatrix();
/*          double offset = Math.sin((te.getWorld().getTotalWorldTime() - te.lastChangeTime + partialTicks) / 8) / 4.0;
            GlStateManager.translate(x + 0.5, y + 1.25 + offset, z + 0.5);
            GlStateManager.rotate((te.getWorld().getTotalWorldTime() + partialTicks) * 4, 0, 1, 0);*/

            //* South */
            if(te.getFacing() == 0){
                GlStateManager.translate(x + 0.75, y + 1.0, z + 0.75);
            }
            //* West */
            else if(te.getFacing() == 1){
                GlStateManager.translate(x + 0.25, y + 1.0, z + 0.75);
            }
            //* North */
            else if(te.getFacing() == 2){
                GlStateManager.translate(x + 0.25, y + 1.0, z + 0.25);
            }
            //* East */
            else if(te.getFacing() == 3){
                GlStateManager.translate(x + 0.75, y + 1.0, z + 0.25);
            }

            IBakedModel model = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides (stack, te.getWorld(), null);
            model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);

            Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            Minecraft.getMinecraft().getRenderItem().renderItem(stack, model);

            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
        }
    }
}
