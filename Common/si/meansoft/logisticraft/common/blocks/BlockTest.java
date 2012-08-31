package si.meansoft.logisticraft.common.blocks;

import si.meansoft.logisticraft.common.core.Info;
import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockTest extends Block {

	public BlockTest(int par1, int par2) {
		super(par1, par2, Material.rock);
		blockIndexInTexture = par2;
	}
	
	@Override
    public String getTextureFile() {
    	return Info.TEX_BLOCK;
    }
	
}
