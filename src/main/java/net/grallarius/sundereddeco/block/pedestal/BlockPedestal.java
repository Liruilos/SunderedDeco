package net.grallarius.sundereddeco.block.pedestal;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;

//extends BlockTileEntity<TileEntityPedestal>
public class BlockPedestal  {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    /** Whether there should be a book model on the pedestal */
    public static final BooleanProperty HASBOOK = BooleanProperty.create("hasbook");

/*    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.2D, 0.0D,0.2D,0.8D,1.2D,0.8D);
    private static final Properties props = Properties.create(Material.WOOD)
            .sound(SoundType.WOOD);

    public BlockPedestal(String name) {
        super(props, name);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.NORTH).with(HASBOOK, false));
    }*/

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, HASBOOK);
    }

/*    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockReader source, BlockPos pos) {
        return BOUNDBOX;
    }

    @Override
    @Deprecated
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().with(FACING, placer.getHorizontalFacing());
    }

    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }*/

/*    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }*/

  /*  @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntityPedestal tile = getTileEntity(world, pos);
            IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);
            if (!player.isSneaking() && itemHandler != null) {
                //TODO add different open gui options depending on what is in the pedestal, ie. enchantments list, defer open gui
                if (itemHandler.getStackInSlot(0).getItem() instanceof ItemBook){
                    player.openGui(SunderedDeco.instance, ModGuiHandler.PEDESTAL, world, pos.getX(), pos.getY(), pos.getZ());
                }
                tile.markDirty();
                if (itemHandler.getStackInSlot(0).getItem() instanceof ItemEnchantedBook){
                    //Minecraft.getMinecraft().displayGuiScreen(new GuiEnchantments());
                }
                tile.markDirty();
            } else {
                player.openGui(SunderedDeco.instance, ModGuiHandler.PEDESTAL, world, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityPedestal tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack = itemHandler.getStackInSlot(0);
        if (!stack.isEmpty()) {
            EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntity(item);
        }
        super.breakBlock(world, pos, state);
    }*/

/*    @Override
    public Class<TileEntityPedestal> getTileEntityClass() {
        return TileEntityPedestal.class;
    }*/

/*    @Nullable
    @Override
    public TileEntityPedestal createTileEntity(World world, IBlockState state) {
        return new TileEntityPedestal();
    }*/
}
