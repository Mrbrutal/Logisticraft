package si.meansoft.logisticraft.client.GUI;

import org.lwjgl.opengl.GL11;

import si.meansoft.logisticraft.common.containers.ContainerStackbench;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;
import net.minecraft.src.World;

@SideOnly(Side.CLIENT)
public class GuiStackCrafting extends GuiContainer {
    public GuiStackCrafting(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
        super(new ContainerStackbench(par1InventoryPlayer, par2World, par3, par4, par5));
        System.out.println("Drawing bg!");
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer() {
        this.fontRenderer.drawString("Stack crafting", 28, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        int var4 = this.mc.renderEngine.getTexture("/gui/crafting.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(var4);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
    }
}
