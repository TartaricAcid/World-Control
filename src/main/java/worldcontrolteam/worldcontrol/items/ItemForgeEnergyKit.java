package worldcontrolteam.worldcontrol.items;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.energy.IEnergyStorage;


public class ItemForgeEnergyKit extends ItemBaseKit {

    public ItemForgeEnergyKit() {
        super("ForgeEnergyKit");
    }

    @Override
    public Item getCardType() {
        return WCItems.FORGE_ENERGY_CARD;
    }

    @Override
    public boolean canReturnCard(ItemStack stack, World world, BlockPos pos) {
        return world.getTileEntity(pos) instanceof IEnergyStorage;
    }
}