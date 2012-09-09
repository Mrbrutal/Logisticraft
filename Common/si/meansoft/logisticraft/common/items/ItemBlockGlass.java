package si.meansoft.logisticraft.common.items;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemBlockGlass extends ItemBlock{

	public ItemBlockGlass(int par1) {
		super(par1);
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(64);
	}

	public String[] blockNames = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" };

	public String getItemNameIS(ItemStack itemstack) {
		return(new StringBuilder()).append(super.getItemName()).append(".").append(blockNames[itemstack.getItemDamage()]).toString();
	}
	
	public int getMetadata(int i) {
		return i;
	}
}
