package erebus.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityFireResistent extends EntityItem {

	public EntityFireResistent(World world, double x, double y, double z) {
		super(world, x, y, z);
		isImmuneToFire = true;
	}

	public EntityFireResistent(World world, double x, double y, double z, ItemStack stack) {
		super(world, x, y, z, stack);
		isImmuneToFire = true;
	}

	public EntityFireResistent(World world) {
		super(world);
		isImmuneToFire = true;
	}

	@Override
	public void dealFireDamage(int damage) {
	}

	@Override
	public void setFire(int seconds) {
	}

	@Override
	public void setOnFireFromLava() {
	}
}