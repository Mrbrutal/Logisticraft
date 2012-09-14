package si.meansoft.logisticraft.common.blocks;

import java.util.List;

import si.meansoft.logisticraft.client.GUI.GuiStackCrafting;
import si.meansoft.logisticraft.common.Logisticraft;
import si.meansoft.logisticraft.common.library.Info;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockStackBench extends Block {

	protected BlockStackBench(int par1, int par2) {
		super(par1, par2, Material.iron);
		blockIndexInTexture = par2;
		setHardness(2.0F);
		setStepSound(soundMetalFootstep);
		setResistance(5.0F);
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public String getTextureFile() {
		return Info.TEX_BLOCK;
	}

	@Override
	public void getSubBlocks(int par1, CreativeTabs tabs, List list) {
		list.add(new ItemStack(this, 1, 0));
	}

	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		/* TOP */
		if (i == 1) {
			return blockIndexInTexture;
		}
		/* BOTTOM */
		if (i == 0) {
			return blockIndexInTexture + 1;
		}
		/* FRONT */
		if ((j == 2 && i == 2) || (j == 3 && i == 5) || (j == 0 && i == 3)
				|| (j == 1 && i == 4)) {
			return blockIndexInTexture + 2;
		} else {
			return blockIndexInTexture + 3;
		}
	}

	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving) {
		int l = MathHelper.floor_double((double) ((entityliving.rotationYaw * 4F) / 360F) + 2.5D) & 3;
		world.setBlockMetadataWithNotify(i, j, k, l);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par1, float par2, float par3, float par4) {
		if (!world.isRemote) {
			player.openGui(Logisticraft.instance, 1, world, x, y, z);
			System.out.println("Opening GUI");
			return true;
		}
		return true;
	}
}
