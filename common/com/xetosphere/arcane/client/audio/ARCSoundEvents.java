package com.xetosphere.arcane.client.audio;

import com.xetosphere.arcane.lib.Strings;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class ARCSoundEvents {

	@ForgeSubscribe
	public void onSound(SoundLoadEvent event) {

		event.manager.addSound(Strings.RESOURCE_PREFIX + "scroll.ogg");
	}

}
