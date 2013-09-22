package com.xetosphere.arcane.network;

import com.xetosphere.arcane.network.packet.PacketARC;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {

		PacketARC packetAEX = PacketTypeHandler.buildPacket(packet.data);

		packetAEX.execute(manager, player);

	}

}
