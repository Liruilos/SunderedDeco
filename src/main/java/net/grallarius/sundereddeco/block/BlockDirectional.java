package net.grallarius.sundereddeco.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import javax.annotation.Nullable;

public class BlockDirectional extends BlockBase {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public BlockDirectional(Properties properties, String name){
        super(properties, name);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.NORTH));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(FACING);
    }

    @Override
    @Nullable
    public IBlockState getStateForPlacement(BlockItemUseContext context) {
        if (context.getPlayer() != null) {
            return super.getStateForPlacement(context)
                    .with(FACING, context.getPlayer().getHorizontalFacing());
        }else return super.getStateForPlacement(context).with(FACING, EnumFacing.NORTH);
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
}
