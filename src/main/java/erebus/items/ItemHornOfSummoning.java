package erebus.items;

import erebus.ModSounds;
import erebus.ModTabs;
import erebus.entity.EntityWorkerBee;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemHornOfSummoning extends Item {

	public ItemHornOfSummoning() {
		setMaxStackSize(1);
		setCreativeTab(ModTabs.ITEMS);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack is) {
		return EnumAction.BLOCK;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack is) {
		return 30;
	}

	@Override
	 public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		world.playSound(null, player.getPosition(), ModSounds.HORN_BLOW, SoundCategory.PLAYERS, 1.0F, 2.0F);
		return new ActionResult(EnumActionResult.PASS, stack);
	}

	@Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entity) {
		stack.shrink(1);
		summonBees(stack, world, entity);
		return stack;
	}

	protected void summonBees(ItemStack is, World world, EntityLivingBase entity) {
		if (!world.isRemote)
			for (int a = -3; a < world.rand.nextInt(6); a++) {
				EntityWorkerBee bee = new EntityWorkerBee(world);
				bee.setPosition(entity.posX, entity.posY + 3, entity.posZ);
				world.spawnEntity(bee);
			}
	}
}