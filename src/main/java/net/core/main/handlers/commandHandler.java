package net.core.main.handlers;

import net.core.main.main;
import net.core.main.SQL.Ranks;
import net.core.main.bungee.bungeeUtil;
import net.core.main.utils.util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class commandHandler extends BukkitCommand {
	
	@SuppressWarnings("unused")
	private main plugin;

	public commandHandler(String string, String description) {
		super(string);
		this.description = description;
	}

	public boolean execute(CommandSender sender, String alias, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			Player target = Bukkit.getServer().getPlayer(args[1]);
			
			if (alias.equalsIgnoreCase("lobby")) {
				if (args.length >= 2 || args.length < 1 || args.equals(null)) {
					bungeeUtil.sendToServer(p, "Lobby");
				}
			}
			
			if (alias.equalsIgnoreCase("pl") || alias.equalsIgnoreCase("plugins") || alias.equalsIgnoreCase("?")) {
				if(!(p.isOp())){
					return true;
				}
			}
			
			if (alias.equalsIgnoreCase("hub")) {
				if (args.length >= 2 || args.length < 1 || args.equals(null)) {
					bungeeUtil.sendToServer(p, "Lobby");
				}
			}
			
			if (alias.equalsIgnoreCase("dev") || alias.equalsIgnoreCase("developer")) {
				if (args.length >= 2 || args.length < 1 || args.equals(null)) {
					bungeeUtil.sendToServer(p, "Developer");
				}
			}
			
			if (alias.equalsIgnoreCase("buildteam") || alias.equalsIgnoreCase("build")) {
				if (args.length >= 2 || args.length < 1 || args.equals(null)) {
					bungeeUtil.sendToServer(p, "BuildTeam");
				}
			}
			
			if (alias.equalsIgnoreCase("rank")){
				if(Ranks.getRank(p).equals("OWNER") || Ranks.getRank(p).equals("ADMIN") || p.isOp()){
				if(args.length >= 4 || args.length < 1 || args.equals(null)){
					p.sendMessage(util.color("&e&lUSAGE&8&l: &c/rank set [player] [rank]"));
				}else if(args[0].equalsIgnoreCase("set")){
					if(target != null){
						if(args[2].equalsIgnoreCase("owner")){
							Ranks.setRank(target, "OWNER");
							target.sendMessage(util.color("&cYour rank has been set to &eOWNER"));
							target.kickPlayer(util.color("&cYour rank has been changed please relog!"));
						}else if(args[2].equalsIgnoreCase("admin")){
							Ranks.setRank(target, "ADMIN");
							target.sendMessage(util.color("&cYour rank has been set to &eADMIN"));
							target.kickPlayer(util.color("&cYour rank has been changed please relog!"));
						}else if(args[2].equalsIgnoreCase("youtube")){
							Ranks.setRank(target, "YOUTUBE");
							target.sendMessage(util.color("&cYour rank has been set to &eYOUTUBE"));
							target.kickPlayer(util.color("&cYour rank has been changed please relog!"));
						}else if(args[2].equalsIgnoreCase("twitch")){
							Ranks.setRank(target, "TWITCH");
							target.sendMessage(util.color("&cYour rank has been set to &eTWITCH"));
							target.kickPlayer(util.color("&cYour rank has been changed please relog!"));
						}else if(args[2].equalsIgnoreCase("dev")){
							Ranks.setRank(target, "DEV");
							target.sendMessage(util.color("&cYour rank has been set to &eDEV"));
							target.kickPlayer(util.color("&cYour rank has been changed please relog!"));
						}else if(args[2].equalsIgnoreCase("jrdev")){
							Ranks.setRank(target, "JRDEV");
							target.sendMessage(util.color("&cYour rank has been set to &eJR.DEV"));
							target.kickPlayer(util.color("&cYour rank has been changed please relog!"));
						}else if(args[2].equalsIgnoreCase("srmod")){
							Ranks.setRank(target, "SRMOD");
							target.sendMessage(util.color("&cYour rank has been set to &eSR.MOD"));
							target.kickPlayer(util.color("&cYour rank has been changed please relog!"));
						}else if(args[2].equalsIgnoreCase("mod")){
							Ranks.setRank(target, "MOD");
							target.sendMessage(util.color("&cYour rank has been set to &eMOD"));
							target.kickPlayer(util.color("&cYour rank has been changed please relog!"));
						}else if(args[2].equalsIgnoreCase("helper")){
							Ranks.setRank(target, "HELPER");
							target.sendMessage(util.color("&cYour rank has been set to &eHELPER"));
							target.kickPlayer(util.color("&cYour rank has been changed please relog!"));
						}else if(args[2].equalsIgnoreCase("headbuilder")){
							Ranks.setRank(target, "HBUILDER");
							target.sendMessage(util.color("&cYour rank has been set to &eHEAD-BUILDER"));
							target.kickPlayer(util.color("&cYour rank has been changed please relog!"));
						}else if(args[2].equalsIgnoreCase("builder")){
							Ranks.setRank(target, "BUILDER");
							target.sendMessage(util.color("&cYour rank has been set to &eBUILDER"));
							target.kickPlayer(util.color("&cYour rank has been changed please relog!"));
						}else if(args[2].equalsIgnoreCase("donor1")){
							Ranks.setRank(target, "DONOR1");
							target.sendMessage(util.color("&cYour rank has been set to &e✪"));
							target.kickPlayer(util.color("&cYour rank has been changed please relog!"));
						}else if(args[2].equalsIgnoreCase("donor2")){
							Ranks.setRank(target, "DONOR2");
							target.sendMessage(util.color("&cYour rank has been set to &e✪✪"));
							target.kickPlayer(util.color("&cYour rank has been changed please relog!"));
						}else if(args[2].equalsIgnoreCase("donor3")){
							Ranks.setRank(target, "DONOR3");
							target.sendMessage(util.color("&cYour rank has been set to &e✪✪✪"));
							target.kickPlayer(util.color("&cYour rank has been changed please relog!"));
						}else if(args[2].equalsIgnoreCase("default")){
							Ranks.setRank(target, "DEFAULT");
							target.sendMessage(util.color("&cYour rank has been set to &eDEFAULT"));
							target.kickPlayer(util.color("&cYour rank has been changed please relog!"));
						}
					}
				}
				}else{
					p.sendMessage(util.color("&cYou dont have permission to do that!"));
				}
			}
			
		}
		return true;
	}
}
