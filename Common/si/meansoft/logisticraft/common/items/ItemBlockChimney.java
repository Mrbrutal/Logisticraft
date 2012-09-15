package si.meansoft.logisticraft.common.items;

import net.minecraft.src.*;

public class ItemBlockChimney extends ItemBlock {
	public ItemBlockChimney(int i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(64);
	}
	public String[] blockNames = { "Chimney", "Chimney top"};

	public String getItemNameIS(ItemStack itemstack) {
		return(new StringBuilder()).append(super.getItemName()).append(".").append(blockNames[itemstack.getItemDamage()]).toString();
	}
	
	public int getMetadata(int i) {
		return i;
	}
	
}
