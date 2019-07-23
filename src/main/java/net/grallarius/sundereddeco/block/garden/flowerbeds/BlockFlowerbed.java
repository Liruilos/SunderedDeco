package net.grallarius.sundereddeco.block.garden.flowerbeds;


import net.grallarius.sundereddeco.block.BlockConnectableHorizontal;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

import static net.grallarius.sundereddeco.block.garden.windowbox.BlockWindowbox.canBePotted;

public class BlockFlowerbed extends BlockConnectableHorizontal {

    private static final VoxelShape BOUNDING_BOX = Block.makeCuboidShape(0, 0, 0, 16, 9.5, 16);
    private static final Properties props = Properties.create(Material.ROCK)
            .sound(SoundType.STONE);

    public BlockFlowerbed(String name){
        super(props, name);
    }

    @Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (!world.isRemote) {

            if (world.getTileEntity(pos) instanceof TileEntityFlowerbed) {
                TileEntityFlowerbed tileEntity = (TileEntityFlowerbed) world.getTileEntity(pos);
                IItemHandler itemHandler = tileEntity.getInventory();


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
                        } else {
                            return false;
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

    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }


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


    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityFlowerbed();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }


    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return BOUNDING_BOX;
    }

}
