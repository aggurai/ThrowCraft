package aggurai.throwcraft.entity.eggs;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityHorseEgg extends EntityThrowable
{
	public EntityHorseEgg(World par1World)
	{
		super(par1World);

	}

	public EntityHorseEgg(World par1World, EntityLivingBase par2EntityLiving)
	{
		super(par1World, par2EntityLiving);
	}

	public EntityHorseEgg(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
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
		EntityHorse spawnedentity = new EntityHorse(this.worldObj);
		spawnedentity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
		spawnedentity.func_110161_a((EntityLivingData) null);
		this.worldObj.spawnEntityInWorld(spawnedentity);
	}
}
