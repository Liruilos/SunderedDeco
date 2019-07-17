package net.grallarius.sundereddeco.block.garden.flowerbeds;


import net.grallarius.sundereddeco.ModGuiHandler;
import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.block.BlockConnectableHTileEntity;
import net.minecraft.block.Block;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

//extends BlockConnectableHTileEntity<TileEntityFlowerbed>
public class BlockFlowerbed  {

    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.0D, 0.0D,0.0D,1.0D,0.6D,1.0D);
/*    private static final Properties props = Properties.create(Material.ROCK)
            .sound(SoundType.STONE);

    public BlockFlowerbed(String name){
        super(props, name);
        this.setDefaultState(this.stateContainer.getBaseState().with(SHAPE, EnumShape.SINGLE));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(SHAPE);
    }*/
    /*
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntityFlowerbed te = getTileEntity(world, pos);
            IItemHandler itemHandler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);


            if (!player.isSneaking() && itemHandler != null) {
                if (player.getHeldItem(hand).isEmpty()) {
                    *//**remove items from relevant slot*//*

                    if(!itemHandler.getStackInSlot(1).isEmpty()){
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

                    else {return false;}
                    te.markDirty();
                }} else {
                player.openGui(SunderedDeco.instance, ModGuiHandler.FLOWERBED, world, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;
    }*/

/*    public static boolean canBePotted(ItemStack stack)
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
    }*/
/*
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityFlowerbed tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack1 = itemHandler.getStackInSlot(0);
        ItemStack stack2 = itemHandler.getStackInSlot(1);

        if (!stack1.isEmpty()) {
            EntityItem item1 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack1);
            world.spawnEntity(item1);
        }
        if (!stack2.isEmpty()) {
            EntityItem item2 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack2);
            world.spawnEntity(item2);
        }

        super.breakBlock(world, pos, state);
    }*/


/*    @Override
    public Class<TileEntityFlowerbed> getTileEntityClass() {
        return TileEntityFlowerbed.class;
    }*/

/*    @Nullable
    @Override
    public TileEntityFlowerbed createTileEntity(World world, IBlockState state) {
        return new TileEntityFlowerbed();
    }

    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

        EnumShape shape = getShape(state, worldIn, pos, worldIn.getBlockState(pos).getClass());
        return state.withProperty(SHAPE, shape);
    }

    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDBOX;
    }*/

}
