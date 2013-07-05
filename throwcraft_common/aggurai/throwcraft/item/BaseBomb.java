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
import aggurai.throwcraft.entity.bombs.EntityFireBomb;
import aggurai.throwcraft.entity.bombs.EntityLavaBomb;
import aggurai.throwcraft.entity.bombs.EntityLightningBomb;
import aggurai.throwcraft.entity.bombs.EntityMushroomRedBomb;
import aggurai.throwcraft.entity.bombs.EntityTNTBomb;
import aggurai.throwcraft.entity.bombs.EntityWaterBomb;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaseBomb extends Item
{

	public static final String[] fileNames = new String[] { "water_small", "lava_small", "fire", "tnt", "mushroomred", "water_medium", "water_large",
			"lava_medium", "lava_large", "lightning" };

	@SideOnly(Side.CLIENT)
	private Icon[] iconList;

	public BaseBomb()
	{
		super(ThrowCraft.itemIdBomb);
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
			case 0:
				par3List.add("Small");
				break;
			case 5:
				par3List.add("Medium");
				break;
			case 6:
				par3List.add("Large");
				break;
			case 1:
				par3List.add("Small");
				break;
			case 7:
				par3List.add("Medium");
				break;
			case 8:
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
			int itemDamage = par1ItemStack.getItemDamage();
			switch (itemDamage)
			{
				case 0:
				case 5:
				case 6:
					par2World.spawnEntityInWorld(new EntityWaterBomb(par2World, par3EntityPlayer, itemDamage));
					break;
				case 1:
				case 7:
				case 8:
					par2World.spawnEntityInWorld(new EntityLavaBomb(par2World, par3EntityPlayer, itemDamage));
					break;
				case 2:
					par2World.spawnEntityInWorld(new EntityFireBomb(par2World, par3EntityPlayer));
					break;
				case 3:
					par2World.spawnEntityInWorld(new EntityTNTBomb(par2World, par3EntityPlayer));
					break;
				case 4:
					par2World.spawnEntityInWorld(new EntityMushroomRedBomb(par2World, par3EntityPlayer));
					break;
				case 9:
					par2World.spawnEntityInWorld(new EntityLightningBomb(par2World, par3EntityPlayer));
					break;
				default:
					break;
			}

		}

		return par1ItemStack;
	}
}
