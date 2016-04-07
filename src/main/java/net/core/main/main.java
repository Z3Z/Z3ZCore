package net.core.main;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.sql.PreparedStatement;

import net.core.main.SQL.Ranks;
import net.core.main.SQL.SQL;
import net.core.main.bungee.bungeeUtil;
import net.core.main.handlers.chatHandler;
import net.core.main.handlers.commandHandler;
import net.core.main.handlers.scoreBoardHandler;
import net.core.main.utils.hashMapStorage;
import net.core.main.utils.packets;
import net.core.main.utils.util;
import net.core.main.utils.worldManager;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_9_R1.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class main extends JavaPlugin implements Listener, PluginMessageListener{
	
	public static String GetServer;
	public static String[] serverList;
	public static String[] playerList;
	public static SQL mysql;
	private static main instance;
	
	public void onEnable(){
		loadClasses();
		loadCommands();
		loadBungee();
		instance = this;
	    connectMySQL();
	    for(Player p : Bukkit.getOnlinePlayers()){
			Ranks.loadPlayer(p);
		}
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(util.color("&8<-&aCORE&8-> &eHas been enabled!"));
	}
	
	public void onDisable(){
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(util.color("&8<-&aCORE&8-> &cHas been disabled!"));
		mysql.close();
		for(Player p : Bukkit.getOnlinePlayers()){
			Ranks.savePlayer(p);
		}
	}
	
	public static main getInstance(){
	     return instance;
	}

	public SQL getMySQL(){
	     return mysql;
	}

	public void connectMySQL() {
	     mysql = new SQL("play.hyperialmc.net", "3306", "PlayerStats", "admin", "HyperialDankness54321");
	     PreparedStatement statement = mysql.prepareStatement(
	    	       "CREATE TABLE IF NOT EXISTS Ranks(UUID varchar(36) NOT NULL, name VARCHAR(16) NOT NULL, RANK VARCHAR(45) NOT NULL, PRIMARY KEY(UUID))");
	     mysql.update(statement);
	}
	
	public void loadBungee(){
		Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this,"BungeeCord");
	    Bukkit.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
	}
	
	public void loadClasses(){
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new bungeeUtil(this), this);
		pm.registerEvents(new hashMapStorage(this), this);
		pm.registerEvents(new packets(this), this);
		pm.registerEvents(new util(this), this);
		pm.registerEvents(new worldManager(this), this);
		pm.registerEvents(new playerQuit(this), this);
		pm.registerEvents(new playerJoin(this), this);
		pm.registerEvents(new chatHandler(this), this);
		pm.registerEvents(new scoreBoardHandler(this), this);
	}
	
	public void loadCommands(){
		((CraftServer) this.getServer()).getCommandMap().register("lobby", new commandHandler("lobby", "Used to warp back to our lobby server!"));
		((CraftServer) this.getServer()).getCommandMap().register("buildteam", new commandHandler("buildteam", "Used to go to our build teams server!"));
		((CraftServer) this.getServer()).getCommandMap().register("build", new commandHandler("build", "Used to go to our build teams server!"));
		((CraftServer) this.getServer()).getCommandMap().register("hub", new commandHandler("hub", "Used to warp back to our hub server!"));
		((CraftServer) this.getServer()).getCommandMap().register("pl", new commandHandler("pl", "Used to list our plugins!"));
		((CraftServer) this.getServer()).getCommandMap().register("?", new commandHandler("?", "Used to list our plugins and permissions!"));
		((CraftServer) this.getServer()).getCommandMap().register("plugins", new commandHandler("plugins", "Used to list our plugins!"));
		((CraftServer) this.getServer()).getCommandMap().register("developer", new commandHandler("developer", "Used to join the developers server!"));
		((CraftServer) this.getServer()).getCommandMap().register("dev", new commandHandler("dev", "Used to join the developers server!"));
		((CraftServer) this.getServer()).getCommandMap().register("rank", new commandHandler("rank", "Used to change your rank on the server!"));
	}
	
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
	    if (!channel.equals("BungeeCord")) {
	      return;
	    }
	    try{
	    	DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
		    String subchannel = in.readUTF();
	    if (subchannel.equals("PlayerCount")) {
	    	String PlayerCountServer = in.readUTF();
	    	Integer playercount = in.readInt();
	    	hashMapStorage.PlayerCount.remove(PlayerCountServer);
	    	hashMapStorage.PlayerCount.put(PlayerCountServer, playercount);
        } else if (subchannel.equals("GetServers")) {
        	serverList = in.readUTF().split(", ");
        } else if (subchannel.equals("PlayerList")) {
        	playerList = in.readUTF().split(", ");
        } else if (subchannel.equals("GetServer")) {
            // Example: GetServer subchannel
        	GetServer = in.readUTF();
        }
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	  }
}
