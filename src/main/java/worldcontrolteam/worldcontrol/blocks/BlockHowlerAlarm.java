package worldcontrolteam.worldcontrol.blocks;


import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import worldcontrolteam.worldcontrol.WorldControl;
import worldcontrolteam.worldcontrol.tileentity.TileEntityHowlerAlarm;
import worldcontrolteam.worldcontrol.utils.GuiLib;

public class BlockHowlerAlarm extends BlockIndustrialAlarm{

    public BlockHowlerAlarm(){
        super("HowlerAlarm");
    }

    @Override
    public TileEntity getTile(World world, int meta) {
        return new TileEntityHowlerAlarm();
    }

    @Override
    public boolean hasGUI() {
        return true;
    }

    @Override
    public int guiID() {
        return GuiLib.HOWLER_ALARM;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(player.getHeldItem(hand) != null) {
            if (player.getHeldItem(hand).getItem() instanceof ItemDye) {
                int metacolor = player.getHeldItem(hand).getMetadata();
                int color = ItemDye.DYE_COLORS[metacolor];
                ((TileEntityHowlerAlarm) world.getTileEntity(pos)).setColor(color);
                world.markBlockRangeForRenderUpdate(pos, pos);
                return true;
            }
        }
        return super.onBlockActivated(world, pos, state, player, hand, heldItem, side, hitX, hitY, hitZ);
    }

}