package com.xetosphere.arcane.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import com.xetosphere.arcane.lib.Reference;
import com.xetosphere.arcane.network.packet.PacketAEX;
import com.xetosphere.arcane.network.packet.PacketTileUpdate;
import com.xetosphere.arcane.network.packet.PacketTileWithItemUpdate;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public enum PacketTypeHandler {
	TILE(PacketTileUpdate.class), TILE_WITH_ITEM(PacketTileWithItemUpdate.class);

	private Class<? extends PacketAEX> clazz;

	PacketTypeHandler(Class<? extends PacketAEX> clazz) {
		this.clazz = clazz;
	}

	public static PacketAEX buildPacket(byte[] data) {

		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		int selector = bis.read();
		DataInputStream dis = new DataInputStream(bis);

		PacketAEX packet = null;

		try {
			packet = values()[selector].clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		packet.readPopulate(dis);

		return packet;

	}

	public static PacketAEX buildPacket(PacketTypeHandler type) {

		PacketAEX packet = null;

		try {
			packet = values()[type.ordinal()].clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		return packet;

	}

	public static Packet populatePacket(PacketAEX packetAEX) {

		byte[] data = packetAEX.populate();

		Packet250CustomPayload packet250 = new Packet250CustomPayload();
		packet250.channel = Reference.CHANNEL_NAME;
		packet250.data = data;
		packet250.length = data.length;
		packet250.isChunkDataPacket = packetAEX.isChunkDataPacket;

		return packet250;

	}

}
