package si.meansoft.logisticraft.common.recipes;

import si.meansoft.logisticraft.common.items.LCItems;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipesItems {

	public static void itemRecipes() {
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(LCItems.coins, 8, 0), true, new Object[]{ " # ", "###", " # ", Character.valueOf('#'), LCItems.ingotCopper}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(LCItems.coins, 8, 1), true, new Object[]{ " # ", "###", " # ", Character.valueOf('#'), LCItems.ingotSilver}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(LCItems.coins, 8, 2), true, new Object[]{ " # ", "###", " # ", Character.valueOf('#'), Item.ingotGold}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(LCItems.coins, 8, 3), true, new Object[]{ " # ", "###", " # ", Character.valueOf('#'), LCItems.ingotPlatinum}));
	}
}
