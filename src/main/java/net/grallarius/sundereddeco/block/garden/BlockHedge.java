package net.grallarius.sundereddeco.block.garden;

import net.grallarius.sundereddeco.block.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHedge extends BlockBase {



    /** Whether the hedge should extend to the north */
    public static final PropertyBool NORTH = PropertyBool.create("north");
    /** Whether the hedge should extend to the east */
    public static final PropertyBool EAST = PropertyBool.create("east");
    /** Whether the hedge should extend to the south */
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    /** Whether the hedge should extend to the west */
    public static final PropertyBool WEST = PropertyBool.create("west");
    /** Similar logic for top hedge blocks */
    public static final PropertyBool TOP = PropertyBool.create("top");
    public static final PropertyBool TOPNORTH = PropertyBool.create("topnorth");
    public static final PropertyBool TOPEAST = PropertyBool.create("topeast");
    public static final PropertyBool TOPSOUTH = PropertyBool.create("topsouth");
    public static final PropertyBool TOPWEST = PropertyBool.create("topwest");

    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.125D, 0.0D,0.125D,0.875D,1.0D,0.875D);

    public BlockHedge(String name){
        super(Material.LEAVES, name);
        setSoundType(SoundType.PLANT);
        this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, false).withProperty(EAST, false)
                .withProperty(SOUTH, false).withProperty(WEST, false).withProperty(TOP, false)
                .withProperty(TOPNORTH, false).withProperty(TOPEAST, false).withProperty(TOPSOUTH, false)
                .withProperty(TOPWEST, false));
    }

    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDBOX;
    }

    /** If another block of type BlockHedge exists in that direction then join with a submodel */

    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        boolean northHedge = worldIn.getBlockState(pos.north()).getBlock() instanceof BlockHedge;
        boolean southHedge = worldIn.getBlockState(pos.south()).getBlock() instanceof BlockHedge;
        boolean eastHedge = worldIn.getBlockState(pos.east()).getBlock() instanceof BlockHedge;
        boolean westHedge = worldIn.getBlockState(pos.west()).getBlock() instanceof BlockHedge;
        boolean hedgeBelow = worldIn.getBlockState(pos.down()).getBlock() instanceof BlockHedge;

        return state.withProperty(NORTH, !hedgeBelow && northHedge)
                .withProperty(EAST,  !hedgeBelow && eastHedge)
                .withProperty(SOUTH, !hedgeBelow && southHedge)
                .withProperty(WEST,  !hedgeBelow && westHedge)
                .withProperty(TOP, hedgeBelow)
                .withProperty(TOPNORTH, hedgeBelow && northHedge)
                .withProperty(TOPEAST, hedgeBelow && eastHedge)
                .withProperty(TOPSOUTH, hedgeBelow && southHedge)
                .withProperty(TOPWEST, hedgeBelow && westHedge);
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {NORTH, EAST, SOUTH, WEST, TOP, TOPNORTH, TOPEAST, TOPSOUTH, TOPWEST});
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
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return Minecraft.getMinecraft().gameSettings.fancyGraphics ? BlockRenderLayer.CUTOUT_MIPPED : BlockRenderLayer.SOLID;
    }

    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }
}
