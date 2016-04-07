package net.core.main;

import net.core.main.SQL.Ranks;
import net.core.main.handlers.scoreBoardHandler;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerJoin implements Listener{
	
	@SuppressWarnings("unused")
	private main plugin;
	public playerJoin(main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e){
		Ranks.loadPlayer(e.getPlayer());
		if(Ranks.getRank(e.getPlayer()) == null){
			Ranks.setRank(e.getPlayer(), "DEFAULT");
			scoreBoardHandler.makeScoreBoard(e.getPlayer(), "displayName", "displayName2", "title1", "description1", "title2", "description2", "title3", "description3", "title4", "description4", "title5", "description5");
		}
	}
}
