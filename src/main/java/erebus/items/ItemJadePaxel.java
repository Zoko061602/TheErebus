package erebus.items;

import net.minecraft.item.ItemStack;
import erebus.ModItems;
import erebus.ModMaterials;
import erebus.items.ItemMaterials.EnumType;

public class ItemJadePaxel extends ItemPaxel {

	public ItemJadePaxel() {
		super(ModMaterials.TOOL_JADE_PAXEL);
	}

	@Override
	public boolean getIsRepairable(ItemStack stack, ItemStack material) {
		return material.getItem() == ModItems.MATERIALS && material.getItemDamage() == EnumType.JADE.ordinal();
	}
}