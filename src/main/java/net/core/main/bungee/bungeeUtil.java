package net.core.main.bungee;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.core.main.main;
import net.core.main.utils.hashMapStorage;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class bungeeUtil implements Listener{

	private static main plugin;

	public bungeeUtil(main hub) {
		bungeeUtil.plugin = hub;
	}

	public static void sendToServer(Player player, String targetServer) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("Connect");
			out.writeUTF(targetServer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}
	
	public static void sendMessage(Player player, String playerName, String Message) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("Message");
			out.writeUTF(playerName);
			out.writeUTF(Message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}
	
	public static String[] getServerList(Player player, String targetServer) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("GetServers");
			out.writeUTF(targetServer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
		return main.serverList;
	}
	
	public static String[] getPlayerList(Player player, String targetServer) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("PlayerList");
			out.writeUTF(targetServer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
		return main.playerList;
	}
	
	public static String getServer(Player player) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("GetServer");
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
		return main.GetServer;
	}
	
	public static Integer playerCountOfServer(Player player, String targetServer) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("PlayerCount");
			out.writeUTF(targetServer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
		return hashMapStorage.PlayerCount.get(targetServer);
	}
	
	public static void kickPlayer(Player player, String playerName, String kickMessage) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("KickPlayer");
			out.writeUTF(playerName);
			out.writeUTF(kickMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}
}