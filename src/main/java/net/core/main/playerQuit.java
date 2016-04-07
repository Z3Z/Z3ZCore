package net.core.main;

import net.core.main.SQL.Ranks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class playerQuit implements Listener{
	
	@SuppressWarnings("unused")
	private main plugin;
	public playerQuit(main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void PlayerQuit(PlayerQuitEvent e){
		Ranks.savePlayer(e.getPlayer());
	}
}
