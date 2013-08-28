package net.blazecoding.magicpowders.network;

import net.blazecoding.magicpowders.network.packet.PacketMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

/**
 * 
 * Magic Powders
 * 
 * PacketHandler
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class PacketHandler implements IPacketHandler {

	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {

		PacketMP packetMP = PacketTypeHandler.buildPacket(packet.data);

		packetMP.execute(manager, player);

	}

}
