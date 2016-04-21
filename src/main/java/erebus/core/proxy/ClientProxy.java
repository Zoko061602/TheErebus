package erebus.core.proxy;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
 /*
	public enum BlockRenderIDs {
		BAMBOO_CROP,
		HOLLOW_LOG,
		PLANTED_FLOWER,
		GLOWSHROOM_STALK,
		GLOWSHROOM_CAPS,
		SILO_ROOF,
		SILO_SUPPORTS,
		COMPOSTER,
		KEYSTONE,
		DOUBLE_PLANTS,
		VELOCITY_BLOCK,
		DOOR,
		SWAMP_VENT;

		//TODO: getNextAvailableRenderId() deoesnt exist
		private final int ID = 1337;

		BlockRenderIDs() {
			//ID = RenderingRegistry.getNextAvailableRenderId();
		}

		public int id() {
			return ID;
		}
	}

	@Override
	public void registerKeyHandlers() {
		FMLCommonHandler.instance().bus().register(new KeyBindingHandler());
	}

	@Override
	public void registerRenderInformation() {
		FMLCommonHandler.instance().bus().register(new GogglesClientTickHandler());
		RenderingRegistry.registerEntityRenderingHandler(EntityBeetle.class, new RenderBeetle());
		RenderingRegistry.registerEntityRenderingHandler(EntityFly.class, new RenderFly());
		RenderingRegistry.registerEntityRenderingHandler(EntityTarantula.class, new RenderTarantula());
		RenderingRegistry.registerEntityRenderingHandler(EntityMosquito.class, new RenderMosquito());
		RenderingRegistry.registerEntityRenderingHandler(EntityVelvetWorm.class, new RenderVelvetWorm());
		RenderingRegistry.registerEntityRenderingHandler(EntityWasp.class, new RenderWasp());
		RenderingRegistry.registerEntityRenderingHandler(EntityCentipede.class, new RenderCentipede());
		RenderingRegistry.registerEntityRenderingHandler(EntityBeetleLarva.class, new RenderBeetleLarva());
		RenderingRegistry.registerEntityRenderingHandler(EntityBotFly.class, new RenderBotFly());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackWidow.class, new RenderBlackWidow());
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpion.class, new RenderScorpion());
		RenderingRegistry.registerEntityRenderingHandler(EntityGrasshopper.class, new RenderGrasshopper());
		RenderingRegistry.registerEntityRenderingHandler(EntityLocust.class, new RenderLocust());
		RenderingRegistry.registerEntityRenderingHandler(EntitySolifuge.class, new RenderSolifuge());
		RenderingRegistry.registerEntityRenderingHandler(EntityMoth.class, new RenderMoth());
		RenderingRegistry.registerEntityRenderingHandler(EntityAntlion.class, new RenderAntlion(new ModelAntlion(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWaspDagger.class, new WaspDaggerItemRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityAnimatedBlock.class, new RenderAnimatedBlock(new ModelAnimatedBlock(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAnimatedChest.class, new RenderAnimatedChest(new ModelAnimatedChest(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAnimatedBambooCrate.class, new RenderAnimatedBlock(new ModelAnimatedBlock(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGlowWorm.class, new RenderGlowWorm(new ModelGlowWorm(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityScytodes.class, new RenderScytodes(new ModelScytodes(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMoneySpider.class, new RenderMoneySpider(new ModelScytodes(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityUmberGolem.class, new RenderUmberGolem(new ModelUmberGolem(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPrayingMantis.class, new RenderPrayingMantis(new ModelPrayingMantis(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityJumpingSpider.class, new RenderJumpingSpider(new ModelJumpingSpider(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFireAnt.class, new RenderFireAnt(new ModelFireAnt(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRhinoBeetle.class, new RenderRhinoBeetle(new ModelRhinoBeetle(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWebSling.class, new RenderWebSling());
		RenderingRegistry.registerEntityRenderingHandler(EntityErebusLightningBolt.class, new RenderErebusLightningBolt());
		RenderingRegistry.registerEntityRenderingHandler(EntityExtractedBlock.class, new RenderExtractedBlock());
		RenderingRegistry.registerEntityRenderingHandler(EntityWorkerBee.class, new RenderWorkerBee());
		RenderingRegistry.registerEntityRenderingHandler(EntityDragonfly.class, new RenderDragonfly());
		RenderingRegistry.registerEntityRenderingHandler(EntityBloodSnail.class, new RenderBloodSnail());
		RenderingRegistry.registerEntityRenderingHandler(EntityTitanBeetle.class, new RenderTitanBeetle());
		RenderingRegistry.registerEntityRenderingHandler(EntityBotFlyLarva.class, new RenderBotFlyLarva());
		RenderingRegistry.registerEntityRenderingHandler(EntityCrushling.class, new RenderCrushling());
		RenderingRegistry.registerEntityRenderingHandler(EntityWheatWeevil.class, new RenderWheatWeevil(new ModelWheatWeevil(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGooBall.class, new RenderGooBall());
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodlouse.class, new RenderWoodlouse(new ModelWoodlouse(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodlouseBall.class, new WoodlouseBallItemRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityCicada.class, new RenderCicada(new ModelCicada(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFireAntSoldier.class, new RenderFireAntSoldier(new ModelFireAntSoldier(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMucusBombPrimed.class, new RenderMucusBombPrimed());
		RenderingRegistry.registerEntityRenderingHandler(EntityLavaWebSpider.class, new RenderLavaWebSpider(new ModelLavaWebSpider(), 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAntlionMiniBoss.class, new RenderAntlionMiniBoss(new ModelAntlion(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityChameleonTick.class, new RenderChameleonTick(new ModelChameleonTick(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySolifugeSmall.class, new RenderSolifugeSmall());
		RenderingRegistry.registerEntityRenderingHandler(EntityMidgeSwarm.class, new RenderMidgeSwarm());
		RenderingRegistry.registerEntityRenderingHandler(EntityPunchroom.class, new RenderPunchroom());
		RenderingRegistry.registerEntityRenderingHandler(EntitySporeBall.class, new RenderSporeBall());
		RenderingRegistry.registerEntityRenderingHandler(EntityCrushroom.class, new RenderCrushroom());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackAnt.class, new RenderBlackAnt());
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieAnt.class, new RenderZombieAnt());
		RenderingRegistry.registerEntityRenderingHandler(EntityTarantulaMiniboss.class, new RenderTarantulaMiniboss());
		RenderingRegistry.registerEntityRenderingHandler(EntityTarantulaBaby.class, new RenderTarantulaBaby());
		RenderingRegistry.registerEntityRenderingHandler(EntityTarantulaEgg.class, new RenderEntityTarantulaEgg());
		RenderingRegistry.registerEntityRenderingHandler(EntityPoisonJet.class, new RenderPoisonJet());
		RenderingRegistry.registerEntityRenderingHandler(EntityGasVent.class, new RenderGasVent());
		RenderingRegistry.registerEntityRenderingHandler(EntityPondSkater.class, new RenderPondSkater());
		RenderingRegistry.registerEntityRenderingHandler(EntityLeech.class, new RenderLeech());
		RenderingRegistry.registerEntityRenderingHandler(EntitySnapper.class, new RenderSnapper());
		RenderingRegistry.registerEntityRenderingHandler(EntityWisp.class, new RenderWisp());
		RenderingRegistry.registerEntityRenderingHandler(EntityUmberGolemDungeonTypes.class, new RenderUmberGolemDungeonType());
		RenderingRegistry.registerEntityRenderingHandler(EntityMagmaCrawler.class, new RenderMagmaCrawler());
		RenderingRegistry.registerEntityRenderingHandler(EntityAntlionBoss.class, new RenderAntlionBoss());
		RenderingRegistry.registerEntityRenderingHandler(EntityThrownSand.class, new RenderThrownSand());
		RenderingRegistry.registerEntityRenderingHandler(EntityBombardierBeetle.class, new RenderBombardierBeetle());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityErebusAltar.class, new TileEntityErebusAltarRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityErebusAltarLightning.class, new TileEntityErebusAltarLightningRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityErebusAltarHealing.class, new TileEntityErebusAltarHealingRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityErebusAltarXP.class, new TileEntityErebusAltarXPRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityErebusAltarRepair.class, new TileEntityErebusAltarRepairRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBambooCrate.class, new TileEntityRenderBambooCrate());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGlowingJar.class, new TileEntityGlowingJarRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLadder.class, new TileEntityLadderRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBambooBridge.class, new TileEntityBambooBridgeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityUmberGolemStatue.class, new TileEntityUmberGolemStatueRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPetrifiedWoodChest.class, new TileEntityPetrifiedWoodChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBones.class, new TileEntityBoneBlockRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBambooPole.class, new TileEntityBambooPoleRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityExtenderThingy.class, new TileEntityExtenderThingyRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGlowGem.class, new TileEntityGlowGemRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGaeanKeystone.class, new TileEntityGaeanKeystoneRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOfferingAltar.class, new TileEntityOfferingAltarRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTarantulaEgg.class, new TileEntityTarantulaEggRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmoothieMaker.class, new TileEntitySmoothieMakerRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAntlionEgg.class, new TileEntityAntlionEggRenderer());

		//TODO: Get ISBRH's taken care of
		//RenderingRegistry.registerBlockHandler(new BlockBambooCropRender());
		//RenderingRegistry.registerBlockHandler(new BlockHollowLogRender());
		//RenderingRegistry.registerBlockHandler(new BlockPlantedFlowerRender());
		//RenderingRegistry.registerBlockHandler(new BlockGlowshroomStalkRender());
		//RenderingRegistry.registerBlockHandler(new BlockGlowshroomRender());
		//RenderingRegistry.registerBlockHandler(new BlockSiloRoofRender());
		//RenderingRegistry.registerBlockHandler(new BlockSiloSupportsRender());
		//RenderingRegistry.registerBlockHandler(new BlockComposterRender());
		//RenderingRegistry.registerBlockHandler(new BlockKeystoneRenderer());
		//RenderingRegistry.registerBlockHandler(new BlockDoublePlantRender());
		//RenderingRegistry.registerBlockHandler(new BlockVelocityBlockRender());
		//RenderingRegistry.registerBlockHandler(new BlockDoorRenderer());
		//RenderingRegistry.registerBlockHandler(new BlockSwampVentRenderer());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.bambooCrate), new BambooCrateItemRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.altarBase), new ItemAltarBaseRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.altarLightning), new ItemAltarBaseRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.altarHealing), new ItemAltarBaseRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.altarXP), new ItemAltarBaseRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.altarRepair), new ItemAltarBaseRenderer());
		MinecraftForgeClient.registerItemRenderer(ModItems.waspSword, new WaspSwordItemRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.umberFurnace), new ItemUmberFurnaceRenderer());
		MinecraftForgeClient.registerItemRenderer(ModItems.waspDagger, new WaspDaggerItemRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.bambooTorch), new BambooTorchItemRenderer());
		MinecraftForgeClient.registerItemRenderer(ModItems.wandOfAnimation, new WandOfAnimationItemRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.glowingJar), new ItemGlowingJarRenderer());
		MinecraftForgeClient.registerItemRenderer(ModItems.scorpionPincer, new ScorpionPincerItemRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.umberGolemStatue), new ItemUmberGolemStatueRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.petrifiedWoodChest), new ItemPetrifiedWoodChestRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.bones), new ItemBoneBlockRenderer());
		MinecraftForgeClient.registerItemRenderer(ModItems.webSlinger, new WebSlingerItemRenderer());
		MinecraftForgeClient.registerItemRenderer(ModItems.witherWebSlinger, new WebSlingerItemRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.bambooBridge), new BambooBridgeItemRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.extenderThingy), new ExtenderThingyItemRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.bambooPole), new BambooPoleItemRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.jarOHoney), new ItemGlowingJarRenderer());
		MinecraftForgeClient.registerItemRenderer(ModItems.woodlouseBall, new WoodlouseBallItemRenderer());
		MinecraftForgeClient.registerItemRenderer(ModItems.portalActivator, new PortalActivatorRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.offeringAltar), new ItemOfferingAltarRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.tarantulaEgg), new ItemTarantulaEggRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.smoothieMaker), new ItemSmoothieMakerRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.antlionEgg), new ItemAntlionEggRenderer());
		MinecraftForgeClient.registerItemRenderer(ModItems.warHammer, new WarHammerItemRenderer());
	}

	@Override
	public void registerBlockRendering() {
		BlockRenderingRegistry.init();
	}

	@Override
	public void registerItemRendering() {
		ItemRenderingRegistry.init();
	}

	@Override
	public void spawnCustomParticle(String particleName, World world, double x, double y, double z, double vecX, double vecY, double vecZ) {
		EntityFX fx = null;

		// TODO Figure out what this means
		int seemenlyRandomInt = 0;

		if (particleName.equals("repellent"))
			fx = new EntityRepellentFX(world, x, y, z, 0.0F, 0.0F, 0.0F);

		if (particleName.equals("sonic"))
			fx = new EntitySonicFX(world, x, y, z, vecX, vecY, vecZ);

		if (particleName.equals("bubblegas")) {
			fx = new EntityBubbleGasFX(world, x, y, z, vecX, vecY, vecZ);
			fx.setRBGColorF(0.306F, 0.576F, 0.192F);
		}

		if (particleName.equals("swampflame")) {
			fx = new EntityFlameFX.Factory().getEntityFX(seemenlyRandomInt, world, x, y, z, vecX, vecY, vecZ);
			fx.setParticleTextureIndex(96);
		}

		if (particleName.equals("portal"))
			fx = new EntityPortalFX.Factory().getEntityFX(seemenlyRandomInt, world, x, y, z, vecX, vecY, vecZ);

		if (particleName.equals("cloud"))
			fx = new EntityCloudFX.Factory().getEntityFX(seemenlyRandomInt, world, x, y, z, vecX, vecY, vecZ);

		if (particleName.equals("spell"))
			fx = new EntitySpellParticleFX.Factory().getEntityFX(seemenlyRandomInt, world, x, y, z, vecX, vecY, vecZ);

		if (particleName.equals("heart"))
			fx = new EntityHeartFX.Factory().getEntityFX(seemenlyRandomInt, world, x, y, z, vecX, vecY, vecZ);

		if (particleName.equals("smoke"))
			fx = new EntitySmokeFX.Factory().getEntityFX(seemenlyRandomInt, world, x, y, z, vecX, vecY, vecZ);

		if (particleName.equals("poison")) {
			fx = new EntitySpellParticleFX.Factory().getEntityFX(seemenlyRandomInt, world, x, y, z, vecX, vecY, vecZ);
			fx.setRBGColorF(0.306F, 0.576F, 0.192F);
		}

		if (particleName.equals("flame"))
			fx = new EntityFlameFX.Factory().getEntityFX(seemenlyRandomInt, world, x, y, z, vecX, vecY, vecZ);

		if (particleName.equals("enchantmenttable"))
			fx = new EntityEnchantmentTableParticleFX.EnchantmentTable().getEntityFX(seemenlyRandomInt, world, x, y, z, vecX, vecY, vecZ);

		if (particleName.equals("lava"))
			fx = new EntityLavaFX.Factory().getEntityFX(seemenlyRandomInt, world, x, y, z, 0, 0, 0);

		if (particleName.equals("slime"))
			fx = new EntityBreakingFX.SlimeFactory().getEntityFX(seemenlyRandomInt, world, x, y, z, vecX, vecY, vecZ);

		if (particleName.equals("sparks"))
			fx = new EntityFireworkSparkFX(world, x, y, z, vecX, vecY, vecZ, Minecraft.getMinecraft().effectRenderer);

		if (fx != null)
			Minecraft.getMinecraft().effectRenderer.addEffect(fx);
	} */
	//Please turn this off again after using
	
	// A LITTLE CODE BORROWED FROM BETWEENLANDS - THANKS GUYS ;)
	
	//Please turn this off again after using
    private static final boolean createJSONFile = true;
	 @Override
	    public void registerDefaultBlockItemRenderer(Block block) {
		 String name = block.getRegistryName().toString();
	        System.out.println("GIBBERISH FOR TESTING: " + block + " STRING NAME: " + name);
	      //  ModelLoader.registerItemVariants(Item.getItemFromBlock(block), new ModelResourceLocation(name, "inventory"));
	        //FIXME: Uhm yeah, ModelLoader#registerItemVariants (the proper way afaik?) doesn't seem to work, so I've also added this here
	      //  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), x, new ModelResourceLocation(name, "inventory"));
	            
	        if (createJSONFile)
	            createJSONForBlock(name);
	    }
	 
/*
	    @Override
	    public void registerDefaultItemRenderer(Item item) {
	        List<ItemStack> list = new ArrayList<>();
	        item.getSubItems(item, null, list);
	        if (list.size() > 0) {
	            for (ItemStack itemStack : list) {
	                String name = item.getUnlocalizedName(itemStack);
	                String itemName = name.substring(name.lastIndexOf(".") + 1, name.length());
	                Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, itemStack.getItemDamage(), new ModelResourceLocation(ModInfo.ASSETS_PREFIX + itemName, "inventory"));
	                ModelLoader.setCustomModelResourceLocation(item, itemStack.getItemDamage(), new ModelResourceLocation(ModInfo.ASSETS_PREFIX + itemName, "inventory"));
	                if (ConfigHandler.debug && createJSONFile)
	                    createJSONForItem(item, itemStack.getItemDamage(), itemName);
	            }
	        } else {
	            String name = item.getUnlocalizedName();
	            String itemName = name.substring(name.lastIndexOf(".") + 1, name.length());
	            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ModInfo.ASSETS_PREFIX + itemName, "inventory"));
	            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(ModInfo.ASSETS_PREFIX + itemName, "inventory"));
	            if (ConfigHandler.debug && createJSONFile)
	                createJSONForItem(item, 0, itemName);
	        }
	    }


	    private void createJSONForItem(Item item, int meta, String itemName) {
	        String location;
	        if (item instanceof ICustomResourceLocationItem)
	            location = ((ICustomResourceLocationItem) item).getCustomResourceLocation(meta);
	        else
	            location = itemName;
	        String path = "models/item/" + itemName + ".json";

	        String renderType;
	        if (item instanceof ICustomItemRenderType)
	            renderType = ((ICustomItemRenderType) item).getCustomRenderType(meta);
	        else
	            renderType = "item/generated";
	        File file = new File(path);
	        try {
	            if (file.createNewFile()) {
	                PrintWriter writer = new PrintWriter(file);
	                writer.println("{");
	                writer.println("  \"parent\": \"" + renderType + "\",\n" +
	                        "   \"textures\": {\n" +
	                        "     \"layer0\": \"thebetweenlands:items/" + location + "\"\n" +
	                        "   }");
	                writer.println("}");
	                writer.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
*/
	    private void createJSONForBlock(String blockName) {
	        String path = "models/block/" + blockName + ".json";

	        String renderType = "block/cube_all";
	        File file = new File(path);
	        try {
	            if (file.createNewFile()) {
	                PrintWriter writer = new PrintWriter(file);
	                writer.println("{");
	                writer.println("  \"parent\": \"" + renderType + "\",\n" +
	                        "   \"textures\": {\n" +
	                        "     \"all\": \"erebus:blocks/" + blockName + "\"\n" +
	                        "   }");
	                writer.println("}");
	                writer.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        path = "models/item/" + blockName + ".json";

	        renderType = "erebus:block/" + blockName;
	        file = new File(path);
	        try {
	            if (file.createNewFile()) {
	                PrintWriter writer = new PrintWriter(file);
	                writer.println("{");
	                writer.println("  \"parent\": \"" + renderType);
	                writer.println("}");
	                writer.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }


	@Override
	public World getClientWorld() {
		return Minecraft.getMinecraft().theWorld;
	}

	@Override
	public EntityPlayer getClientPlayer() {
		return Minecraft.getMinecraft().thePlayer;
	}
}