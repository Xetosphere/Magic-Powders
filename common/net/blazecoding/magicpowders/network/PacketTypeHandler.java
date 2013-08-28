package net.blazecoding.magicpowders.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.blazecoding.magicpowders.lib.Reference;
import net.blazecoding.magicpowders.network.packet.PacketMP;
import net.blazecoding.magicpowders.network.packet.PacketTileUpdate;
import net.blazecoding.magicpowders.network.packet.PacketTileWithItemUpdate;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

/**
 * 
 * Magic Powders
 * 
 * PacketTypeHandler
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public enum PacketTypeHandler {
	TILE(PacketTileUpdate.class), TILE_WITH_ITEM(PacketTileWithItemUpdate.class);

	private Class<? extends PacketMP> clazz;

	PacketTypeHandler(Class<? extends PacketMP> clazz) {
		this.clazz = clazz;
	}

	public static PacketMP buildPacket(byte[] data) {

		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		int selector = bis.read();
		DataInputStream dis = new DataInputStream(bis);

		PacketMP packet = null;

		try {
			packet = values()[selector].clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		packet.readPopulate(dis);

		return packet;

	}

	public static PacketMP buildPacket(PacketTypeHandler type) {

		PacketMP packet = null;

		try {
			packet = values()[type.ordinal()].clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		return packet;

	}

	public static Packet populatePacket(PacketMP packetMP) {

		byte[] data = packetMP.populate();

		Packet250CustomPayload packet250 = new Packet250CustomPayload();
		packet250.channel = Reference.CHANNEL_NAME;
		packet250.data = data;
		packet250.length = data.length;
		packet250.isChunkDataPacket = packetMP.isChunkDataPacket;

		return packet250;

	}

}
