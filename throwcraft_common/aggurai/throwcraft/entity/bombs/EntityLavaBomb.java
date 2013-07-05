package aggurai.throwcraft.entity.bombs;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLavaBomb extends EntityThrowable
{
	public EntityLavaBomb(World par1World)
	{
		super(par1World);

	}

	public EntityLavaBomb(World par1World, EntityLivingBase par2EntityLiving, int itemDamage)
	{
		super(par1World, par2EntityLiving);
		this.bombSize = itemDamage;
	}

	public EntityLavaBomb(World par1World, double par2, double par4, double par6, int itemDamage)
	{
		super(par1World, par2, par4, par6);
		this.bombSize = itemDamage;
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
		double d;
		switch (bombSize)
		{
			case 7:
				d = 3;
				break;
			case 8:
				d = 5;
				break;
			default:
				d = 2;
		}
		for (int i = (int) -d - 1; i <= d; i++)
			for (int j = (int) -d - 1; j <= d; j++)
				for (int k = (int) -d - 1; k <= d; k++)
					if (Block.lavaStill.canPlaceBlockAt(worldObj, (int) posX + i, (int) posY + j, (int) posZ + k)
							&& Math.sqrt(Math.pow(i, 2D) + Math.pow(j, 2D) + Math.pow(k, 2D)) <= d)
						worldObj.setBlock((int) posX + i, (int) posY + j, (int) posZ + k, Block.lavaMoving.blockID);
	}

	int bombSize;
}
