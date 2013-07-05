package aggurai.throwcraft.entity.eggs;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityVillagerEgg extends EntityThrowable
{
	public EntityVillagerEgg(World par1World)
	{
		super(par1World);

	}

	public EntityVillagerEgg(World par1World, EntityLivingBase par2EntityLiving, int itemDamage)
	{
		super(par1World, par2EntityLiving);
		this.villagerType = itemDamage;
	}

	public EntityVillagerEgg(World par1World, double par2, double par4, double par6, int itemDamage)
	{
		super(par1World, par2, par4, par6);
		this.villagerType = itemDamage;
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
	{
		if (par1MovingObjectPosition.entityHit != null)
			par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0);

		if (!this.worldObj.isRemote)
			impactAction();

		for (int j = 0; j < 8; ++j)
			this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);

		if (!this.worldObj.isRemote)
			this.setDead();
	}

	protected void impactAction()
	{
		EntityVillager spawnedentity = new EntityVillager(this.worldObj);
		spawnedentity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
		switch (villagerType)
		{
			case 25:
				spawnedentity.setProfession(4);
				break;// butcher
			case 26:
				spawnedentity.setProfession(5);
				break; // green guy
			case 27:
				spawnedentity.setProfession(2);
				break; // priest
			case 28:
				spawnedentity.setProfession(1);
				break; // librarian
			case 29:
				spawnedentity.setProfession(3);
				break; // blacksmith
			default:
				spawnedentity.setProfession(0);
				break; // farmer
		}
		this.worldObj.spawnEntityInWorld(spawnedentity);
	}

	int villagerType;
}
