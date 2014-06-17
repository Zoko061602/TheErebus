package erebus.block;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;
import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.UP;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import erebus.ModBlocks.ISubBlocksBlock;
import erebus.item.block.ItemBlockErebusPlantSmall;

public class BlockWallPlants extends Block implements IShearable, ISubBlocksBlock {

	public static final String[] iconPaths = new String[] { "moss", "lichen" };//, "lichen"

	public static final int dataMoss = 0, dataLichen = 6;// 

	@SideOnly(Side.CLIENT)
	public IIcon[] icons;

	public BlockWallPlants() {
		super(Material.plants);
		setTickRandomly(true);
	}

	@Override
	public void setBlockBoundsForItemRender() {
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public void registerBlockIcons(IIconRegister reg) {
		icons = new IIcon[iconPaths.length];
		int i = 0;
		for (String path : iconPaths)
			icons[i++] = reg.registerIcon("erebus:" + path);
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		if (meta < 0)
			return null;
		if (meta <= 5)
			return icons[0];
		else
			return icons[1];
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubBlocks(Item id, CreativeTabs tab, List list) {
		for (int i = 0; i < icons.length; i++)
			list.add(new ItemStack(id, 1, i));
	}

	@Override
	public int getRenderType() {
		return 0;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return true;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess access, int x, int y, int z) {
		int meta = access.getBlockMetadata(x, y, z);
		float widthMin = 0, heightMin = 0, depthMin = 0;
		float widthMax = 0, heightMax = 0, depthMax = 0;

		switch (meta) {
			case 0:
				widthMin = 0F;
				heightMin = 0.875F;
				depthMin = 0F;
				widthMax = 0F;
				heightMax = 0F;
				depthMax = 0F;
				break;
			case 1:
				widthMin = 0F;
				heightMin = 0F;
				depthMin = 0F;
				widthMax = 0F;
				heightMax = 0.875F;
				depthMax = 0F;
				break;
			case 2:
				widthMin = 0F;
				heightMin = 0F;
				depthMin = 0.875F;
				widthMax = 0F;
				heightMax = 0F;
				depthMax = 0F;
				break;
			case 3:
				widthMin = 0F;
				heightMin = 0F;
				depthMin = 0F;
				widthMax = 0F;
				heightMax = 0F;
				depthMax = 0.8125F;
				break;
			case 4:
				widthMin = 0.8125F;
				heightMin = 0;
				depthMin = 0F;
				widthMax = 0F;
				heightMax = 0;
				depthMax = 0F;
				break;
			case 5:
				widthMin = 0F;
				heightMin = 0F;
				depthMin = 0F;
				widthMax = 0.8125F;
				heightMax = 0F;
				depthMax = 0F;
				break;
		}
		setBlockBounds(0F + widthMin, 0F + heightMin, 0F + depthMin, 1F - widthMax, 1F - heightMax, 1F - depthMax);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.isSideSolid(x, y + 1, z, DOWN) || world.isSideSolid(x, y - 1, z, UP) || world.isSideSolid(x - 1, y, z, EAST) || world.isSideSolid(x + 1, y, z, WEST) || world.isSideSolid(x, y, z - 1, SOUTH) || world.isSideSolid(x, y, z + 1, NORTH);
	}

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {

		if (side == 0 && world.isSideSolid(x, y + 1, z, DOWN))
			meta = 0;

		if (side == 1 && world.isSideSolid(x, y - 1, z, UP))
			meta = 1;

		if (side == 2 && world.isSideSolid(x, y, z + 1, NORTH))
			meta = 2;

		if (side == 3 && world.isSideSolid(x, y, z - 1, SOUTH))
			meta = 3;

		if (side == 4 && world.isSideSolid(x + 1, y, z, WEST))
			meta = 4;

		if (side == 5 && world.isSideSolid(x - 1, y, z, EAST))
			meta = 5;

		return meta;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbour) {
		int meta = world.getBlockMetadata(x, y, z);
		boolean flag = false;

		if (meta == 0 && world.isSideSolid(x, y + 1, z, DOWN))
			flag = true;

		if (meta == 1 && world.isSideSolid(x, y - 1, z, UP))
			flag = true;

		if (meta == 2 && world.isSideSolid(x, y, z + 1, NORTH))
			flag = true;

		if (meta == 3 && world.isSideSolid(x, y, z - 1, SOUTH))
			flag = true;

		if (meta == 4 && world.isSideSolid(x + 1, y, z, WEST))
			flag = true;

		if (meta == 5 && world.isSideSolid(x - 1, y, z, EAST))
			flag = true;

		if (!flag) {
			breakBlock(world, x, y, z, neighbour, meta);
			world.setBlockToAir(x, y, z);
		}

		super.onNeighborBlockChange(world, x, y, z, neighbour);
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	public int getDamageValue(World world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z);
	}

	@Override
	public Item getItemDropped(int id, Random random, int fortune) {
		return null;
	}

	@Override
	public int quantityDropped(Random rand) {
		return 0;
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta) {
		super.harvestBlock(world, player, x, y, z, meta);
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1));
		return ret;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess access, int x, int y, int z) {
		return 16777215;
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return ItemBlockErebusPlantSmall.class;
	}

}