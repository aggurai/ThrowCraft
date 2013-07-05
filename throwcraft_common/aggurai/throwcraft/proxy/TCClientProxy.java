package aggurai.throwcraft.proxy;

import net.minecraft.client.renderer.entity.RenderSnowball;
import aggurai.throwcraft.ThrowCraft;
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
import cpw.mods.fml.client.registry.RenderingRegistry;

public class TCClientProxy extends TCCommonProxy
{

	@Override
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityBlazeEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityCaveSpiderEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 1));
		RenderingRegistry.registerEntityRenderingHandler(EntityChickenEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 2));
		RenderingRegistry.registerEntityRenderingHandler(EntityCowEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 3));
		RenderingRegistry.registerEntityRenderingHandler(EntityCreeperEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 4));
		RenderingRegistry.registerEntityRenderingHandler(EntityEnderDragonEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 5));
		RenderingRegistry.registerEntityRenderingHandler(EntityEndermanEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 6));
		RenderingRegistry.registerEntityRenderingHandler(EntityGhastEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 7));
		RenderingRegistry.registerEntityRenderingHandler(EntityIronGolemEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 8));
		RenderingRegistry.registerEntityRenderingHandler(EntityMagmaCubeEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 9));
		RenderingRegistry.registerEntityRenderingHandler(EntityMooshroomEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 10));
		RenderingRegistry.registerEntityRenderingHandler(EntityPigEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 11));
		RenderingRegistry.registerEntityRenderingHandler(EntitySheepEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 12));
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 13));
		RenderingRegistry.registerEntityRenderingHandler(EntitySlimeEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 14));
		RenderingRegistry.registerEntityRenderingHandler(EntitySnowGolemEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 15));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpiderEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 16));
		RenderingRegistry.registerEntityRenderingHandler(EntitySquidEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 17));
		RenderingRegistry.registerEntityRenderingHandler(EntityVillagerEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 18));
		RenderingRegistry.registerEntityRenderingHandler(EntityWolfEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 19));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 20));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombiePigmanEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 21));
		RenderingRegistry.registerEntityRenderingHandler(EntityWitchEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 22));
		RenderingRegistry.registerEntityRenderingHandler(EntityWitherEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 23));
		RenderingRegistry.registerEntityRenderingHandler(EntityWitherSkeletonEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 24));
		RenderingRegistry.registerEntityRenderingHandler(EntityHorseEgg.class, new RenderSnowball(ThrowCraft.baseEgg, 34));

		RenderingRegistry.registerEntityRenderingHandler(EntityWaterBomb.class, new RenderSnowball(ThrowCraft.baseBomb, 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityLavaBomb.class, new RenderSnowball(ThrowCraft.baseBomb, 1));
		RenderingRegistry.registerEntityRenderingHandler(EntityFireBomb.class, new RenderSnowball(ThrowCraft.baseBomb, 2));
		RenderingRegistry.registerEntityRenderingHandler(EntityTNTBomb.class, new RenderSnowball(ThrowCraft.baseBomb, 3));
		RenderingRegistry.registerEntityRenderingHandler(EntityMushroomRedBomb.class, new RenderSnowball(ThrowCraft.baseBomb, 4));
		RenderingRegistry.registerEntityRenderingHandler(EntityLightningBomb.class, new RenderSnowball(ThrowCraft.baseBomb, 9));
	}

}
