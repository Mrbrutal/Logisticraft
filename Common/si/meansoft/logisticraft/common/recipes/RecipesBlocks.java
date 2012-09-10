package si.meansoft.logisticraft.common.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.items.LCItems;

public class RecipesBlocks {
	
	public static void blockRecipes() {
		
		/* Ore block smelting */
		FurnaceRecipes.smelting().addSmelting(LCBlocks.ores.blockID, 0, new ItemStack(LCItems.ingotPlatinum));
		FurnaceRecipes.smelting().addSmelting(LCBlocks.ores.blockID, 1, new ItemStack(LCItems.ingotSilver));
		FurnaceRecipes.smelting().addSmelting(LCBlocks.ores.blockID, 2, new ItemStack(LCItems.ingotCopper));
		
		/* Colored glass */
		for (int i = 0; i < 16; i++) {
			GameRegistry.addShapelessRecipe(new ItemStack(LCBlocks.coloredGlass, 1, i), new Object[]{Block.glass, new ItemStack(Item.dyePowder, 1, i)});
		}
	}
}
