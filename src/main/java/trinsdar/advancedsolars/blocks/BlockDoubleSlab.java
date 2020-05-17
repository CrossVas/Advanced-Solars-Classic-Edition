package trinsdar.advancedsolars.blocks;

import java.util.List;

import ic2.core.IC2;
import ic2.core.platform.lang.ILocaleBlock;
import ic2.core.platform.lang.components.base.LocaleComp;
import ic2.core.platform.textures.Ic2Icons;
import ic2.core.platform.textures.obj.ITexturedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trinsdar.advancedsolars.util.AdvancedSolarLang;

public class BlockDoubleSlab extends Block implements ITexturedBlock, ILocaleBlock {

	public BlockDoubleSlab(String name, LocaleComp locale) {
		super(Material.ROCK);
		setHardness(1.5F);
		setCreativeTab(IC2.tabIC2);
		setRegistryName(name);
	}

	@Override
	public LocaleComp getName() {
		return AdvancedSolarLang.doubleSlab;
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		drops.add(new ItemStack(Blocks.STONE_SLAB, 2, 0));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public TextureAtlasSprite getParticleTexture(IBlockState state) {
		return Ic2Icons.getTextures("doublestoneslab")[1];
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox(IBlockState state) {
		return FULL_BLOCK_AABB;
	}

	@SuppressWarnings("deprecation")
	@Override
	public IBlockState getStateFromStack(ItemStack stack) {
		return this.getStateFromMeta(stack.getMetadata());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public TextureAtlasSprite getTextureFromState(IBlockState state, EnumFacing facing) {
		if (facing.getAxis() == EnumFacing.Axis.Y) {
			return Ic2Icons.getTextures("doublestoneslab")[0];
		}
		return Ic2Icons.getTextures("doublestoneslab")[1];
	}

	@Override
	public List<IBlockState> getValidStates() {
		return this.blockState.getValidStates();
	}
	
	public static class BlockSeamlessDoubleSlab extends BlockDoubleSlab {
		public BlockSeamlessDoubleSlab(String name, LocaleComp locale) {
			super(name, locale);
		}
		
		@SideOnly(Side.CLIENT)
		@Override
		public TextureAtlasSprite getTextureFromState(IBlockState state, EnumFacing facing) {
			return Ic2Icons.getTextures("doublestoneslab")[0];
		}
		
		@Override
		public LocaleComp getName() {
			return AdvancedSolarLang.seamlessDoubleStab;
		}
	}
}
