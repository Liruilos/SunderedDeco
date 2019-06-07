package net.grallarius.sundereddeco.block.garden.flowerbeds;

import net.grallarius.sundereddeco.ModGuiHandler;
import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.block.BlockConnectableHTileEntity;
import net.grallarius.sundereddeco.block.BlockConnectableHorizontal;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;


//extends BlockConnectableHTileEntity<TileEntityDenseFlowerbed>
public class BlockDenseFlowerbed  {
    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.0D, 0.0D,0.0D,1.0D,0.6D,1.0D);

/*    private static final Properties props = Properties.create(Material.ROCK)
            .sound(SoundType.STONE);

    public BlockDenseFlowerbed(String name){
        super(props, name);
        this.setDefaultState(this.stateContainer.getBaseState().with(SHAPE, BlockConnectableHorizontal.EnumShape.SINGLE));
    }*/
    /*
    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockReader worldIn, BlockPos pos) {

        BlockConnectableHorizontal.EnumShape shape = getShape(state, worldIn, pos, worldIn.getBlockState(pos).getClass());
        return state.with(SHAPE, shape);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntityDenseFlowerbed te = getTileEntity(world, pos);
            IItemHandler itemHandler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);


            if (!player.isSneaking() && itemHandler != null) {
                if (player.getHeldItem(hand).isEmpty()) {
                    *//**remove items from relevant slot*//*
                    if(!itemHandler.getStackInSlot(3).isEmpty()){
                        player.inventory.placeItemBackInInventory(world, itemHandler.extractItem(3,1,false));
                    }
                    else if(!itemHandler.getStackInSlot(2).isEmpty()){
                        player.inventory.placeItemBackInInventory(world, itemHandler.extractItem(2,1,false));
                    }
                    else if(!itemHandler.getStackInSlot(1).isEmpty()){
                        player.inventory.placeItemBackInInventory(world, itemHandler.extractItem(1,1,false));
                    }
                    else if(!itemHandler.getStackInSlot(0).isEmpty()){
                        player.inventory.placeItemBackInInventory(world, itemHandler.extractItem(0,1,false));
                    }

                } else if(canBePotted(player.getHeldItem(hand))) {
                    *//**insert items from hand*//*
                    if(itemHandler.getStackInSlot(0).isEmpty()){

                        ItemStack singleItemFromHand1 = player.getHeldItem(hand).splitStack(1);
                        int remainder = player.getHeldItem(hand).getCount();
                        ItemStack remainingItems = player.getHeldItem(hand).splitStack(remainder);
                        player.setHeldItem(hand, itemHandler.insertItem(0, singleItemFromHand1, false));
                        player.setHeldItem(hand, remainingItems);

                    }
                    else if(itemHandler.getStackInSlot(1).isEmpty()){

                        ItemStack singleItemFromHand2 = player.getHeldItem(hand).splitStack(1);
                        int remainder = player.getHeldItem(hand).getCount();
                        ItemStack remainingItems = player.getHeldItem(hand).splitStack(remainder);
                        player.setHeldItem(hand, itemHandler.insertItem(1, singleItemFromHand2, false));
                        player.setHeldItem(hand, remainingItems);
                    }
                    else if(itemHandler.getStackInSlot(2).isEmpty()){

                        ItemStack singleItemFromHand3 = player.getHeldItem(hand).splitStack(1);
                        int remainder = player.getHeldItem(hand).getCount();
                        ItemStack remainingItems = player.getHeldItem(hand).splitStack(remainder);
                        player.setHeldItem(hand, itemHandler.insertItem(2, singleItemFromHand3, false));
                        player.setHeldItem(hand, remainingItems);
                    }
                    else if(itemHandler.getStackInSlot(3).isEmpty()){

                        ItemStack singleItemFromHand4 = player.getHeldItem(hand).splitStack(1);
                        int remainder = player.getHeldItem(hand).getCount();
                        ItemStack remainingItems = player.getHeldItem(hand).splitStack(remainder);
                        player.setHeldItem(hand, itemHandler.insertItem(3, singleItemFromHand4, false));
                        player.setHeldItem(hand, remainingItems);
                    }

                    else {return false;}
                    te.markDirty();
                }} else {
                player.openGui(SunderedDeco.instance, ModGuiHandler.DENSEFLOWERBED, world, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;
    }

    public static boolean canBePotted(ItemStack stack)
    {
        Block block = Block.getBlockFromItem(stack.getItem());
        Boolean isFlower = block instanceof BlockFlower;

        if ((!isFlower) && (block != Blocks.YELLOW_FLOWER) && (block != Blocks.RED_FLOWER) && (block != Blocks.BROWN_MUSHROOM) && (block != Blocks.RED_MUSHROOM) && (block != Blocks.SAPLING) && (block != Blocks.DEADBUSH))
        {
            int i = stack.getMetadata();
            return block == Blocks.TALLGRASS && i == BlockTallGrass.EnumType.FERN.getMeta();
        }
        else
        {
            return true;
        }
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityDenseFlowerbed tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack1 = itemHandler.getStackInSlot(0);
        ItemStack stack2 = itemHandler.getStackInSlot(1);
        ItemStack stack3 = itemHandler.getStackInSlot(2);
        ItemStack stack4 = itemHandler.getStackInSlot(3);
        if (!stack1.isEmpty()) {
            EntityItem item1 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack1);
            world.spawnEntity(item1);
        }
        if (!stack2.isEmpty()) {
            EntityItem item2 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack2);
            world.spawnEntity(item2);
        }
        if (!stack3.isEmpty()) {
            EntityItem item3 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack3);
            world.spawnEntity(item3);
        }
        if (!stack4.isEmpty()) {
            EntityItem item4 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack4);
            world.spawnEntity(item4);
        }
        super.breakBlock(world, pos, state);
    }*/
/*    @Override
    public Class<TileEntityDenseFlowerbed> getTileEntityClass() {
        return TileEntityDenseFlowerbed.class;
    }*/

   /* @Nullable
    @Override
    public TileEntityDenseFlowerbed createTileEntity(World world, IBlockState state) {
        return new TileEntityDenseFlowerbed();
    }

    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDBOX;
    }*/
}
