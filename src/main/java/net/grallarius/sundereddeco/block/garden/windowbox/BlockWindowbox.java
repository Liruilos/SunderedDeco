package net.grallarius.sundereddeco.block.garden.windowbox;

import net.grallarius.sundereddeco.ModGuiHandler;
import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.slots.SlotFlower;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.grallarius.sundereddeco.block.BlockTileEntity;


import javax.annotation.Nullable;

public class BlockWindowbox extends BlockTileEntity<TileEntityWindowbox> {

    public static final PropertyEnum<EnumShape> SHAPE = PropertyEnum.create("shape", EnumShape.class);
    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    protected static final AxisAlignedBB BOX_NORTH_AABB = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 0.5D);
    protected static final AxisAlignedBB BOX_SOUTH_AABB = new AxisAlignedBB(0.0D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB BOX_WEST_AABB = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.5D, 1.0D, 1.0D);
    protected static final AxisAlignedBB BOX_EAST_AABB = new AxisAlignedBB(0.5D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);
    
    public BlockWindowbox(String name){
        super(Material.ROCK, name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(SHAPE, EnumShape.SINGLE));
    }

    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        switch ((EnumFacing)state.getValue(FACING))
        {
            case NORTH:
                return BOX_NORTH_AABB;
            case SOUTH:
                return BOX_SOUTH_AABB;
            case WEST:
                return BOX_WEST_AABB;
            case EAST:
            default:
                return BOX_EAST_AABB;
        }
    }

    @Override
    @Deprecated
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
    }


    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

        /** Working out which type of model to place so all are connected correctly, end (openleft and openright) = |_|
         *    straight = | |   and single  */

        TileEntityWindowbox tile = getTileEntity(worldIn, pos);
        tile.setFacing(state.getValue(FACING).getHorizontalIndex());

        IBlockState blockleft = worldIn.getBlockState(pos.offset(state.getValue(FACING).rotateYCCW()));
        IBlockState blockright = worldIn.getBlockState(pos.offset(state.getValue(FACING).rotateY()));

        boolean leftMatch = blockleft.getBlock() instanceof BlockWindowbox && (state.getValue(FACING) == blockleft.getValue(FACING));
        boolean rightMatch = blockright.getBlock() instanceof BlockWindowbox && (state.getValue(FACING) == blockright.getValue(FACING));


        /** Check if no other windowboxes to the left and right in same facing, return single blockstates */
        if(!leftMatch && !rightMatch){ return state.withProperty(SHAPE, EnumShape.SINGLE); }

        /** Check if a windowboxe to the left in same facing but not the right, return endleft blockstates */
        else if(leftMatch && !rightMatch){ return state.withProperty(SHAPE, EnumShape.ENDLEFT); }

        /** Check if a windowboxe to the right in same facing but not the left, return endright blockstates */
        else if(!leftMatch && rightMatch){ return state.withProperty(SHAPE, EnumShape.ENDRIGHT); }

        /** Check if windowboxes exist to the left AND right in same facing, return straight blockstates */
        else{ return state.withProperty(SHAPE, EnumShape.STRAIGHT); }

    }

    /**
     * Check whether this Block can be placed at pos, while aiming at the side of an adjacent block (can only be placed on sides of full blocks)
     */
    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side)
    {
        if (this.canAttachTo(worldIn, pos.west(), side))
        {
            return true;
        }
        else if (this.canAttachTo(worldIn, pos.east(), side))
        {
            return true;
        }
        else if (this.canAttachTo(worldIn, pos.north(), side))
        {
            return true;
        }
        else
        {
            return this.canAttachTo(worldIn, pos.south(), side);
        }
    }

    private boolean canAttachTo(World p_193392_1_, BlockPos p_193392_2_, EnumFacing p_193392_3_)
    {
        IBlockState iblockstate = p_193392_1_.getBlockState(p_193392_2_);
        boolean flag = isExceptBlockForAttachWithPiston(iblockstate.getBlock());
        return !flag && iblockstate.getBlockFaceShape(p_193392_1_, p_193392_2_, p_193392_3_) == BlockFaceShape.SOLID && !iblockstate.canProvidePower();
    }

    /**
     * Pops windowbox block off if full block it was placed against is removed
     */
    @Deprecated
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

        if (!this.canAttachTo(worldIn, pos.offset(enumfacing), enumfacing))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }

        super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING, SHAPE});
    }


    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }


    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntityWindowbox te = getTileEntity(world, pos);
            IItemHandler itemHandler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);


            if (!player.isSneaking() && itemHandler != null) {
                if (player.getHeldItem(hand).isEmpty()) {
                    //remove items from relevant slot//
                    if(!itemHandler.getStackInSlot(1).isEmpty()){
                        player.setHeldItem(hand, itemHandler.extractItem(1, 1, false));
                    }
                    else if(!itemHandler.getStackInSlot(0).isEmpty()){
                        player.setHeldItem(hand, itemHandler.extractItem(0, 1, false));
                    }

                } else if(canBePotted(player.getHeldItem(hand))) {
                    //insert items from hand//
                    if(itemHandler.getStackInSlot(0).isEmpty()){

                    ItemStack singleItemFromHand1 = player.getHeldItem(hand).splitStack(1);
                    int remainder = player.getHeldItem(hand).getCount();
                    ItemStack remainingItems = player.getHeldItem(hand).splitStack(remainder);
                    player.setHeldItem(hand, itemHandler.insertItem(0, singleItemFromHand1, false));
                    player.setHeldItem(hand, remainingItems);

                    /*player.setHeldItem(hand, itemHandler.insertItem(0, player.getHeldItem(hand), false));*/

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
                player.openGui(SunderedDeco.instance, ModGuiHandler.WINDOWBOX, world, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;
    }

    public static boolean canBePotted(ItemStack stack)
    {
        Block block = Block.getBlockFromItem(stack.getItem());
        Boolean isFlower = block instanceof BlockFlower;

        if ((!isFlower) && (block != Blocks.YELLOW_FLOWER) && (block != Blocks.RED_FLOWER) && (block != Blocks.CACTUS) && (block != Blocks.BROWN_MUSHROOM) && (block != Blocks.RED_MUSHROOM) && (block != Blocks.SAPLING) && (block != Blocks.DEADBUSH))
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
        TileEntityWindowbox tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack1 = itemHandler.getStackInSlot(0);
        ItemStack stack2 = itemHandler.getStackInSlot(1);
        ItemStack stack3 = itemHandler.getStackInSlot(2);
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
        super.breakBlock(world, pos, state);
    }
    @Override
    public Class<TileEntityWindowbox> getTileEntityClass() {
        return TileEntityWindowbox.class;
    }

    @Nullable
    @Override
    public TileEntityWindowbox createTileEntity(World world, IBlockState state) {
        return new TileEntityWindowbox();
    }


    @Override
    @Deprecated
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
    }

    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    public enum EnumShape implements IStringSerializable {

        ENDLEFT( 0, "endleft"),
        STRAIGHT( 1, "straight"),
        ENDRIGHT( 2, "endright"),
        SINGLE( 3, "single");

        private final int meta;
        private final String name;
        private static final EnumShape[] LOOKUP = new EnumShape[values().length];

        EnumShape(int meta, String name) {
            this.meta = meta;
            this.name = name;
        }

        static {
            for(EnumShape shape : values()) {
                LOOKUP[shape.getMetadata()] = shape;
            }
        }

        public static EnumShape byMetadata(int meta) {
            if(meta < 0 || meta >= LOOKUP.length) {
                meta = 0;
            }
            return LOOKUP[meta];
        }

        public int getMetadata() {
            return this.meta;
        }

        public String toString() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

    }

}
