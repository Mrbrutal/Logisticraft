package si.meansoft.logisticraft.common.items;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import si.meansoft.logisticraft.common.library.Info;

public class ItemBlockGlass extends ItemBlock {

    public ItemBlockGlass(int par1) {
	super(par1);
	setMaxDamage(0);
	setHasSubtypes(true);
	setMaxStackSize(64);
    }

    public String[] blockNames = Info.glassNames;

    public String getItemNameIS(ItemStack itemstack) {
	return (new StringBuilder()).append(super.getItemName()).append(".").append(blockNames[itemstack.getItemDamage()]).toString();
    }

    public int getMetadata(int i) {
	return i;
    }
}
