package net.grallarius.sundereddeco.block.garden.windowbox;

import net.grallarius.sundereddeco.ModGuiHandler;
import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.block.counterUseOnlyToGetTEsWorking.TileEntityCounter;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.chunk.BlockStateContainer;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.grallarius.sundereddeco.block.BlockTileEntity;


import javax.annotation.Nullable;


public class BlockWindowbox extends BlockTileEntity {

    public static final EnumProperty<EnumShape> SHAPE = EnumProperty.create("shape", EnumShape.class);
    public static final DirectionProperty FACING = BlockHorizontal.HORIZONTAL_FACING;

    protected static final AxisAlignedBB BOX_NORTH_AABB = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 0.5D);
    protected static final AxisAlignedBB BOX_SOUTH_AABB = new AxisAlignedBB(0.0D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB BOX_WEST_AABB = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.5D, 1.0D, 1.0D);
    protected static final AxisAlignedBB BOX_EAST_AABB = new AxisAlignedBB(0.5D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);

    private static final Properties props = Properties.create(Material.ROCK)
            .sound(SoundType.STONE);

    public BlockWindowbox(String name){
        super(props, name);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.NORTH).with(SHAPE, EnumShape.SINGLE));
    }

/*    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockReader source, BlockPos pos)
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
    }*/



    @Override
    @Nullable
    public IBlockState getStateForPlacement(BlockItemUseContext context) {
        if (context.getPlayer() != null) {
            return super.getStateForPlacement(context)
                    .with(FACING, context.getPlayer().getHorizontalFacing())
                    .with(SHAPE, EnumShape.SINGLE);
        }else return super.getStateForPlacement(context).with(FACING, EnumFacing.NORTH).with(SHAPE, EnumShape.SINGLE);
    }

    @Override
    @Deprecated
    public IBlockState updatePostPlacement(IBlockState state, EnumFacing facing, IBlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {

        //** Working out which type of model to place so all are connected correctly, ends (openleft and openright) = |_|
        //    straight = | |   and single = []

        if (world.getTileEntity(currentPos) instanceof TileEntityWindowbox) {
            TileEntityWindowbox tile = (TileEntityWindowbox) world.getTileEntity(currentPos);
            tile.setFacing(state.get(FACING).getHorizontalIndex());

            IBlockState blockleft = world.getBlockState(currentPos.offset(state.get(FACING).rotateYCCW()));
            IBlockState blockright = world.getBlockState(currentPos.offset(state.get(FACING).rotateY()));

            boolean leftMatch = blockleft.getBlock() instanceof BlockWindowbox && (state.get(FACING) == blockleft.get(FACING));
            boolean rightMatch = blockright.getBlock() instanceof BlockWindowbox && (state.get(FACING) == blockright.get(FACING));


            //** Check if no other windowboxes to the left and right in same facing, return single blockstates
            if (!leftMatch && !rightMatch) {
                return state.with(SHAPE, EnumShape.SINGLE);
            }

            //** Check if a windowboxe to the left in same facing but not the right, return endleft blockstates
            else if (leftMatch && !rightMatch) {
                return state.with(SHAPE, EnumShape.ENDLEFT);
            }

            //** Check if a windowboxe to the right in same facing but not the left, return endright blockstates
            else if (!leftMatch && rightMatch) {
                return state.with(SHAPE, EnumShape.ENDRIGHT);
            }

            //** Check if windowboxes exist to the left AND right in same facing, return straight blockstates
            else {
                return state.with(SHAPE, EnumShape.STRAIGHT);
            }
        }
        return state.with(SHAPE, EnumShape.SINGLE);
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
        EnumFacing enumfacing = state.get(FACING);

        if (!this.canAttachTo(worldIn, pos.offset(enumfacing), enumfacing))
        {
            this.dropBlockAsItemWithChance(state, worldIn, pos,1 , 0);
            worldIn.removeBlock(pos);
        }
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(FACING, SHAPE);
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }


    @Override
    @Deprecated
    public boolean onBlockActivated(IBlockState state, World world, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (world.getTileEntity(pos) instanceof TileEntityWindowbox) {
                TileEntityWindowbox te = (TileEntityWindowbox) world.getTileEntity(pos);
                IItemHandler itemHandler = te.getInventory();
                        //te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);


                if (!player.isSneaking() && itemHandler != null) {
                    if (player.getHeldItem(hand).isEmpty()) {
                    //remove items from relevant slot
                        if (!itemHandler.getStackInSlot(1).isEmpty()) {
                            player.inventory.placeItemBackInInventory(world, itemHandler.extractItem(1, 1, false));
                        } else if (!itemHandler.getStackInSlot(0).isEmpty()) {
                            player.inventory.placeItemBackInInventory(world, itemHandler.extractItem(0, 1, false));
                        }

                    } else if (canBePotted(player.getHeldItem(hand))) {
                    //insert items from hand
                        if (itemHandler.getStackInSlot(0).isEmpty()) {

                            ItemStack singleItemFromHand1 = player.getHeldItem(hand).split(1);
                            int remainder = player.getHeldItem(hand).getCount();
                            ItemStack remainingItems = player.getHeldItem(hand).split(remainder);
                            player.setHeldItem(hand, itemHandler.insertItem(0, singleItemFromHand1, false));
                            player.setHeldItem(hand, remainingItems);

                        } else if (itemHandler.getStackInSlot(1).isEmpty()) {

                            ItemStack singleItemFromHand2 = player.getHeldItem(hand).split(1);
                            int remainder = player.getHeldItem(hand).getCount();
                            ItemStack remainingItems = player.getHeldItem(hand).split(remainder);
                            player.setHeldItem(hand, itemHandler.insertItem(1, singleItemFromHand2, false));
                            player.setHeldItem(hand, remainingItems);
                        } else {
                            return false;
                        }
                        te.markDirty();
                    }
                } else {
                    NetworkHooks.openGui((EntityPlayerMP) player, new InteractionObjectWindowbox(te), (buffer) -> buffer.writeBlockPos(pos));
                    //player.openGui(SunderedDeco.instance, ModGuiHandler.WINDOWBOX, world, pos.getX(), pos.getY(), pos.getZ());
                }
            }
        }
        return true;
    }

    public static boolean canBePotted(ItemStack stack)
    {
        Block block = Block.getBlockFromItem(stack.getItem());
        Boolean isFlower = block instanceof BlockFlower;

        if ((!isFlower) && (block != Blocks.DANDELION) && (block != Blocks.POPPY) && (block != Blocks.BROWN_MUSHROOM)
                && (block != Blocks.RED_MUSHROOM) && (block != Blocks.ACACIA_SAPLING) && (block != Blocks.SPRUCE_SAPLING)
                && (block != Blocks.BIRCH_SAPLING) && (block != Blocks.DARK_OAK_SAPLING) && (block != Blocks.JUNGLE_SAPLING)
                && (block != Blocks.OAK_SAPLING) && (block != Blocks.DEAD_BUSH)) {
            /*int i = stack.getMetadata();
            return block == Blocks.TALLGRASS && i == BlockTallGrass.EnumType.FERN.getMeta();*/
            return false;
        }
        else
        {
            return true;
        }
    }

/*    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
        if (world.getTileEntity(pos) instanceof TileEntityWindowbox) {
            TileEntityWindowbox tile = (TileEntityWindowbox) world.getTileEntity(pos);
            IItemHandler itemHandler = tile.getInventory();
            for (int i = 0; i < 2; i++) {
                if (!itemHandler.getStackInSlot(i).isEmpty()) {
                    EntityItem droppedItem = new EntityItem(world.getWorld(), pos.getX(), pos.getY(), pos.getZ(), itemHandler.getStackInSlot(i));
                    world.spawnEntity(droppedItem);
                }
            }
        }
        super.harvestBlock(world, player, pos, state, te, stack);
    }*/

    @Override
    @Deprecated
    public void dropBlockAsItemWithChance(IBlockState state, World world, BlockPos pos, float chancePerItem, int fortune) {
        if (world.getTileEntity(pos) instanceof TileEntityWindowbox) {
            TileEntityWindowbox tile = (TileEntityWindowbox) world.getTileEntity(pos);
            IItemHandler itemHandler = tile.getInventory();
            for (int i = 0; i < 2; i++) {
                if (!itemHandler.getStackInSlot(i).isEmpty()) {
                    EntityItem droppedItem = new EntityItem(world.getWorld(), pos.getX(), pos.getY(), pos.getZ(), itemHandler.getStackInSlot(i));
                    world.spawnEntity(droppedItem);
                }
            }
        }
        super.dropBlockAsItemWithChance(state, world, pos, chancePerItem, fortune);
    }

    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntityWindowbox();
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
