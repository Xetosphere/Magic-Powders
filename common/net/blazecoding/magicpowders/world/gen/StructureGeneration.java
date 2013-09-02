package net.blazecoding.magicpowders.world.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * 
 * Magic Powders
 * 
 * StructureGeneration
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class StructureGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		switch (world.provider.dimensionId) {

			case -1:
				generateNether(world, random, chunkX * 16, chunkZ * 16);
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
			case 1:
				generateEnd(world, random, chunkX * 16, chunkZ * 16);

		}

	}

	public static void generateNether(World world, Random random, int x, int z) {

	}

	public static void generateSurface(World world, Random random, int x, int z) {

		for (int i = 0; i < 3; ++i) {

			int xCoord = x + random.nextInt(16);
			int yCoord = random.nextInt(80);
			int zCoord = z + random.nextInt(16);

			(new WorldGenApprenticeHouse()).generate(world, random, xCoord, yCoord, zCoord);

		}

	}

	public static void generateEnd(World world, Random random, int x, int z) {

	}

}
