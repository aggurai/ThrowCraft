package aggurai.throwcraft;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import aggurai.throwcraft.entity.bombs.*;
import aggurai.throwcraft.entity.eggs.*;
import aggurai.throwcraft.item.BaseBomb;
import aggurai.throwcraft.item.BaseEgg;
import aggurai.throwcraft.proxy.TCCommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "ThrowCraft", name = "ThrowCraft Reloaded", version = "1.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ThrowCraft
{

	// The instance of the mod that forge uses
	@Instance("ThrowCraft")
	public static ThrowCraft instance;

	// Client and server proxy location
	@SidedProxy(clientSide = "aggurai.throwcraft.proxy.TCClientProxy", serverSide = "aggurai.throwcraft.proxy.TCCommonProxy")
	public static TCCommonProxy proxy;

	// Items
	public static int itemIdEgg;
	public static int itemIdBomb;

	// Creative tab
	public static CreativeTabs tabThrowCraft = new CreativeTabs("ThrowCraft")
	{
		@Override
		public ItemStack getIconItemStack()
		{
			return new ItemStack(baseEgg, 1, 4);
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		// loading config
		config.load();

		itemIdEgg = config.getItem("tcbaseegg", 5800).getInt() - 256;
		itemIdBomb = config.getItem("tcbasebomb", 5801).getInt() - 256;

		eggsEnabled = new boolean[BaseEgg.fileNames.length];
		for (int i = 0; i < BaseEgg.fileNames.length; i++)
			eggsEnabled[i] = config.get("Enabled Eggs", BaseEgg.fileNames[i], true).getBoolean(true);

		bombsEnabled = new boolean[BaseBomb.fileNames.length];
		for (int i = 0; i < BaseBomb.fileNames.length; i++)
			bombsEnabled[i] = config.get("Enabled Bombs", BaseBomb.fileNames[i], true).getBoolean(true);

		eggEntityIds = new int[BaseEgg.fileNames.length];
		for (int i = 0; i < BaseEgg.fileNames.length; i++)
		{
			boolean f;
			switch (i)
			{
			// Which eggs don't have a unique entity id
				case 25:
				case 26:
				case 27:
				case 28:
				case 29:
				case 30:
				case 31:
				case 32:
				case 33:
					f = false;
					break;
				default:
					f = true;
			}
			if (f == true)
				eggEntityIds[i] = config.get("Entity IDs", BaseEgg.fileNames[i], 121 + i).getInt();
		}

		bombEntityIds = new int[BaseBomb.fileNames.length];
		for (int i = 0; i < BaseBomb.fileNames.length; i++)
		{
			boolean f;
			switch (i)
			{
			// Which bombs don't have a unique entity id
				case 5:
				case 6:
				case 7:
				case 8:
					f = false;
					break;
				default:
					f = true;
			}
			if (f == true)
				bombEntityIds[i] = config.get("Entity IDs", BaseBomb.fileNames[i], 180 + i).getInt();
		}

		// saving config
		config.save();

		baseEgg = new BaseEgg();
		baseBomb = new BaseBomb();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event)
	{

		proxy.registerRenderers();

		// Item names
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 0), "Blaze Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 1), "Cave Spider Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 2), "Chicken Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 3), "Cow Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 4), "Creeper Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 5), "Ender Dragon Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 6), "Enderman Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 7), "Ghast Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 8), "Iron Golem Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 9), "Magma Cube Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 10), "Mooshroom Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 11), "Pig Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 12), "Sheep Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 13), "Skeleton Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 14), "Slime Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 15), "Snow Golem Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 16), "Spider Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 17), "Squid Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 18), "Villager Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 19), "Wolf Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 20), "Zombie Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 21), "Zombie Pigman Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 22), "Witch Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 23), "Wither Boss Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 24), "Wither Skeleton Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 25), "Villager Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 26), "Villager Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 27), "Villager Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 28), "Villager Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 29), "Villager Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 30), "Slime Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 31), "Slime Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 32), "Magma Cube Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 33), "Magma Cube Egg");
		LanguageRegistry.addName(new ItemStack(baseEgg, 1, 34), "Horse Egg");

		LanguageRegistry.addName(new ItemStack(baseBomb, 1, 0), "Water Bomb");
		LanguageRegistry.addName(new ItemStack(baseBomb, 1, 1), "Lava Bomb");
		LanguageRegistry.addName(new ItemStack(baseBomb, 1, 2), "Fire Bomb");
		LanguageRegistry.addName(new ItemStack(baseBomb, 1, 3), "TNT Bomb");
		LanguageRegistry.addName(new ItemStack(baseBomb, 1, 4), "Mushroom Bomb (WIP)");
		LanguageRegistry.addName(new ItemStack(baseBomb, 1, 5), "Water Bomb");
		LanguageRegistry.addName(new ItemStack(baseBomb, 1, 6), "Water Bomb");
		LanguageRegistry.addName(new ItemStack(baseBomb, 1, 7), "Lava Bomb");
		LanguageRegistry.addName(new ItemStack(baseBomb, 1, 8), "Lava Bomb");
		LanguageRegistry.addName(new ItemStack(baseBomb, 1, 9), "Lightning Bomb");

		// Entity
		EntityRegistry.registerModEntity(EntityBlazeEgg.class, "BlazeEgg", eggEntityIds[0], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityCaveSpiderEgg.class, "CaveSpiderEgg", eggEntityIds[1], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityChickenEgg.class, "ChickenEgg", eggEntityIds[2], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityCowEgg.class, "CowEgg", eggEntityIds[3], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityCreeperEgg.class, "CreeperEgg", eggEntityIds[4], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityEnderDragonEgg.class, "EnderDragonrEgg", eggEntityIds[5], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityEndermanEgg.class, "EndermanEgg", eggEntityIds[6], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityGhastEgg.class, "GhastEgg", eggEntityIds[7], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityIronGolemEgg.class, "IronGolemEgg", eggEntityIds[8], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityMagmaCubeEgg.class, "MagmaCubeEgg", eggEntityIds[9], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityMooshroomEgg.class, "MooshroomEgg", eggEntityIds[10], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityPigEgg.class, "PigEgg", eggEntityIds[11], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntitySheepEgg.class, "SheepEgg", eggEntityIds[12], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntitySkeletonEgg.class, "SkeletonEgg", eggEntityIds[13], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntitySlimeEgg.class, "SlimeEgg", eggEntityIds[14], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntitySnowGolemEgg.class, "SnowGolemEgg", eggEntityIds[15], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntitySpiderEgg.class, "SpiderEgg", eggEntityIds[16], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntitySquidEgg.class, "SquidEgg", eggEntityIds[17], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityVillagerEgg.class, "VillagerEgg", eggEntityIds[18], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityWolfEgg.class, "WolfEgg", eggEntityIds[19], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityZombieEgg.class, "ZombieEgg", eggEntityIds[20], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityZombiePigmanEgg.class, "ZombiePigmanEgg", eggEntityIds[21], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityWitchEgg.class, "WitchEgg", eggEntityIds[22], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityWitherEgg.class, "WitherEgg", eggEntityIds[23], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityWitherSkeletonEgg.class, "WitherSkeletonEgg", eggEntityIds[24], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityHorseEgg.class, "HorseEgg", eggEntityIds[25], this, 40, 3, true);

		EntityRegistry.registerModEntity(EntityWaterBomb.class, "WaterBomb", bombEntityIds[0], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityLavaBomb.class, "LavaBomb", bombEntityIds[1], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityFireBomb.class, "FireBomb", bombEntityIds[2], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityTNTBomb.class, "TNTBomb", bombEntityIds[3], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityMushroomRedBomb.class, "MushRedBomb", bombEntityIds[4], this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityLightningBomb.class, "LightningBomb", bombEntityIds[9], this, 40, 3, true);

		// Recipes
		if (eggsEnabled[0])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 0), new Object[] { "XOX", 'X', Item.blazeRod, 'O', Item.egg });
		if (eggsEnabled[1])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 1), new Object[] { "XOX", 'X', Item.fermentedSpiderEye, 'O', Item.egg });
		if (eggsEnabled[2])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 2), new Object[] { "XOX", 'X', Item.chickenCooked, 'O', Item.egg });
		if (eggsEnabled[3])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 3), new Object[] { "XOX", 'X', Item.beefCooked, 'O', Item.egg });
		if (eggsEnabled[4])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 4), new Object[] { "XOX", 'X', Item.gunpowder, 'O', Item.egg });
		if (eggsEnabled[5])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 5), new Object[] { "XOY", 'X', Block.dragonEgg, 'O', Item.egg, 'Y', Item.eyeOfEnder });
		if (eggsEnabled[6])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 6), new Object[] { "XOX", 'X', Item.enderPearl, 'O', Item.egg });
		if (eggsEnabled[7])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 7), new Object[] { "XOX", 'X', Item.ghastTear, 'O', Item.egg });
		if (eggsEnabled[8])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 8), new Object[] { "XOX", 'X', Block.blockIron, 'O', Item.egg });
		if (eggsEnabled[9])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 9), new Object[] { "XOX", 'X', Item.magmaCream, 'O', Item.egg });
		if (eggsEnabled[10])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 10), new Object[] { "XOY", 'X', Block.mushroomRed, 'O', Item.egg, 'Y',
					new ItemStack(baseEgg, 1, 3) });
		if (eggsEnabled[11])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 11), new Object[] { "XOX", 'X', Item.porkCooked, 'O', Item.egg });
		if (eggsEnabled[12])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 12), new Object[] { "XOX", 'X', Block.cloth, 'O', Item.egg });
		if (eggsEnabled[13])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 13), new Object[] { "XOX", 'X', Item.bone, 'O', Item.egg });
		if (eggsEnabled[14])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 14), new Object[] { "XOX", 'X', Item.slimeBall, 'O', Item.egg });
		if (eggsEnabled[15])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 15), new Object[] { "XOY", 'X', Block.blockSnow, 'O', Item.egg, 'Y', Block.pumpkin });
		if (eggsEnabled[16])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 16), new Object[] { "XOX", 'X', Item.silk, 'O', Item.egg });
		if (eggsEnabled[17])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 17), new Object[] { "XOX", 'X', new ItemStack(Item.dyePowder, 1, 0), 'O', Item.egg });
		if (eggsEnabled[18])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 18), new Object[] { "XOX", 'X', Item.emerald, 'O', Item.egg });
		if (eggsEnabled[19])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 19), new Object[] { "XOY", 'X', Item.bone, 'O', Item.egg, 'Y', Item.rottenFlesh });
		if (eggsEnabled[20])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 20), new Object[] { "XOX", 'X', Item.rottenFlesh, 'O', Item.egg });
		if (eggsEnabled[21])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 21), new Object[] { "XOX", 'X', Item.goldNugget, 'O', Item.egg });
		if (eggsEnabled[22])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 22), new Object[] { "XOY", 'X', Item.glassBottle, 'O', Item.egg, 'Y', Item.redstone });
		if (eggsEnabled[23])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 23), new Object[] { "XOX", 'X', new ItemStack(Item.skull, 1, 1), 'O', Item.egg });
		if (eggsEnabled[24])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 24), new Object[] { "XOY", 'X', Item.bone, 'O', Item.egg, 'Y', Item.coal });
		if (eggsEnabled[25])
			GameRegistry.addShapelessRecipe(new ItemStack(baseEgg, 1, 25), new Object[] { new ItemStack(baseEgg, 1, 18), Item.beefRaw });
		if (eggsEnabled[25])
			GameRegistry.addShapelessRecipe(new ItemStack(baseEgg, 1, 25), new Object[] { new ItemStack(baseEgg, 1, 18), Item.porkRaw });
		if (eggsEnabled[26])
			GameRegistry.addShapelessRecipe(new ItemStack(baseEgg, 1, 26), new Object[] { new ItemStack(baseEgg, 1, 18),
					new ItemStack(Item.dyePowder, 1, 2) });
		if (eggsEnabled[27])
			GameRegistry.addShapelessRecipe(new ItemStack(baseEgg, 1, 27), new Object[] { new ItemStack(baseEgg, 1, 18),
					new ItemStack(Item.dyePowder, 1, 5) });
		if (eggsEnabled[28])
			GameRegistry.addShapelessRecipe(new ItemStack(baseEgg, 1, 28), new Object[] { new ItemStack(baseEgg, 1, 18), Item.book });
		if (eggsEnabled[29])
			GameRegistry.addShapelessRecipe(new ItemStack(baseEgg, 1, 29), new Object[] { new ItemStack(baseEgg, 1, 18), Item.ingotIron });
		if (eggsEnabled[30])
			GameRegistry.addShapelessRecipe(new ItemStack(baseEgg, 1, 30), new Object[] { new ItemStack(baseEgg, 1, 14),
					new ItemStack(baseEgg, 1, 14) });
		if (eggsEnabled[31])
			GameRegistry.addShapelessRecipe(new ItemStack(baseEgg, 1, 31), new Object[] { new ItemStack(baseEgg, 1, 30),
					new ItemStack(baseEgg, 1, 30) });
		if (eggsEnabled[32])
			GameRegistry.addShapelessRecipe(new ItemStack(baseEgg, 1, 32),
					new Object[] { new ItemStack(baseEgg, 1, 9), new ItemStack(baseEgg, 1, 9) });
		if (eggsEnabled[33])
			GameRegistry.addShapelessRecipe(new ItemStack(baseEgg, 1, 33), new Object[] { new ItemStack(baseEgg, 1, 32),
					new ItemStack(baseEgg, 1, 32) });
		if (eggsEnabled[34])
			GameRegistry.addRecipe(new ItemStack(baseEgg, 1, 34), new Object[] { "XOX", 'X', Block.field_111038_cB, 'O', Item.egg });

		if (bombsEnabled[0])
			GameRegistry.addRecipe(new ItemStack(baseBomb, 1, 0), new Object[] { "XOX", 'X', Item.bucketWater, 'O', Item.egg });
		if (bombsEnabled[1])
			GameRegistry.addRecipe(new ItemStack(baseBomb, 1, 1), new Object[] { "XOX", 'X', Item.bucketLava, 'O', Item.egg });
		if (bombsEnabled[2])
			GameRegistry.addRecipe(new ItemStack(baseBomb, 1, 2),
					new Object[] { "XOY", 'X', Block.netherrack, 'O', Item.egg, 'Y', Item.flintAndSteel });
		if (bombsEnabled[3])
			GameRegistry.addRecipe(new ItemStack(baseBomb, 1, 3), new Object[] { "XOX", 'X', Block.tnt, 'O', Item.egg });
		if (bombsEnabled[4])
			GameRegistry.addRecipe(new ItemStack(baseBomb, 1, 4), new Object[] { "XOY", 'X', Block.mushroomRed, 'O', Item.egg, 'Y',
					new ItemStack(Item.dyePowder, 1, 15) });
		if (bombsEnabled[5])
			GameRegistry.addShapelessRecipe(new ItemStack(baseBomb, 1, 5), new Object[] { new ItemStack(baseBomb, 1, 0),
					new ItemStack(baseBomb, 1, 0) });
		if (bombsEnabled[6])
			GameRegistry.addShapelessRecipe(new ItemStack(baseBomb, 1, 6), new Object[] { new ItemStack(baseBomb, 1, 5),
					new ItemStack(baseBomb, 1, 5) });
		if (bombsEnabled[7])
			GameRegistry.addShapelessRecipe(new ItemStack(baseBomb, 1, 7), new Object[] { new ItemStack(baseBomb, 1, 1),
					new ItemStack(baseBomb, 1, 1) });
		if (bombsEnabled[8])
			GameRegistry.addShapelessRecipe(new ItemStack(baseBomb, 1, 8), new Object[] { new ItemStack(baseBomb, 1, 7),
					new ItemStack(baseBomb, 1, 7) });
		if (bombsEnabled[9])
			GameRegistry.addRecipe(new ItemStack(baseBomb, 1, 9), new Object[] { "XOY", 'X', Block.tnt, 'O', Item.egg, 'Y', Item.flintAndSteel });

		// Dispenser
		ModLoader.addDispenserBehavior(baseEgg, new DispenserBehaviorThrowcraft());
		ModLoader.addDispenserBehavior(baseBomb, new DispenserBehaviorThrowcraft());

		// Furnace
		FurnaceRecipes.smelting().addSmelting(itemIdEgg + 256, new ItemStack(Item.egg), 0.0F);
		FurnaceRecipes.smelting().addSmelting(itemIdBomb + 256, new ItemStack(Item.egg), 0.0F);
		FurnaceRecipes.smelting().addSmelting(itemIdEgg + 256, 30, new ItemStack(Item.egg, 2), 0.0F);
		FurnaceRecipes.smelting().addSmelting(itemIdEgg + 256, 31, new ItemStack(Item.egg, 4), 0.0F);
		FurnaceRecipes.smelting().addSmelting(itemIdEgg + 256, 32, new ItemStack(Item.egg, 2), 0.0F);
		FurnaceRecipes.smelting().addSmelting(itemIdEgg + 256, 33, new ItemStack(Item.egg, 4), 0.0F);
		FurnaceRecipes.smelting().addSmelting(itemIdBomb + 256, 5, new ItemStack(Item.egg, 2), 0.0F);
		FurnaceRecipes.smelting().addSmelting(itemIdBomb + 256, 6, new ItemStack(Item.egg, 4), 0.0F);
		FurnaceRecipes.smelting().addSmelting(itemIdBomb + 256, 7, new ItemStack(Item.egg, 2), 0.0F);
		FurnaceRecipes.smelting().addSmelting(itemIdBomb + 256, 8, new ItemStack(Item.egg, 4), 0.0F);

		// Creative tab
		LanguageRegistry.instance().addStringLocalization("itemGroup.ThrowCraft", "en_US", "ThrowCraft Eggs&Bombs");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}

	public static Item baseEgg;
	public static Item baseBomb;
	boolean[] eggsEnabled;
	boolean[] bombsEnabled;
	int[] eggEntityIds;
	int[] bombEntityIds;
}
