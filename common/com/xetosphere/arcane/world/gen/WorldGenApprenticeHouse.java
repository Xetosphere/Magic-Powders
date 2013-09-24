package com.xetosphere.arcane.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemDoor;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.xetosphere.arcane.block.ModBlocks;

public class WorldGenApprenticeHouse extends WorldGenerator {

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {

		if (world.isAirBlock(x, y + 1, z) && world.getBlockId(x, y, z) == Block.grass.blockID && world.getBlockId(x - 5, y, z + 0) == Block.grass.blockID && world.getBlockId(x - 5, y, z + 7) == Block.grass.blockID && world.getBlockId(x + 5, y, z + 0) == Block.grass.blockID && world.getBlockId(x + 5, y, z + 7) == Block.grass.blockID) {

			int direction = random.nextInt(4);

			// z - 1 == one block north, z + 1 == one block south, x - 1 == one block west, x + 1 == one block east

			if (direction == 2) {

				// Entrance at North

				for (int i = 0; i < 9; ++i) {
					for (int j = 1; j < 5; ++j) {
						for (int k = 0; k < 7; ++k) {
							world.setBlock((x - 4) + i, y + 0, z + k, Block.planks.blockID, 1, 0);
							world.setBlock((x - 4) + i, y + j, z + 6, Block.planks.blockID, 1, 0);
							world.setBlock((x - 4) + 0, y + j, z + k, Block.planks.blockID, 1, 0);
							world.setBlock((x + 4) + 0, y + j, z + k, Block.planks.blockID, 1, 0);
							world.setBlock((x + 4) - i, y + 5, z + k, Block.planks.blockID, 1, 0);
						}
					}
				}

				for (int i = 0; i < 4; ++i) {
					for (int j = 1; j < 5; ++j) {
						world.setBlock((x + 4) - i, y + j, z, Block.planks.blockID, 1, 0);
						world.setBlock((x - 4) + i, y + j, z, Block.planks.blockID, 1, 0);

						world.setBlock(x - 4, y + j, z + 0, Block.wood.blockID, 1, 0);
						world.setBlock(x + 4, y + j, z + 0, Block.wood.blockID, 1, 0);
						world.setBlock(x - 4, y + j, z + 6, Block.wood.blockID, 1, 0);
						world.setBlock(x + 4, y + j, z + 6, Block.wood.blockID, 1, 0);
					}
				}

				world.setBlock(x + 0, y + 3, z + 0, Block.planks.blockID, 1, 0);
				world.setBlock(x + 0, y + 4, z + 0, Block.planks.blockID, 1, 0);

				// The window at east front
				world.setBlock(x + 2, y + 2, z + 0, Block.glass.blockID);
				world.setBlock(x + 2, y + 3, z + 0, Block.glass.blockID);

				// The window at west front
				world.setBlock(x - 2, y + 2, z + 0, Block.glass.blockID);
				world.setBlock(x - 2, y + 3, z + 0, Block.glass.blockID);

				// The window at east back
				world.setBlock(x + 2, y + 2, z + 6, Block.glass.blockID);
				world.setBlock(x + 2, y + 3, z + 6, Block.glass.blockID);
				world.setBlock(x + 1, y + 2, z + 6, Block.glass.blockID);
				world.setBlock(x + 1, y + 3, z + 6, Block.glass.blockID);

				// The window at west back
				world.setBlock(x - 2, y + 2, z + 6, Block.glass.blockID);
				world.setBlock(x - 2, y + 3, z + 6, Block.glass.blockID);
				world.setBlock(x - 1, y + 2, z + 6, Block.glass.blockID);
				world.setBlock(x - 1, y + 3, z + 6, Block.glass.blockID);

				// Windows at the sides
				world.setBlock(x - 4, y + 2, z + 2, Block.glass.blockID);
				world.setBlock(x + 4, y + 2, z + 2, Block.glass.blockID);
				world.setBlock(x - 4, y + 3, z + 2, Block.glass.blockID);
				world.setBlock(x + 4, y + 3, z + 2, Block.glass.blockID);
				world.setBlock(x - 4, y + 2, z + 3, Block.glass.blockID);
				world.setBlock(x + 4, y + 2, z + 3, Block.glass.blockID);
				world.setBlock(x - 4, y + 3, z + 3, Block.glass.blockID);
				world.setBlock(x + 4, y + 3, z + 3, Block.glass.blockID);
				world.setBlock(x - 4, y + 2, z + 4, Block.glass.blockID);
				world.setBlock(x + 4, y + 2, z + 4, Block.glass.blockID);
				world.setBlock(x - 4, y + 3, z + 4, Block.glass.blockID);
				world.setBlock(x + 4, y + 3, z + 4, Block.glass.blockID);

				// Adds the roof (cobble)
				for (int i = 0; i < 11; ++i) {
					world.setBlock((x + 5) - i, y + 5, z - 1, Block.stairsCobblestone.blockID, 2, 0);
					world.setBlock((x + 5) - i, y + 5, z + 7, Block.stairsCobblestone.blockID, 3, 0);
					world.setBlock((x + 5) - i, y + 6, z + 0, Block.stairsCobblestone.blockID, 2, 0);
					world.setBlock((x + 5) - i, y + 6, z + 6, Block.stairsCobblestone.blockID, 3, 0);
					world.setBlock((x + 5) - i, y + 7, z + 1, Block.stairsCobblestone.blockID, 2, 0);
					world.setBlock((x + 5) - i, y + 7, z + 5, Block.stairsCobblestone.blockID, 3, 0);
					world.setBlock((x + 5) - i, y + 8, z + 2, Block.stairsCobblestone.blockID, 2, 0);
					world.setBlock((x + 5) - i, y + 8, z + 4, Block.stairsCobblestone.blockID, 3, 0);
					world.setBlock((x + 5) - i, y + 8, z + 3, Block.cobblestone.blockID);
					world.setBlock((x + 5) - i, y + 9, z + 3, Block.stoneSingleSlab.blockID, 3, 0);
				}

				world.setBlock(x + 4, y + 5, z + 0, Block.wood.blockID, 1, 0);
				world.setBlock(x - 4, y + 5, z + 0, Block.wood.blockID, 1, 0);

				world.setBlock(x + 4, y + 5, z + 6, Block.wood.blockID, 1, 0);
				world.setBlock(x - 4, y + 5, z + 6, Block.wood.blockID, 1, 0);

				for (int i = 0; i < 7; ++i) {
					for (int j = 1; j < 5; ++j) {
						for (int k = 0; k < 5; ++k) {
							world.setBlockToAir((x + 3) - i, y + j, (z + 1) + k);
						}
					}
				}

				for (int i = 0; i < 9; ++i) {
					world.setBlock((x + 4) - i, y + 6, z + 1, Block.planks.blockID, 1, 0);
					world.setBlock((x + 4) - i, y + 6, z + 2, Block.planks.blockID, 1, 0);
					world.setBlock((x + 4) - i, y + 6, z + 3, Block.planks.blockID, 1, 0);
					world.setBlock((x + 4) - i, y + 6, z + 4, Block.planks.blockID, 1, 0);
					world.setBlock((x + 4) - i, y + 6, z + 5, Block.planks.blockID, 1, 0);

					world.setBlock((x + 4) - i, y + 7, z + 2, Block.planks.blockID, 1, 0);
					world.setBlock((x + 4) - i, y + 7, z + 3, Block.planks.blockID, 1, 0);
					world.setBlock((x + 4) - i, y + 7, z + 4, Block.planks.blockID, 1, 0);
				}

				ItemDoor.placeDoorBlock(world, x + 0, y + 1, z + 0, 1, Block.doorWood);

				world.setBlock(x + 0, y + 1, z + 3, Block.mobSpawner.blockID);
				TileEntityMobSpawner spawner = (TileEntityMobSpawner) world.getBlockTileEntity(x + 0, y + 1, z + 3);

				if (spawner != null) {
					spawner.getSpawnerLogic().setMobID("Witch");
				}

				world.setBlock(x + 0, y + 1, z + 5, ModBlocks.alchemistTable.blockID);

				return true;

			} else if (direction == 1) {

				// z - 1 == one block north, z + 1 == one block south, x - 1 == one block west, x + 1 == one block east

				// Entrance at West

				for (int i = 0; i < 7; ++i) {
					for (int j = 0; j < 5; ++j) {
						for (int k = 0; k < 9; ++k) {
							world.setBlock(x + i, y + 0, (z - 4) + k, Block.planks.blockID, 1, 0);
							world.setBlock(x + 6, y + j, (z - 4) + k, Block.planks.blockID, 1, 0);
							world.setBlock(x + i, y + j, (z - 4) + 0, Block.planks.blockID, 1, 0);
							world.setBlock(x + i, y + j, (z + 4) + 0, Block.planks.blockID, 1, 0);
							world.setBlock(x + i, y + 5, (z + 4) - k, Block.planks.blockID, 1, 0);
						}
					}
				}

				for (int k = 0; k < 4; ++k) {
					for (int j = 1; j < 5; ++j) {
						world.setBlock(x, y + j, (z + 4) - k, Block.planks.blockID, 1, 0);
						world.setBlock(x, y + j, (z - 4) + k, Block.planks.blockID, 1, 0);

						world.setBlock(x + 0, y + j, z - 4, Block.wood.blockID, 1, 0);
						world.setBlock(x + 0, y + j, z + 4, Block.wood.blockID, 1, 0);
						world.setBlock(x + 6, y + j, z - 4, Block.wood.blockID, 1, 0);
						world.setBlock(x + 6, y + j, z + 4, Block.wood.blockID, 1, 0);
					}
				}

				world.setBlock(x + 0, y + 3, z + 0, Block.planks.blockID, 1, 0);
				world.setBlock(x + 0, y + 4, z + 0, Block.planks.blockID, 1, 0);

				// The window at front south
				world.setBlock(x + 0, y + 2, z + 2, Block.glass.blockID);
				world.setBlock(x + 0, y + 3, z + 2, Block.glass.blockID);

				// The window at front north
				world.setBlock(x + 0, y + 2, z - 2, Block.glass.blockID);
				world.setBlock(x + 0, y + 3, z - 2, Block.glass.blockID);

				// The window at back south
				world.setBlock(x + 6, y + 2, z + 2, Block.glass.blockID);
				world.setBlock(x + 6, y + 3, z + 2, Block.glass.blockID);
				world.setBlock(x + 6, y + 2, z + 1, Block.glass.blockID);
				world.setBlock(x + 6, y + 3, z + 1, Block.glass.blockID);

				// The window at back north
				world.setBlock(x + 6, y + 2, z - 2, Block.glass.blockID);
				world.setBlock(x + 6, y + 3, z - 2, Block.glass.blockID);
				world.setBlock(x + 6, y + 2, z - 1, Block.glass.blockID);
				world.setBlock(x + 6, y + 3, z - 1, Block.glass.blockID);

				// Windows at the sides
				world.setBlock(x + 2, y + 2, z - 4, Block.glass.blockID);
				world.setBlock(x + 2, y + 2, z + 4, Block.glass.blockID);
				world.setBlock(x + 2, y + 3, z - 4, Block.glass.blockID);
				world.setBlock(x + 2, y + 3, z + 4, Block.glass.blockID);
				world.setBlock(x + 3, y + 2, z - 4, Block.glass.blockID);
				world.setBlock(x + 3, y + 2, z + 4, Block.glass.blockID);
				world.setBlock(x + 3, y + 3, z - 4, Block.glass.blockID);
				world.setBlock(x + 3, y + 3, z + 4, Block.glass.blockID);
				world.setBlock(x + 4, y + 2, z - 4, Block.glass.blockID);
				world.setBlock(x + 4, y + 2, z + 4, Block.glass.blockID);
				world.setBlock(x + 4, y + 3, z - 4, Block.glass.blockID);
				world.setBlock(x + 4, y + 3, z + 4, Block.glass.blockID);

				// Adds the roof (cobble)
				for (int i = 0; i < 11; ++i) {
					world.setBlock(x - 1, y + 5, (z + 5) - i, Block.stairsCobblestone.blockID, 0, 0);
					world.setBlock(x + 7, y + 5, (z + 5) - i, Block.stairsCobblestone.blockID, 1, 0);
					world.setBlock(x + 0, y + 6, (z + 5) - i, Block.stairsCobblestone.blockID, 0, 0);
					world.setBlock(x + 6, y + 6, (z + 5) - i, Block.stairsCobblestone.blockID, 1, 0);
					world.setBlock(x + 1, y + 7, (z + 5) - i, Block.stairsCobblestone.blockID, 0, 0);
					world.setBlock(x + 5, y + 7, (z + 5) - i, Block.stairsCobblestone.blockID, 1, 0);
					world.setBlock(x + 2, y + 8, (z + 5) - i, Block.stairsCobblestone.blockID, 0, 0);
					world.setBlock(x + 4, y + 8, (z + 5) - i, Block.stairsCobblestone.blockID, 1, 0);
					world.setBlock(x + 3, y + 8, (z + 5) - i, Block.cobblestone.blockID);
					world.setBlock(x + 3, y + 9, (z + 5) - i, Block.stoneSingleSlab.blockID, 3, 0);
				}

				world.setBlock(x + 0, y + 5, z + 4, Block.wood.blockID, 1, 0);
				world.setBlock(x + 0, y + 5, z - 4, Block.wood.blockID, 1, 0);

				world.setBlock(x + 6, y + 5, z + 4, Block.wood.blockID, 1, 0);
				world.setBlock(x + 6, y + 5, z - 4, Block.wood.blockID, 1, 0);

				for (int i = 0; i < 5; ++i) {
					for (int j = 1; j < 5; ++j) {
						for (int k = 0; k < 7; ++k) {
							world.setBlockToAir((x + 1) + i, y + j, (z + 3) - k);
						}
					}
				}

				for (int k = 0; k < 9; ++k) {
					world.setBlock(x + 1, y + 6, (z + 4) - k, Block.planks.blockID, 1, 0);
					world.setBlock(x + 2, y + 6, (z + 4) - k, Block.planks.blockID, 1, 0);
					world.setBlock(x + 3, y + 6, (z + 4) - k, Block.planks.blockID, 1, 0);
					world.setBlock(x + 4, y + 6, (z + 4) - k, Block.planks.blockID, 1, 0);
					world.setBlock(x + 5, y + 6, (z + 4) - k, Block.planks.blockID, 1, 0);

					world.setBlock(x + 2, y + 7, (z + 4) - k, Block.planks.blockID, 1, 0);
					world.setBlock(x + 3, y + 7, (z + 4) - k, Block.planks.blockID, 1, 0);
					world.setBlock(x + 4, y + 7, (z + 4) - k, Block.planks.blockID, 1, 0);
				}

				ItemDoor.placeDoorBlock(world, x + 0, y + 1, z + 0, 0, Block.doorWood);

				world.setBlock(x + 3, y + 1, z + 0, Block.mobSpawner.blockID);
				TileEntityMobSpawner spawner = (TileEntityMobSpawner) world.getBlockTileEntity(x + 3, y + 1, z + 0);

				if (spawner != null) {
					spawner.getSpawnerLogic().setMobID("Witch");
				}

				world.setBlock(x + 5, y + 1, z + 0, ModBlocks.alchemistTable.blockID);

				return true;

			} else if (direction == 0) {

				// Entrance at South

				for (int i = 0; i < 9; ++i) {
					for (int j = 1; j < 5; ++j) {
						for (int k = 0; k < 7; ++k) {
							world.setBlock((x + 4) - i, y + 0, z - k, Block.planks.blockID, 1, 0);
							world.setBlock((x + 4) - i, y + j, z - 6, Block.planks.blockID, 1, 0);
							world.setBlock((x + 4) - 0, y + j, z - k, Block.planks.blockID, 1, 0);
							world.setBlock((x - 4) - 0, y + j, z - k, Block.planks.blockID, 1, 0);
							world.setBlock((x - 4) + i, y + 5, z - k, Block.planks.blockID, 1, 0);
						}
					}
				}

				for (int i = 0; i < 4; ++i) {
					for (int j = 1; j < 5; ++j) {
						world.setBlock((x - 4) + i, y + j, z, Block.planks.blockID, 1, 0);
						world.setBlock((x + 4) - i, y + j, z, Block.planks.blockID, 1, 0);

						world.setBlock(x + 4, y + j, z - 0, Block.wood.blockID, 1, 0);
						world.setBlock(x - 4, y + j, z - 0, Block.wood.blockID, 1, 0);
						world.setBlock(x + 4, y + j, z - 6, Block.wood.blockID, 1, 0);
						world.setBlock(x - 4, y + j, z - 6, Block.wood.blockID, 1, 0);
					}
				}

				world.setBlock(x + 0, y + 3, z + 0, Block.planks.blockID, 1, 0);
				world.setBlock(x + 0, y + 4, z + 0, Block.planks.blockID, 1, 0);

				// The window at east front
				world.setBlock(x - 2, y + 2, z + 0, Block.glass.blockID);
				world.setBlock(x - 2, y + 3, z + 0, Block.glass.blockID);

				// The window at west front
				world.setBlock(x + 2, y + 2, z + 0, Block.glass.blockID);
				world.setBlock(x + 2, y + 3, z + 0, Block.glass.blockID);

				// The window at east back
				world.setBlock(x - 2, y + 2, z - 6, Block.glass.blockID);
				world.setBlock(x - 2, y + 3, z - 6, Block.glass.blockID);
				world.setBlock(x - 1, y + 2, z - 6, Block.glass.blockID);
				world.setBlock(x - 1, y + 3, z - 6, Block.glass.blockID);

				// The window at west back
				world.setBlock(x + 2, y + 2, z - 6, Block.glass.blockID);
				world.setBlock(x + 2, y + 3, z - 6, Block.glass.blockID);
				world.setBlock(x + 1, y + 2, z - 6, Block.glass.blockID);
				world.setBlock(x + 1, y + 3, z - 6, Block.glass.blockID);

				// Windows at the sides
				world.setBlock(x + 4, y + 2, z - 2, Block.glass.blockID);
				world.setBlock(x - 4, y + 2, z - 2, Block.glass.blockID);
				world.setBlock(x + 4, y + 3, z - 2, Block.glass.blockID);
				world.setBlock(x - 4, y + 3, z - 2, Block.glass.blockID);
				world.setBlock(x + 4, y + 2, z - 3, Block.glass.blockID);
				world.setBlock(x - 4, y + 2, z - 3, Block.glass.blockID);
				world.setBlock(x + 4, y + 3, z - 3, Block.glass.blockID);
				world.setBlock(x - 4, y + 3, z - 3, Block.glass.blockID);
				world.setBlock(x + 4, y + 2, z - 4, Block.glass.blockID);
				world.setBlock(x - 4, y + 2, z - 4, Block.glass.blockID);
				world.setBlock(x + 4, y + 3, z - 4, Block.glass.blockID);
				world.setBlock(x - 4, y + 3, z - 4, Block.glass.blockID);

				// Adds the roof (cobble)
				for (int i = 0; i < 11; ++i) {
					world.setBlock((x - 5) + i, y + 5, z + 1, Block.stairsCobblestone.blockID, 3, 0);
					world.setBlock((x - 5) + i, y + 5, z - 7, Block.stairsCobblestone.blockID, 2, 0);
					world.setBlock((x - 5) + i, y + 6, z - 0, Block.stairsCobblestone.blockID, 3, 0);
					world.setBlock((x - 5) + i, y + 6, z - 6, Block.stairsCobblestone.blockID, 2, 0);
					world.setBlock((x - 5) + i, y + 7, z - 1, Block.stairsCobblestone.blockID, 3, 0);
					world.setBlock((x - 5) + i, y + 7, z - 5, Block.stairsCobblestone.blockID, 2, 0);
					world.setBlock((x - 5) + i, y + 8, z - 2, Block.stairsCobblestone.blockID, 3, 0);
					world.setBlock((x - 5) + i, y + 8, z - 4, Block.stairsCobblestone.blockID, 2, 0);
					world.setBlock((x - 5) + i, y + 8, z - 3, Block.cobblestone.blockID);
					world.setBlock((x - 5) + i, y + 9, z - 3, Block.stoneSingleSlab.blockID, 3, 0);
				}

				world.setBlock(x - 4, y + 5, z + 0, Block.wood.blockID, 1, 0);
				world.setBlock(x + 4, y + 5, z + 0, Block.wood.blockID, 1, 0);

				world.setBlock(x - 4, y + 5, z - 6, Block.wood.blockID, 1, 0);
				world.setBlock(x + 4, y + 5, z - 6, Block.wood.blockID, 1, 0);

				for (int i = 0; i < 7; ++i) {
					for (int j = 1; j < 5; ++j) {
						for (int k = 0; k < 5; ++k) {
							world.setBlockToAir((x - 3) + i, y + j, (z - 1) - k);
						}
					}
				}

				for (int i = 0; i < 9; ++i) {
					world.setBlock((x - 4) + i, y + 6, z - 1, Block.planks.blockID, 1, 0);
					world.setBlock((x - 4) + i, y + 6, z - 2, Block.planks.blockID, 1, 0);
					world.setBlock((x - 4) + i, y + 6, z - 3, Block.planks.blockID, 1, 0);
					world.setBlock((x - 4) + i, y + 6, z - 4, Block.planks.blockID, 1, 0);
					world.setBlock((x - 4) + i, y + 6, z - 5, Block.planks.blockID, 1, 0);

					world.setBlock((x - 4) + i, y + 7, z - 2, Block.planks.blockID, 1, 0);
					world.setBlock((x - 4) + i, y + 7, z - 3, Block.planks.blockID, 1, 0);
					world.setBlock((x - 4) + i, y + 7, z - 4, Block.planks.blockID, 1, 0);
				}

				ItemDoor.placeDoorBlock(world, x + 0, y + 1, z + 0, 3, Block.doorWood);

				world.setBlock(x + 0, y + 1, z - 3, Block.mobSpawner.blockID);
				TileEntityMobSpawner spawner = (TileEntityMobSpawner) world.getBlockTileEntity(x + 0, y + 1, z - 3);

				if (spawner != null) {
					spawner.getSpawnerLogic().setMobID("Witch");
				}

				world.setBlock(x - 0, y + 1, z - 5, ModBlocks.alchemistTable.blockID);

				return true;

			} else if (direction == 3) {

				// z - 1 == one block north, z + 1 == one block south, x - 1 == one block west, x + 1 == one block east

				// Entrance at East

				for (int i = 0; i < 7; ++i) {
					for (int j = 0; j < 5; ++j) {
						for (int k = 0; k < 9; ++k) {
							world.setBlock(x - i, y + 0, (z + 4) - k, Block.planks.blockID, 1, 0);
							world.setBlock(x - 6, y + j, (z + 4) - k, Block.planks.blockID, 1, 0);
							world.setBlock(x - i, y + j, (z + 4) - 0, Block.planks.blockID, 1, 0);
							world.setBlock(x - i, y + j, (z - 4) - 0, Block.planks.blockID, 1, 0);
							world.setBlock(x - i, y + 5, (z - 4) + k, Block.planks.blockID, 1, 0);
						}
					}
				}

				for (int k = 0; k < 4; ++k) {
					for (int j = 1; j < 5; ++j) {
						world.setBlock(x, y + j, (z - 4) + k, Block.planks.blockID, 1, 0);
						world.setBlock(x, y + j, (z + 4) - k, Block.planks.blockID, 1, 0);

						world.setBlock(x - 0, y + j, z + 4, Block.wood.blockID, 1, 0);
						world.setBlock(x - 0, y + j, z - 4, Block.wood.blockID, 1, 0);
						world.setBlock(x - 6, y + j, z + 4, Block.wood.blockID, 1, 0);
						world.setBlock(x - 6, y + j, z - 4, Block.wood.blockID, 1, 0);
					}
				}

				world.setBlock(x + 0, y + 3, z + 0, Block.planks.blockID, 1, 0);
				world.setBlock(x + 0, y + 4, z + 0, Block.planks.blockID, 1, 0);

				// The window at front south
				world.setBlock(x + 0, y + 2, z - 2, Block.glass.blockID);
				world.setBlock(x + 0, y + 3, z - 2, Block.glass.blockID);

				// The window at front north
				world.setBlock(x + 0, y + 2, z + 2, Block.glass.blockID);
				world.setBlock(x + 0, y + 3, z + 2, Block.glass.blockID);

				// The window at back south
				world.setBlock(x - 6, y + 2, z - 2, Block.glass.blockID);
				world.setBlock(x - 6, y + 3, z - 2, Block.glass.blockID);
				world.setBlock(x - 6, y + 2, z - 1, Block.glass.blockID);
				world.setBlock(x - 6, y + 3, z - 1, Block.glass.blockID);

				// The window at back north
				world.setBlock(x - 6, y + 2, z + 2, Block.glass.blockID);
				world.setBlock(x - 6, y + 3, z + 2, Block.glass.blockID);
				world.setBlock(x - 6, y + 2, z + 1, Block.glass.blockID);
				world.setBlock(x - 6, y + 3, z + 1, Block.glass.blockID);

				// Windows at the sides
				world.setBlock(x - 2, y + 2, z + 4, Block.glass.blockID);
				world.setBlock(x - 2, y + 2, z - 4, Block.glass.blockID);
				world.setBlock(x - 2, y + 3, z + 4, Block.glass.blockID);
				world.setBlock(x - 2, y + 3, z - 4, Block.glass.blockID);
				world.setBlock(x - 3, y + 2, z + 4, Block.glass.blockID);
				world.setBlock(x - 3, y + 2, z - 4, Block.glass.blockID);
				world.setBlock(x - 3, y + 3, z + 4, Block.glass.blockID);
				world.setBlock(x - 3, y + 3, z - 4, Block.glass.blockID);
				world.setBlock(x - 4, y + 2, z + 4, Block.glass.blockID);
				world.setBlock(x - 4, y + 2, z - 4, Block.glass.blockID);
				world.setBlock(x - 4, y + 3, z + 4, Block.glass.blockID);
				world.setBlock(x - 4, y + 3, z - 4, Block.glass.blockID);

				// Adds the roof (cobble)
				for (int i = 0; i < 11; ++i) {
					world.setBlock(x + 1, y + 5, (z - 5) + i, Block.stairsCobblestone.blockID, 1, 0);
					world.setBlock(x - 7, y + 5, (z - 5) + i, Block.stairsCobblestone.blockID, 0, 0);
					world.setBlock(x - 0, y + 6, (z - 5) + i, Block.stairsCobblestone.blockID, 1, 0);
					world.setBlock(x - 6, y + 6, (z - 5) + i, Block.stairsCobblestone.blockID, 0, 0);
					world.setBlock(x - 1, y + 7, (z - 5) + i, Block.stairsCobblestone.blockID, 1, 0);
					world.setBlock(x - 5, y + 7, (z - 5) + i, Block.stairsCobblestone.blockID, 0, 0);
					world.setBlock(x - 2, y + 8, (z - 5) + i, Block.stairsCobblestone.blockID, 1, 0);
					world.setBlock(x - 4, y + 8, (z - 5) + i, Block.stairsCobblestone.blockID, 0, 0);
					world.setBlock(x - 3, y + 8, (z - 5) + i, Block.cobblestone.blockID);
					world.setBlock(x - 3, y + 9, (z - 5) + i, Block.stoneSingleSlab.blockID, 3, 0);
				}

				world.setBlock(x + 0, y + 5, z - 4, Block.wood.blockID, 1, 0);
				world.setBlock(x + 0, y + 5, z + 4, Block.wood.blockID, 1, 0);

				world.setBlock(x - 6, y + 5, z - 4, Block.wood.blockID, 1, 0);
				world.setBlock(x - 6, y + 5, z + 4, Block.wood.blockID, 1, 0);

				for (int i = 0; i < 5; ++i) {
					for (int j = 1; j < 5; ++j) {
						for (int k = 0; k < 7; ++k) {
							world.setBlockToAir((x - 1) - i, y + j, (z - 3) + k);
						}
					}
				}

				for (int k = 0; k < 9; ++k) {
					world.setBlock(x - 1, y + 6, (z - 4) + k, Block.planks.blockID, 1, 0);
					world.setBlock(x - 2, y + 6, (z - 4) + k, Block.planks.blockID, 1, 0);
					world.setBlock(x - 3, y + 6, (z - 4) + k, Block.planks.blockID, 1, 0);
					world.setBlock(x - 4, y + 6, (z - 4) + k, Block.planks.blockID, 1, 0);
					world.setBlock(x - 5, y + 6, (z - 4) + k, Block.planks.blockID, 1, 0);

					world.setBlock(x - 2, y + 7, (z - 4) + k, Block.planks.blockID, 1, 0);
					world.setBlock(x - 3, y + 7, (z - 4) + k, Block.planks.blockID, 1, 0);
					world.setBlock(x - 4, y + 7, (z - 4) + k, Block.planks.blockID, 1, 0);
				}

				ItemDoor.placeDoorBlock(world, x + 0, y + 1, z + 0, 2, Block.doorWood);

				world.setBlock(x - 3, y + 1, z + 0, Block.mobSpawner.blockID);
				TileEntityMobSpawner spawner = (TileEntityMobSpawner) world.getBlockTileEntity(x - 3, y + 1, z + 0);

				if (spawner != null) {
					spawner.getSpawnerLogic().setMobID("Witch");
				}

				world.setBlock(x - 5, y + 1, z - 0, ModBlocks.alchemistTable.blockID);

				return true;

			}

		}

		return false;
	}

}
