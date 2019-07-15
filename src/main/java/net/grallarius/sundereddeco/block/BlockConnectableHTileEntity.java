package net.grallarius.sundereddeco.block;


import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;

import static net.grallarius.sundereddeco.SunderedDeco.MODID;

public abstract class BlockConnectableHTileEntity<TE extends TileEntity> extends BlockConnectableHorizontal {

    public BlockConnectableHTileEntity(Properties properties, String name) {
        super(properties, name);
    }

    public abstract Class<TE> getTileEntityClass();

    public TE getTileEntity(IBlockReader world, BlockPos pos) {
        return (TE)world.getTileEntity(pos);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

 /*   @Nullable
    @Override
    public abstract TE createTileEntity(World world, IBlockState state);*/

/*    public void register() {
        GameRegistry.registerTileEntity(this.getTileEntityClass(), MODID + this.getTranslationKey());
        super.register();
    }*/


}
