package aggurai.throwcraft.entity.eggs;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMagmaCubeEgg extends EntityThrowable
{
	public EntityMagmaCubeEgg(World par1World)
	{
		super(par1World);

	}

	public EntityMagmaCubeEgg(World par1World, EntityLivingBase par2EntityLiving, int itemDamage)
	{
		super(par1World, par2EntityLiving);
		this.slimeSize = itemDamage;
	}

	public EntityMagmaCubeEgg(World par1World, double par2, double par4, double par6, int itemDamage)
	{
		super(par1World, par2, par4, par6);
		this.slimeSize = itemDamage;
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
		switch (slimeSize)
		{
			case 32:
				spawnSlimeSize(2);
				break;
			case 33:
				spawnSlimeSize(4);
				break;
			default:
				spawnSlimeSize(1);
		}
	}

	private void spawnSlimeSize(int size)
	{
		EntityMagmaCube spawnedentity = new EntityMagmaCube(this.worldObj);
		spawnedentity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
		spawnedentity.getDataWatcher().updateObject(16, new Byte((byte) size));
		float width = 0.6F * size;
		float height = width;
		spawnedentity.boundingBox.maxX = spawnedentity.boundingBox.minX + width;
		spawnedentity.boundingBox.maxZ = spawnedentity.boundingBox.minZ + width;
		spawnedentity.boundingBox.maxY = spawnedentity.boundingBox.minY + height;
		spawnedentity.setPosition(spawnedentity.posX, spawnedentity.posY, spawnedentity.posZ);
		spawnedentity.setEntityHealth(spawnedentity.func_110138_aP());
		spawnedentity.experienceValue = size;
		this.worldObj.spawnEntityInWorld(spawnedentity);
	}

	int slimeSize;
}
