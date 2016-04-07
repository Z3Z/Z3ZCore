package net.core.main.handlers;

import net.core.main.main;
import net.core.main.SQL.Ranks;
import net.core.main.utils.util;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chatHandler implements Listener{
	
	@SuppressWarnings("unused")
	private main plugin;
	public chatHandler(main listener) {
		this.plugin = listener;		
	}
	
	
	//RANK CHAT HANDLER DO NOT TOUCH
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = (Player) e.getPlayer();
		if(Ranks.getRank(p).equals("OWNER")){
			e.setFormat(util.color(" &c&l" + Ranks.getRank(p) + " &c" + e.getPlayer().getName() + " &7" + e.getMessage()));
		}else if(Ranks.getRank(p).equals("ADMIN")){
			e.setFormat(util.color(" &c&l" + Ranks.getRank(p) + " &c" + e.getPlayer().getName() + " &7" + e.getMessage()));
		}else if(Ranks.getRank(p).equals("YOUTUBE")){
			e.setFormat(util.color(" &c&l" + Ranks.getRank(p) + " &c" + e.getPlayer().getName() + " &7" + e.getMessage()));
		}else if(Ranks.getRank(p).equals("TWITCH")){
			e.setFormat(util.color(" &5&l" + Ranks.getRank(p) + " &5" + e.getPlayer().getName() + " &7" + e.getMessage()));
		}else if(Ranks.getRank(p).equals("DEV")){
			e.setFormat(util.color(" &6&l" + Ranks.getRank(p) + " &6" + e.getPlayer().getName() + " &7" + e.getMessage()));
		}else if(Ranks.getRank(p).equals("JRDEV")){
			e.setFormat(util.color(" &6&l" + Ranks.getRank(p) + " &6" + e.getPlayer().getName() + " &7" + e.getMessage()));
		}else if(Ranks.getRank(p).equals("SRMOD")){
			e.setFormat(util.color(" &e&l" + Ranks.getRank(p) + " &e" + e.getPlayer().getName() + " &7" + e.getMessage()));
		}else if(Ranks.getRank(p).equals("MOD")){
			e.setFormat(util.color(" &e&l" + Ranks.getRank(p) +  " &e" + e.getPlayer().getName() + " &7" + e.getMessage()));
		}else if(Ranks.getRank(p).equals("HELPER")){
			e.setFormat(util.color(" &b&l" + Ranks.getRank(p) +  " &b" + e.getPlayer().getName() + " &7" + e.getMessage()));
		}else if(Ranks.getRank(p).equals("HBUILDER")){
			e.setFormat(util.color(" &9&l" + Ranks.getRank(p) +  " &9" + e.getPlayer().getName() + " &7" + e.getMessage()));
		}else if(Ranks.getRank(p).equals("BUILDER")){
			e.setFormat(util.color(" &9&l" + Ranks.getRank(p) +  " &9" + e.getPlayer().getName() + " &7" + e.getMessage()));
		}else if(Ranks.getRank(p).equals("DONOR1")){
			e.setFormat(util.color(" &e✪ " + e.getPlayer().getName() + " &r" + e.getMessage()));
		}else if(Ranks.getRank(p).equals("DONOR2")){
			e.setFormat(util.color(" &a✪✪ " + e.getPlayer().getName() + " &r" + e.getMessage()));
		}else if(Ranks.getRank(p).equals("DONOR3")){
			e.setFormat(util.color(" &b✪✪✪ " + e.getPlayer().getName() + " &r" + e.getMessage()));
		}else if(Ranks.getRank(p).equals("DEFAULT")){
			e.setFormat(util.color(" &8" + e.getPlayer().getName() + " &7" + e.getMessage()));
		}
	}
	
}
