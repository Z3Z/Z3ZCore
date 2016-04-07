package net.core.main.utils;

import java.util.HashMap;

import net.core.main.main;

import org.bukkit.event.Listener;

public class hashMapStorage implements Listener{
	
	@SuppressWarnings("unused")
	private main plugin;
	public hashMapStorage(main listener) {
		this.plugin = listener;		
	}
	
	public static HashMap<String, Integer> PlayerCount = new HashMap<String, Integer>();
	
}
