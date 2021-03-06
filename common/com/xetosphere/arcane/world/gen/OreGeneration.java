package com.xetosphere.arcane.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.xetosphere.arcane.block.ModBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class OreGeneration implements IWorldGenerator {

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		switch (world.provider.dimensionId) {

			case -1:
				generateNether(world, random, chunkX * 16, chunkZ * 16);
			case 0:
				genereateSurface(world, random, chunkX * 16, chunkZ * 16);
			case 1:
				generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}

	}

	private void generateNether(World world, Random random, int x, int z) {

	}

	private void genereateSurface(World world, Random random, int x, int z) {

		if (world.getBiomeGenForCoords(x, z) == BiomeGenBase.forest) {
			addOreSpawn(ModBlocks.magicPowderOres, 0, Block.stone, world, random, x, z, 16, 16, 4 + random.nextInt(3), 14, 0, 60);
		} else if (world.getBiomeGenForCoords(x, z) != BiomeGenBase.forest) {
			addOreSpawn(ModBlocks.magicPowderOres, 0, Block.stone, world, random, x, z, 16, 16, 2 + random.nextInt(2), 6, 0, 60);
		}

		if (world.getBiomeGenForCoords(x, z) == BiomeGenBase.desert) {
			addOreSpawn(ModBlocks.magicPowderOres, 1, Block.stone, world, random, x, z, 16, 16, 4 + random.nextInt(3), 14, 0, 60);
		} else if (world.getBiomeGenForCoords(x, z) != BiomeGenBase.desert) {
			addOreSpawn(ModBlocks.magicPowderOres, 1, Block.stone, world, random, x, z, 16, 16, 2 + random.nextInt(2), 6, 0, 60);
		}

		if (world.getBiomeGenForCoords(x, z) == BiomeGenBase.swampland) {
			addOreSpawn(ModBlocks.magicPowderOres, 2, Block.stone, world, random, x, z, 16, 16, 4 + random.nextInt(3), 14, 0, 60);
		} else if (world.getBiomeGenForCoords(x, z) != BiomeGenBase.swampland) {
			addOreSpawn(ModBlocks.magicPowderOres, 2, Block.stone, world, random, x, z, 16, 16, 2 + random.nextInt(2), 6, 0, 60);
		}
	}

	private void generateEnd(World world, Random random, int x, int z) {

	}

	public void addOreSpawn(Block block, int meta, Block blockBeingReplaced, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {

		assert maxY > minY : "addOreSpawn: The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

		int differenceInY = maxY - minY;

		for (int i = 0; i < chanceToSpawn; ++i) {

			int xPos = blockXPos + random.nextInt(maxX);
			int yPos = minY + random.nextInt(differenceInY);
			int zPos = blockZPos + random.nextInt(maxZ);

			(new WorldGenMinable(block.blockID, meta, maxVeinSize, blockBeingReplaced.blockID)).generate(world, random, xPos, yPos, zPos);
		}
	}

}
