package aggurai.throwcraft.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import aggurai.throwcraft.ThrowCraft;
import aggurai.throwcraft.entity.eggs.EntityBlazeEgg;
import aggurai.throwcraft.entity.eggs.EntityCaveSpiderEgg;
import aggurai.throwcraft.entity.eggs.EntityChickenEgg;
import aggurai.throwcraft.entity.eggs.EntityCowEgg;
import aggurai.throwcraft.entity.eggs.EntityCreeperEgg;
import aggurai.throwcraft.entity.eggs.EntityEnderDragonEgg;
import aggurai.throwcraft.entity.eggs.EntityEndermanEgg;
import aggurai.throwcraft.entity.eggs.EntityGhastEgg;
import aggurai.throwcraft.entity.eggs.EntityHorseEgg;
import aggurai.throwcraft.entity.eggs.EntityIronGolemEgg;
import aggurai.throwcraft.entity.eggs.EntityMagmaCubeEgg;
import aggurai.throwcraft.entity.eggs.EntityMooshroomEgg;
import aggurai.throwcraft.entity.eggs.EntityPigEgg;
import aggurai.throwcraft.entity.eggs.EntitySheepEgg;
import aggurai.throwcraft.entity.eggs.EntitySkeletonEgg;
import aggurai.throwcraft.entity.eggs.EntitySlimeEgg;
import aggurai.throwcraft.entity.eggs.EntitySnowGolemEgg;
import aggurai.throwcraft.entity.eggs.EntitySpiderEgg;
import aggurai.throwcraft.entity.eggs.EntitySquidEgg;
import aggurai.throwcraft.entity.eggs.EntityVillagerEgg;
import aggurai.throwcraft.entity.eggs.EntityWitchEgg;
import aggurai.throwcraft.entity.eggs.EntityWitherEgg;
import aggurai.throwcraft.entity.eggs.EntityWitherSkeletonEgg;
import aggurai.throwcraft.entity.eggs.EntityWolfEgg;
import aggurai.throwcraft.entity.eggs.EntityZombieEgg;
import aggurai.throwcraft.entity.eggs.EntityZombiePigmanEgg;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaseEgg extends Item
{

	public static final String[] fileNames = new String[] { "blaze", "cavespider", "chicken", "cow", "creeper", "enderdragon", "enderman", "ghast",
			"irongolem", "magmacube_small", "mooshroom", "pig", "sheep", "skeleton", "slime_small", "snowgolem", "spider", "squid", "villager_brown",
			"wolf", "zombie", "zombiepigman", "witch", "wither", "witherskeleton", "villager_gray", "villager_green", "villager_purple",
			"villager_white", "villager_black", "slime_medium", "slime_large", "magmacube_medium", "magmacube_large", "horse" };

	@SideOnly(Side.CLIENT)
	private Icon[] iconList;

	public BaseEgg()
	{
		super(ThrowCraft.itemIdEgg);
		setMaxStackSize(16);
		setCreativeTab(ThrowCraft.tabThrowCraft);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1)
	{
		return this.iconList[par1];
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		return super.getUnlocalizedName() + "." + "tc" + fileNames[par1ItemStack.getItemDamage()] + "egg";
	}

	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int j = 0; j < fileNames.length; j++)
			par3List.add(new ItemStack(par1, 1, j));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.iconList = new Icon[fileNames.length];
		for (int i = 0; i < fileNames.length; i++)
			this.iconList[i] = iconRegister.registerIcon("throwcraft:" + fileNames[i]);
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		int itemDamage = par1ItemStack.getItemDamage();
		switch (itemDamage)
		{
			case 18:
				par3List.add("Farmer");
				break;
			case 25:
				par3List.add("Butcher");
				break;
			case 26:
				par3List.add("Generic");
				break;
			case 27:
				par3List.add("Priest");
				break;
			case 28:
				par3List.add("Librarian");
				break;
			case 29:
				par3List.add("Blacksmith");
				break;
			case 14:
				par3List.add("Small");
				break;
			case 30:
				par3List.add("Medium");
				break;
			case 31:
				par3List.add("Large");
				break;
			case 9:
				par3List.add("Small");
				break;
			case 32:
				par3List.add("Medium");
				break;
			case 33:
				par3List.add("Large");
				break;
			default:
				break;
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par3EntityPlayer.capabilities.isCreativeMode)
			--par1ItemStack.stackSize;

		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!par2World.isRemote)
		{
			int itemDamage = par3EntityPlayer.inventory.getCurrentItem().getItemDamage();
			switch (itemDamage)
			{
				case 0:
					par2World.spawnEntityInWorld(new EntityBlazeEgg(par2World, par3EntityPlayer));
					break;
				case 1:
					par2World.spawnEntityInWorld(new EntityCaveSpiderEgg(par2World, par3EntityPlayer));
					break;
				case 2:
					par2World.spawnEntityInWorld(new EntityChickenEgg(par2World, par3EntityPlayer));
					break;
				case 3:
					par2World.spawnEntityInWorld(new EntityCowEgg(par2World, par3EntityPlayer));
					break;
				case 4:
					par2World.spawnEntityInWorld(new EntityCreeperEgg(par2World, par3EntityPlayer));
					break;
				case 5:
					par2World.spawnEntityInWorld(new EntityEnderDragonEgg(par2World, par3EntityPlayer));
					break;
				case 6:
					par2World.spawnEntityInWorld(new EntityEndermanEgg(par2World, par3EntityPlayer));
					break;
				case 7:
					par2World.spawnEntityInWorld(new EntityGhastEgg(par2World, par3EntityPlayer));
					break;
				case 8:
					par2World.spawnEntityInWorld(new EntityIronGolemEgg(par2World, par3EntityPlayer));
					break;
				case 9:
				case 32:
				case 33:
					par2World.spawnEntityInWorld(new EntityMagmaCubeEgg(par2World, par3EntityPlayer, itemDamage));
					break;
				case 10:
					par2World.spawnEntityInWorld(new EntityMooshroomEgg(par2World, par3EntityPlayer));
					break;
				case 11:
					par2World.spawnEntityInWorld(new EntityPigEgg(par2World, par3EntityPlayer));
					break;
				case 12:
					par2World.spawnEntityInWorld(new EntitySheepEgg(par2World, par3EntityPlayer));
					break;
				case 13:
					par2World.spawnEntityInWorld(new EntitySkeletonEgg(par2World, par3EntityPlayer));
					break;
				case 14:
				case 30:
				case 31:
					par2World.spawnEntityInWorld(new EntitySlimeEgg(par2World, par3EntityPlayer, itemDamage));
					break;
				case 15:
					par2World.spawnEntityInWorld(new EntitySnowGolemEgg(par2World, par3EntityPlayer));
					break;
				case 16:
					par2World.spawnEntityInWorld(new EntitySpiderEgg(par2World, par3EntityPlayer));
					break;
				case 17:
					par2World.spawnEntityInWorld(new EntitySquidEgg(par2World, par3EntityPlayer));
					break;
				case 18:
				case 25:
				case 26:
				case 27:
				case 28:
				case 29:
					par2World.spawnEntityInWorld(new EntityVillagerEgg(par2World, par3EntityPlayer, itemDamage));
					break;
				case 19:
					par2World.spawnEntityInWorld(new EntityWolfEgg(par2World, par3EntityPlayer));
					break;
				case 20:
					par2World.spawnEntityInWorld(new EntityZombieEgg(par2World, par3EntityPlayer));
					break;
				case 21:
					par2World.spawnEntityInWorld(new EntityZombiePigmanEgg(par2World, par3EntityPlayer));
					break;
				case 22:
					par2World.spawnEntityInWorld(new EntityWitchEgg(par2World, par3EntityPlayer));
					break;
				case 23:
					par2World.spawnEntityInWorld(new EntityWitherEgg(par2World, par3EntityPlayer));
					break;
				case 24:
					par2World.spawnEntityInWorld(new EntityWitherSkeletonEgg(par2World, par3EntityPlayer));
					break;
				case 34:
					par2World.spawnEntityInWorld(new EntityHorseEgg(par2World, par3EntityPlayer));
					break;
				default:
					break;
			}

		}

		return par1ItemStack;
	}
}
