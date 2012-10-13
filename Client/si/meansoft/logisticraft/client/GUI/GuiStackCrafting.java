package si.meansoft.logisticraft.client.GUI;

import java.util.Iterator;
import java.util.List;

import org.lwjgl.opengl.GL11;

import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.containers.ContainerStackbench;
import si.meansoft.logisticraft.common.core.StackCraftingManager;
import si.meansoft.logisticraft.common.core.interfaces.IStackRecipe;
import si.meansoft.logisticraft.common.library.Info;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.Container;
import net.minecraft.src.ContainerEnchantment;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderManager;
import net.minecraft.src.Slot;
import net.minecraft.src.StatCollector;
import net.minecraft.src.World;

@SideOnly(Side.CLIENT) public class GuiStackCrafting extends GuiContainer {

    private ContainerStackbench contSB;
    public int rendered = 0;

    public GuiStackCrafting(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
	super(new ContainerStackbench(par1InventoryPlayer, par2World, par3, par4, par5));
	this.contSB = (ContainerStackbench) this.inventorySlots;
    }

    public void drawGuiContainerForegroundLayer() {
	this.fontRenderer.drawString(LanguageRegistry.instance().getStringLocalization("gui.stackCrafting.name"), 28, 6, 4210752);
	this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    public void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
	int var5 = (this.width - this.xSize) / 2;
	int var6 = (this.height - this.ySize) / 2;

	int var4 = this.mc.renderEngine.getTexture(Info.TEX_GUI_SB);
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.7F);
	this.mc.renderEngine.bindTexture(var4);
	this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);

	GL11.glEnable(GL11.GL_BLEND);
	GL11.glBlendFunc(GL11.GL_DST_COLOR, GL11.GL_DST_COLOR);
	if (rendered == 0) {
	    this.fontRenderer.drawString("?", var5 + 129, var6 + 21, 4210752);
	}
	else if (rendered == 1) {
	    this.itemRenderer.renderItemIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, new ItemStack(LCBlocks.chimney, 0, 2), var5 + 124, var6 + 17);
	}
	else if (rendered == 2) {
	    this.itemRenderer.renderItemIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, new ItemStack(LCBlocks.chimney, 0, 3), var5 + 124, var6 + 17);
	}
	else {
	    this.fontRenderer.drawString("?", var5 + 129, var6 + 21, 4210752);
	}
	GL11.glDisable(GL11.GL_BLEND);
	/* GL11.glEnable(GL11.GL_BLEND); GL11.glBlendFunc(GL11.GL_DST_COLOR, GL11.GL_DST_COLOR); this.itemRenderer.renderItemIntoGUI(this.mc.fontRenderer,
	 * this.mc.renderEngine, new ItemStack(LCBlocks.chimney, 0, 2), var5 + 124, var6 + 17); GL11.glDisable(GL11.GL_BLEND); */

    }

    public void updateScreen() {
	super.updateScreen();
	// System.out.println(rendered);
	drawNew();
    }

    public void drawNew() {
	int var5 = (this.width - this.xSize) / 2;
	int var6 = (this.height - this.ySize) / 2;

	boolean hasCorrect = false;
	ItemStack stack = null;
	Slot slot = null;

	for (int var2 = 0; var2 < 10; ++var2) {
	    slot = (Slot) this.inventorySlots.getSlot(var2);
	    ItemStack it = slot.getStack();
	    if (it != null) {
		hasCorrect = true;
		stack = it;
		break;
	    }
	}
	int var4 = this.mc.renderEngine.getTexture(Info.TEX_GUI_SB);
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.7F);
	this.mc.renderEngine.bindTexture(var4);

	if (stack != null
		&& (stack.getItem().getItemName().startsWith("tile.box") || stack.getItem().getItemName().startsWith("tile.box2") || stack.getItem()
			.getItemName().startsWith("tile.box3"))) {
	    rendered = 1;
	    return;
	}

	List recipes = StackCraftingManager.getInstance().getRecipeList();
	Iterator var11 = recipes.iterator();
	Boolean render = false;

	while (var11.hasNext() && render == false) {
	    IStackRecipe var13 = (IStackRecipe) var11.next();
	    ItemStack[] items = var13.getRecipeItems();
	    if (items != null) {
		for (int i = 0; i < items.length; i++) {
		    if (items[i] != null) {
			if (stack != null && stack.getItem().getItemName().equals(items[i].getItem().getItemName())) {
			    //System.out.println("Item in crafting: " + items[i].getItemName() + " | " + stack.getItem().getItemName());
			    render = true;
			    rendered = 2;
			    break;
			}
			else {
			    rendered = 0;
			    break;
			}
		    }
		}
	    }
	}
    }
}
