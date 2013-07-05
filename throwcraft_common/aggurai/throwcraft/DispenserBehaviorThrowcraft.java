package aggurai.throwcraft;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import aggurai.throwcraft.entity.bombs.EntityFireBomb;
import aggurai.throwcraft.entity.bombs.EntityLavaBomb;
import aggurai.throwcraft.entity.bombs.EntityLightningBomb;
import aggurai.throwcraft.entity.bombs.EntityMushroomRedBomb;
import aggurai.throwcraft.entity.bombs.EntityTNTBomb;
import aggurai.throwcraft.entity.bombs.EntityWaterBomb;
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

final class DispenserBehaviorThrowcraft extends BehaviorDefaultDispenseItem
{

	@Override
	public ItemStack dispenseStack(IBlockSource par1IBlockSource, ItemStack par2ItemStack)
	{
		EnumFacing enumfacing = BlockDispenser.getFacing(par1IBlockSource.getBlockMetadata());
		World world = par1IBlockSource.getWorld();
		double d0 = par1IBlockSource.getX() + enumfacing.getFrontOffsetX();
		double d1 = par1IBlockSource.getYInt() + 0.2F;
		double d2 = par1IBlockSource.getZ() + enumfacing.getFrontOffsetZ();
		EntityThrowable spawnedentity;
		int meta = par2ItemStack.getItemDamage();
		int itemId = par2ItemStack.itemID;

		if (itemId == ThrowCraft.baseEgg.itemID)
			switch (meta)
			{
				case 0:
					spawnedentity = new EntityBlazeEgg(world, d0, d1, d2);
					break;
				case 1:
					spawnedentity = new EntityCaveSpiderEgg(world, d0, d1, d2);
					break;
				case 2:
					spawnedentity = new EntityChickenEgg(world, d0, d1, d2);
					break;
				case 3:
					spawnedentity = new EntityCowEgg(world, d0, d1, d2);
					break;
				case 4:
					spawnedentity = new EntityCreeperEgg(world, d0, d1, d2);
					break;
				case 5:
					spawnedentity = new EntityEnderDragonEgg(world, d0, d1, d2);
					break;
				case 6:
					spawnedentity = new EntityEndermanEgg(world, d0, d1, d2);
					break;
				case 7:
					spawnedentity = new EntityGhastEgg(world, d0, d1, d2);
					break;
				case 8:
					spawnedentity = new EntityIronGolemEgg(world, d0, d1, d2);
					break;
				case 9:
				case 32:
				case 33:
					spawnedentity = new EntityMagmaCubeEgg(world, d0, d1, d2, meta);
					break;
				case 10:
					spawnedentity = new EntityMooshroomEgg(world, d0, d1, d2);
					break;
				case 11:
					spawnedentity = new EntityPigEgg(world, d0, d1, d2);
					break;
				case 12:
					spawnedentity = new EntitySheepEgg(world, d0, d1, d2);
					break;
				case 13:
					spawnedentity = new EntitySkeletonEgg(world, d0, d1, d2);
					break;
				case 14:
				case 30:
				case 31:
					spawnedentity = new EntitySlimeEgg(world, d0, d1, d2, meta);
					break;
				case 15:
					spawnedentity = new EntitySnowGolemEgg(world, d0, d1, d2);
					break;
				case 16:
					spawnedentity = new EntitySpiderEgg(world, d0, d1, d2);
					break;
				case 17:
					spawnedentity = new EntitySquidEgg(world, d0, d1, d2);
					break;
				case 18:
				case 25:
				case 26:
				case 27:
				case 28:
				case 29:
					spawnedentity = new EntityVillagerEgg(world, d0, d1, d2, meta);
					break;
				case 19:
					spawnedentity = new EntityWolfEgg(world, d0, d1, d2);
					break;
				case 20:
					spawnedentity = new EntityZombieEgg(world, d0, d1, d2);
					break;
				case 21:
					spawnedentity = new EntityZombiePigmanEgg(world, d0, d1, d2);
					break;
				case 22:
					spawnedentity = new EntityWitchEgg(world, d0, d1, d2);
					break;
				case 23:
					spawnedentity = new EntityWitherEgg(world, d0, d1, d2);
					break;
				case 24:
					spawnedentity = new EntityWitherSkeletonEgg(world, d0, d1, d2);
					break;
				case 34:
					spawnedentity = new EntityHorseEgg(world, d0, d1, d2);
					break;
				default:
					spawnedentity = new EntityEgg(world, d0, d1, d2);
					break;
			}
		else
			switch (meta)
			{
				case 0:
				case 5:
				case 6:
					spawnedentity = new EntityWaterBomb(world, d0, d1, d2, meta);
					break;
				case 1:
				case 7:
				case 8:
					spawnedentity = new EntityLavaBomb(world, d0, d1, d2, meta);
					break;
				case 2:
					spawnedentity = new EntityFireBomb(world, d0, d1, d2);
					break;
				case 3:
					spawnedentity = new EntityTNTBomb(world, d0, d1, d2);
					break;
				case 4:
					spawnedentity = new EntityMushroomRedBomb(world, d0, d1, d2);
					break;
				case 9:
					spawnedentity = new EntityLightningBomb(world, d0, d1, d2);
					break;
				default:
					spawnedentity = new EntityEgg(world, d0, d1, d2);
					break;
			}

		spawnedentity.setThrowableHeading(enumfacing.getFrontOffsetX(), enumfacing.getFrontOffsetY() + 0.1F, enumfacing.getFrontOffsetZ(),
				this.func_82500_b(), this.func_82498_a());
		world.spawnEntityInWorld(spawnedentity);

		par2ItemStack.splitStack(1);
		return par2ItemStack;
	}

	protected float func_82498_a()
	{
		return 6.0F;
	}

	protected float func_82500_b()
	{
		return 1.1F;
	}

}
