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


public class BlockDenseFlowerbed extends BlockConnectableHorizontal {

    private static final VoxelShape BOUNDING_BOX = Block.makeCuboidShape(0, 0, 0, 16, 9, 16);
    private static final Block.Properties props = Block.Properties.create(Material.ROCK)
            .sound(SoundType.STONE);

    public BlockDenseFlowerbed(){
        super(props);
    }

    @Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!world.isRemote) {

            if (world.getTileEntity(pos) instanceof TileEntityDenseFlowerbed) {
                TileEntityDenseFlowerbed tileEntity = (TileEntityDenseFlowerbed) world.getTileEntity(pos);
                IItemHandler itemHandler = tileEntity.getInventory();


                if (!player.isSneaking() && itemHandler != null) {
                    if (player.getHeldItem(handIn).isEmpty()) {
                        //remove items from relevant slot
                        if(!itemHandler.getStackInSlot(3).isEmpty()){
                            player.inventory.placeItemBackInInventory(world, itemHandler.extractItem(3,1,false));
                        } else if(!itemHandler.getStackInSlot(2).isEmpty()){
                            player.inventory.placeItemBackInInventory(world, itemHandler.extractItem(2,1,false));
                        } else if (!itemHandler.getStackInSlot(1).isEmpty()) {
                            player.inventory.placeItemBackInInventory(world, itemHandler.extractItem(1, 1, false));
                        } else if (!itemHandler.getStackInSlot(0).isEmpty()) {
                            player.inventory.placeItemBackInInventory(world, itemHandler.extractItem(0, 1, false));
                        }

                    } else if (canBePotted(player.getHeldItem(handIn))) {
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

                        } else if(itemHandler.getStackInSlot(2).isEmpty()){
                            ItemStack singleItemFromHand3 = player.getHeldItem(player.getActiveHand()).split(1);
                            int remainder = player.getHeldItem(player.getActiveHand()).getCount();
                            ItemStack remainingItems = player.getHeldItem(player.getActiveHand()).split(remainder);
                            player.setHeldItem(player.getActiveHand(), itemHandler.insertItem(2, singleItemFromHand3, false));
                            player.setHeldItem(player.getActiveHand(), remainingItems);
                        }
                        else if(itemHandler.getStackInSlot(3).isEmpty()){
                            ItemStack singleItemFromHand4 = player.getHeldItem(player.getActiveHand()).split(1);
                            int remainder = player.getHeldItem(player.getActiveHand()).getCount();
                            ItemStack remainingItems = player.getHeldItem(player.getActiveHand()).split(remainder);
                            player.setHeldItem(player.getActiveHand(), itemHandler.insertItem(3, singleItemFromHand4, false));
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


    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityDenseFlowerbed();
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

    /*@Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityDenseFlowerbed tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack1 = itemHandler.getStackInSlot(0);
        ItemStack stack2 = itemHandler.getStackInSlot(1);
        ItemStack stack3 = itemHandler.getStackInSlot(2);
        ItemStack stack4 = itemHandler.getStackInSlot(3);
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
        if (!stack4.isEmpty()) {
            EntityItem item4 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack4);
            world.spawnEntity(item4);
        }
        super.breakBlock(world, pos, state);
    }*/

}
