package si.meansoft.logisticraft.common.blocks;

import java.util.ArrayList;

import net.minecraft.src.Block;
import net.minecraft.src.BlockStem;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import si.meansoft.logisticraft.common.items.LCItems;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class BlockStem2 extends BlockStem {

    private Block fruitType;

    public BlockStem2(int par1, Block block) {
	super(par1, block);
	fruitType = block;
	setTickRandomly(true);
	float var3 = 0.125F;
	setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
	setCreativeTab((CreativeTabs) null);
	setRequiresSelfNotify();
    }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
	ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

	for (int i = 0; i < 3; i++) {
	    if (world.rand.nextInt(15) <= metadata) {
		ret.add(new ItemStack(LCItems.cantaloupeSeeds));
	    }
	}
	return ret;
    }

    @SideOnly(Side.CLIENT)
    public int idPicked(World par1World, int par2, int par3, int par4) {
	return this.fruitType == LCBlocks.cantaloupe ? LCItems.cantaloupeSeeds.shiftedIndex : 0;
    }
}
