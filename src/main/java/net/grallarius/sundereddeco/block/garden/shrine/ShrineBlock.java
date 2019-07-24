package net.grallarius.sundereddeco.block.garden.shrine;

import net.grallarius.sundereddeco.block.BlockDirectional;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

public class ShrineBlock extends BlockDirectional {
    private static final VoxelShape BOUNDING_BOX = VoxelShapes.or(
            Block.makeCuboidShape(1, 3, 1, 15, 16, 15),
            Block.makeCuboidShape(3, 0, 3, 13, 3, 13));

    private static final Properties props = Properties.create(Material.ROCK)
            .sound(SoundType.STONE);

    public ShrineBlock(String name){
        super(props, name);
    }


    @Override
    @Deprecated
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!world.isRemote) {
            if (world.getTileEntity(pos) instanceof ShrineTileEntity) {
                ShrineTileEntity tileEntity = (ShrineTileEntity) world.getTileEntity(pos);
                IItemHandler itemHandler = tileEntity.getInventory();

                if (!player.isSneaking() && itemHandler != null) {
                    if (player.getHeldItem(player.getActiveHand()).isEmpty()) {
                        //remove items from relevant slot
                        if (!itemHandler.getStackInSlot(0).isEmpty()) {
                            player.inventory.placeItemBackInInventory(world, itemHandler.extractItem(0, 1, false));
                        }

                    } else if (itemHandler.getStackInSlot(0).isEmpty()) {
                        //insert items from hand
                        ItemStack singleItemFromHand1 = player.getHeldItem(player.getActiveHand()).split(1);
                        int remainder = player.getHeldItem(player.getActiveHand()).getCount();
                        ItemStack remainingItems = player.getHeldItem(player.getActiveHand()).split(remainder);
                        player.setHeldItem(player.getActiveHand(), itemHandler.insertItem(0, singleItemFromHand1, false));
                        player.setHeldItem(player.getActiveHand(), remainingItems);

                    }
                }
                tileEntity.saveAndSync();
            }
        }
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ShrineTileEntity();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return BOUNDING_BOX;
    }
}
