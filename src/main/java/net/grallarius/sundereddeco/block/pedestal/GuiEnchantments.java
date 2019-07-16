package net.grallarius.sundereddeco.block.pedestal;

import net.grallarius.sundereddeco.SunderedDeco;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GuiEnchantments extends GuiScreen
{
    //due to texture file being 512x512 instead of 256x256, all these pixel values had to be halved.
    private final int bookStartHeight = 99;
    private final int bookImageHeight = 91;
    private static final int bookImageWidth = 139;
    private int currPage = 0;
    private static final int bookTotalPages = 6;
    //private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
    private static final ResourceLocation BG_TEXTURE = new ResourceLocation(SunderedDeco.MODID, "textures/gui/manual.png");
    private static String[] stringPageText = new String[bookTotalPages];
    private static String[] stringPageTitle = new String[bookTotalPages];
    private GuiButton buttonDone;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;


    public GuiEnchantments()
    {

/*        bookPageTextures[0] = new ResourceLocation(

                SunderedDeco.MODID+":textures/gui/manual.png");

        bookPageTextures[1] = new ResourceLocation(

                SunderedDeco.MODID+":textures/gui/book.png");
        */



        //page titles
        stringPageTitle[0] = "";
        stringPageTitle[1] = "Enchantments";
        stringPageTitle[2] = "Weapon Enchantments";
        stringPageTitle[3] = "Armour Enchantments";
        stringPageTitle[4] = "Tool Enchantments";
        stringPageTitle[5] = "Trident Enchantments";

        //page text (inc subtitles)
        stringPageText[0] = "";
        stringPageText[1] = "This book will one day list all the vanilla and modded enchantments that we have available in game. \n\nFor now, it just looks pretty.";
        stringPageText[2]= "§lBane of Arthropods§r\nEach level separately adds 2.5 extra damage to each hit to \"arthropod\" mobs (spiders, cave spiders, silverfish and endermites) and adds a Slowness IV effect with random duration.";
        stringPageText[3]= "§lAqua Affinity§r\nIncreases underwater mining rate.\nNormally, when mining underwater, a 5x penalty is applied to mining time. When mining while wearing armor with aqua affinity, this penalty is ignored.\n\n§lBlast Protection§r\nReduces explosion damage and reduces explosion knockback by (15 × level)%. If multiple pieces have the enchantment, only the highest level's reduction is used.";
        stringPageText[4]= "";
        stringPageText[5]= "";

        //TODO add to end of weapons section: Sharpness, Smite, and Bane of Arthropods are mutually exclusive
        //TODO add to end of armour section: Protection, Blast Protection, Fire Protection, and Projectile Protection are mutually exclusive.
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
/*    @Override
    public void initGui()
    {
        // DEBUG
        System.out.println("Gui Enchantments initGUI()");
        buttonList.clear();
        Keyboard.enableRepeatEvents(true);

        buttonDone = new GuiButton(0, width / 2 + 2, 4 + bookImageHeight,

                98, 20, I18n.format("gui.done", new Object[0]));

        buttonList.add(buttonDone);
        int offsetFromScreenLeft = (width - bookImageWidth) / 2;
        buttonList.add(buttonNextPage = new NextPageButton(1, offsetFromScreenLeft + 120, 156, true));
        buttonList.add(buttonPreviousPage = new NextPageButton(2, offsetFromScreenLeft + 38, 156, false));
    }*/

    /**
     * Called from the main game loop to update the screen.
     */
/*    @Override
    public void updateScreen()
    {
        buttonDone.visible = (currPage == bookTotalPages - 1);
        buttonNextPage.visible = (currPage < bookTotalPages - 1);
        buttonPreviousPage.visible = currPage > 0;
    }*/

    /**
     * Draws the screen and all the components in it.
     */
/*    @Override
    public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(BG_TEXTURE);
        int offsetFromScreenLeft = (width - bookImageWidth ) / 2;

        GlStateManager.scale(2, 2, 2);

        if (currPage == 0)
        {
            drawTexturedModalRect(offsetFromScreenLeft/4, 2, 0, 0, bookImageWidth, bookImageHeight);

            //mc.getTextureManager().bindTexture(bookPageTextures[0]);
        }
        else
        {
            drawTexturedModalRect(offsetFromScreenLeft/4, 2, 0, bookStartHeight, bookImageWidth, bookImageHeight);
            //mc.getTextureManager().bindTexture(bookPageTextures[1]);
        }
        GlStateManager.scale(0.5, 0.5, 0.5);



        int widthOfString;
        String stringPageIndicator = I18n.format("book.pageIndicator", new Object[] {Integer.valueOf(currPage + 1), bookTotalPages});

        widthOfString = fontRenderer.getStringWidth(stringPageIndicator);
        GlStateManager.scale(0.5, 0.5, 0.5);
        fontRenderer.drawString(stringPageIndicator, (offsetFromScreenLeft - widthOfString + bookImageWidth - 44) * 2, 8 * 2, 0);
        GlStateManager.scale(2, 2, 2);
        fontRenderer.drawStringWithShadow(stringPageTitle[currPage], offsetFromScreenLeft + 36, 18, 0xB40431);
        fontRenderer.drawSplitString(stringPageText[currPage], offsetFromScreenLeft + 36, 34, 116, 0);
        super.drawScreen(parWidth, parHeight, p_73863_3_);
    }*/

 /*   *//**
     * Called when a mouse button is pressed and the mouse is moved around.
     * Parameters are : mouseX, mouseY, lastButtonClicked &
     * timeSinceMouseClick.
     *//*
    @Override
    protected void mouseClickMove(int parMouseX, int parMouseY, int parLastButtonClicked, long parTimeSinceMouseClick) {}

    @Override
    protected void actionPerformed(GuiButton parButton)
    {
        if (parButton == buttonDone)
        {
            // You can send a packet to server here if you need server to do
            // something
            mc.displayGuiScreen((GuiScreen)null);
        }
        else if (parButton == buttonNextPage)
        {
            if (currPage < bookTotalPages - 1)
            {
                ++currPage;
            }
        }
        else if (parButton == buttonPreviousPage)
        {
            if (currPage > 0)
            {
                --currPage;
            }
        }
    }*/

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat
     * events
     */
/*    @Override
    public void onGuiClosed()
    {

    }*/

    /**
     * Returns true if this GUI should pause the game when it is displayed in
     * single-player
     */
/*    @Override
    public boolean doesGuiPauseGame()
    {
        return true;
    }*/

    @OnlyIn(Dist.CLIENT)
    static class NextPageButton extends GuiButton
    {
        private final boolean isNextButton;

        public NextPageButton(int parButtonId, int parPosX, int parPosY, boolean parIsNextButton)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
            isNextButton = parIsNextButton;
        }

       /*  // Draws this button to the screen
        @Override
        public void drawButton(Minecraft mc, int parX, int parY, float partialTicks) {
            if (visible)
            {
                boolean isButtonPressed = ((parX >= this.x)

                        && (parY >= this.y)

                        && (parX < (this.x + width))

                        && (parY < (this.y + height)));

                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(BG_TEXTURE);
                int textureX = 151;
                int textureY = 3;
                int posX = this.x;
                int posY = this.y;

                if (isButtonPressed)
                {
                    textureX += 11;
                }

                if (!isNextButton)
                {
                    textureY += 6;
                }
                GlStateManager.scale(2, 2, 2);
                drawTexturedModalRect(posX/2, posY/2, textureX, textureY, 23, 13);
                GlStateManager.scale(0.5, 0.5, 0.5);
            }
        }*/
    }
}
