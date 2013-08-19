package net.blazecoding.magicpowders.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemDoor;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 * 
 * Magic Powders
 * 
 * WorldGenApprenticeHouse
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class WorldGenApprenticeHouse extends WorldGenerator {

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {

		if (world.isAirBlock(x, y + 1, z) && world.getBlockId(x, y, z) == Block.grass.blockID && world.getBlockId(x - 5, y, z + 0) == Block.grass.blockID && world.getBlockId(x - 5, y, z + 7) == Block.grass.blockID && world.getBlockId(x + 5, y, z + 0) == Block.grass.blockID && world.getBlockId(x + 5, y, z + 7) == Block.grass.blockID) {

			// z - 1 == one block north, z + 1 == one block south, x - 1 == one block west, x + 1 == one block east

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

			// Windows at the side
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

			return true;

		}

		return false;
	}

}
