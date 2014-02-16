package erebus.world;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import erebus.ModBiomes;
import erebus.core.handler.ConfigHandler;

public class WorldProviderErebus extends WorldProvider {

	@SideOnly(Side.CLIENT)
	private double[] currentFogColor, targetFogColor;

	@Override
	public boolean canRespawnHere() {
		return false;
	}

	@Override
	public boolean canCoordinateBeSpawn(int x, int z) {
		return true;
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTickTime) {
		return 0.5F;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Vec3 getFogColor(float celestialAngle, float partialTickTime) {
		BiomeGenBase b = worldObj.getBiomeGenForCoords((int) Minecraft.getMinecraft().thePlayer.posX, (int) Minecraft.getMinecraft().thePlayer.posZ);

		if (targetFogColor == null)
			targetFogColor = new double[3];
		targetFogColor[0] = 0.03D * 255D;
		targetFogColor[1] = 0.5D * 255D;
		targetFogColor[2] = 0.03D * 255D;

		if (b == ModBiomes.subterraneanSavannah) {
			targetFogColor[0] = 140D;
			targetFogColor[1] = 116D;
			targetFogColor[2] = 9D;
		} else if (b == ModBiomes.volcanicDesert) {
			targetFogColor[0] = 255D;
			targetFogColor[1] = 231D;
			targetFogColor[2] = 10D;
		}

		if (currentFogColor == null) {
			currentFogColor = new double[3];
			for (int a = 0; a < 3; a++)
				currentFogColor[a] = targetFogColor[a];
		}

		for (int a = 0; a < 3; a++)
			if (currentFogColor[a] != targetFogColor[a])
				if (currentFogColor[a] < targetFogColor[a]) {
					currentFogColor[a] += 2D;
					if (currentFogColor[a] > targetFogColor[a])
						currentFogColor[a] = targetFogColor[a];
				} else if (currentFogColor[a] > targetFogColor[a]) {
					currentFogColor[a] -= 2D;
					if (currentFogColor[a] < targetFogColor[a])
						currentFogColor[a] = targetFogColor[a];
				}

		return worldObj.getWorldVec3Pool().getVecFromPool(currentFogColor[0] / 255D, currentFogColor[1] / 255D, currentFogColor[2] / 255D);
	}

	@Override
	protected void generateLightBrightnessTable() {
		float f = 0.1F;

		for (int i = 0; i <= 15; i++) {
			float f1 = 1F - i / 15F;
			lightBrightnessTable[i] = (1F - f1) / (f1 * 3F + 1F) * (1F - f) + f;
		}
	}

	@Override
	public void registerWorldChunkManager() {
		worldChunkMgr = new WorldChunkManagerErebus(worldObj);
		hasNoSky = true;
		dimensionId = ConfigHandler.erebusDimensionID;
	}

	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderErebus(worldObj, worldObj.getSeed());
	}

	@Override
	public boolean isSurfaceWorld() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int x, int z) {
		return false;
	}

	@Override
	public String getDimensionName() {
		return "Erebus";
	}

	@Override
	public ChunkCoordinates getRandomizedSpawnPoint() {
		ChunkCoordinates chunkcoordinates = new ChunkCoordinates(worldObj.getSpawnPoint());

		boolean isAdventure = worldObj.getWorldInfo().getGameType() == EnumGameType.ADVENTURE;
		int spawnFuzz = 100;
		int spawnFuzzHalf = spawnFuzz / 2;

		if (!hasNoSky && !isAdventure) {
			chunkcoordinates.posX += worldObj.rand.nextInt(spawnFuzz) - spawnFuzzHalf;
			chunkcoordinates.posZ += worldObj.rand.nextInt(spawnFuzz) - spawnFuzzHalf;
			chunkcoordinates.posY = worldObj.getTopSolidOrLiquidBlock(chunkcoordinates.posX, chunkcoordinates.posZ);
		}

		return chunkcoordinates;
	}
}