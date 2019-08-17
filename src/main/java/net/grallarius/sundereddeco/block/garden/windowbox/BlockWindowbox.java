package net.grallarius.sundereddeco.block.garden.windowbox;

import net.grallarius.sundereddeco.block.BlockTileEntity;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;


public class BlockWindowbox extends BlockTileEntity {

    public static final EnumProperty<EnumShape> SHAPE = EnumProperty.create("shape", EnumShape.class);
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape BOUNDING_BOX_NORTH = Block.makeCuboidShape(0, 8, 0, 16, 16, 8);
    private static final VoxelShape BOUNDING_BOX_SOUTH = Block.makeCuboidShape(0, 8, 8, 16, 16, 16);
    private static final VoxelShape BOUNDING_BOX_EAST = Block.makeCuboidShape(8, 8, 0, 16, 16, 16);
    private static final VoxelShape BOUNDING_BOX_WEST = Block.makeCuboidShape(0, 8, 0, 8, 16, 16);


    private static final Block.Properties props = Block.Properties.create(Material.ROCK)
            .sound(SoundType.STONE);

    public BlockWindowbox(){
        super(props);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(SHAPE, EnumShape.SINGLE));
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING))
        {
            case NORTH:
                return BOUNDING_BOX_NORTH;
            case SOUTH:
                return BOUNDING_BOX_SOUTH;
            case WEST:
                return BOUNDING_BOX_WEST;
            case EAST:
            default:
                return BOUNDING_BOX_EAST;
        }
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        if (context.getPlayer() != null) {
            return super.getStateForPlacement(context)
                    .with(FACING, context.getPlayer().getHorizontalFacing())
                    .with(SHAPE, EnumShape.SINGLE);
        }else return super.getStateForPlacement(context).with(FACING, Direction.NORTH).with(SHAPE, EnumShape.SINGLE);
    }

    @Override
    @Deprecated
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {

        //** Working out which type of model to place so all are connected correctly, ends (openleft and openright) = |_|
        //    straight = | |   and single = []

        if (world.getTileEntity(currentPos) instanceof TileEntityWindowbox) {
            TileEntityWindowbox tile = (TileEntityWindowbox) world.getTileEntity(currentPos);
            tile.setFacing(state.get(FACING).getHorizontalIndex());

            BlockState blockleft = world.getBlockState(currentPos.offset(state.get(FACING).rotateYCCW()));
            BlockState blockright = world.getBlockState(currentPos.offset(state.get(FACING).rotateY()));

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
/*    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, Direction side)
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
    }*/

/*    private boolean canAttachTo(World p_193392_1_, BlockPos p_193392_2_, Direction p_193392_3_)
    {
        BlockState iblockstate = p_193392_1_.getBlockState(p_193392_2_);
        //return iblockstate.getBlockFaceShape(p_193392_1_, p_193392_2_, p_193392_3_) == BlockFaceShape.SOLID && !iblockstate.canProvidePower();
        return iblockstate.func_193401_d(p_193392_1_, p_193392_2_, p_193392_3_)== BlockFaceShape.SOLID && !iblockstate.canProvidePower();
    }*/

    /**
     * Pops windowbox block off if full block it was placed against is removed
     */
    @Override
    @Deprecated
    public void updateNeighbors(BlockState state, IWorld worldIn, BlockPos pos, int flags) {
        Direction enumfacing = state.get(FACING);

/*        if (!this.canAttachTo(worldIn.getWorld(), pos.offset(enumfacing), enumfacing))
        {
            //TODO replace code with something that works - drop method commented out below
            //this.dropBlockAsItemWithChance(state, worldIn.getWorld(), pos, 1 , 0);
            //worldIn.removeBlock(pos);
        }*/
        super.updateNeighbors(state, worldIn, pos, flags);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, SHAPE);
    }

    @Override
    @Deprecated
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!world.isRemote) {
            if (world.getTileEntity(pos) instanceof TileEntityWindowbox) {
                TileEntityWindowbox tileEntity = (TileEntityWindowbox) world.getTileEntity(pos);
                IItemHandler itemHandler = tileEntity.getInventory();

                if (!player.isSneaking() && itemHandler != null) {
                    if (player.getHeldItem(player.getActiveHand()).isEmpty()) {
                        //remove items from relevant slot
                        if (!itemHandler.getStackInSlot(1).isEmpty()) {
                            player.inventory.placeItemBackInInventory(world, itemHandler.extractItem(1, 1, false));
                        } else if (!itemHandler.getStackInSlot(0).isEmpty()) {
                            player.inventory.placeItemBackInInventory(world, itemHandler.extractItem(0, 1, false));
                        }

                    } else if (canBePotted(player.getHeldItem(player.getActiveHand()))) {
                        //insert items from hand
                        if (itemHandler.getStackInSlot(0).isEmpty()) {

                            ItemStack singleItemFromHand1 = player.getHeldItem(player.getActiveHand()).split(1);
                            int remainder = player.getHeldItem(player.getActiveHand()).getCount();
                            ItemStack remainingItems = player.getHeldItem(player.getActiveHand()).split(remainder);
                            player.setHeldItem(player.getActiveHand(), itemHandler.insertItem(0, singleItemFromHand1, false));
                            player.setHeldItem(player.getActiveHand(), remainingItems);

                        } else if (itemHandler.getStackInSlot(1).isEmpty()) {

                            ItemStack singleItemFromHand2 = player.getHeldItem(player.getActiveHand()).split(1);
                            int remainder = player.getHeldItem(player.getActiveHand()).getCount();
                            ItemStack remainingItems = player.getHeldItem(player.getActiveHand()).split(remainder);
                            player.setHeldItem(player.getActiveHand(), itemHandler.insertItem(1, singleItemFromHand2, false));
                            player.setHeldItem(player.getActiveHand(), remainingItems);
                        }
                    }
                    tileEntity.saveAndSync();

                } else {
                    NetworkHooks.openGui((ServerPlayerEntity) player, tileEntity, tileEntity.getPos());
                }
            }
        }
        return true;
    }

    public static boolean canBePotted(ItemStack stack)
    {
        Block block = Block.getBlockFromItem(stack.getItem());
        Boolean isFlower = block instanceof FlowerBlock;

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

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityWindowbox();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
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
