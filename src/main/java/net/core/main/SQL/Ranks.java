package net.core.main.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.core.main.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Ranks {

    private static Map<UUID, String> rank = new HashMap<UUID, String>();

    private static final String INSERT = "INSERT INTO Ranks VALUES(?,?,?) ON DUPLICATE KEY UPDATE name=?";
    private static final String SELECT = "SELECT RANK FROM Ranks WHERE UUID=?";
    private static final String SAVE = "UPDATE Ranks SET RANK=? WHERE UUID=?";
    
    private static void addPlayer(Player p, String rankName) {
        removePlayer(p);
        rank.put(p.getUniqueId(), rankName);
    }

    public static void removePlayer(Player p) {
        rank.remove(p.getUniqueId());
    }

    public static String getRank(Player p) {
        if (rank.containsKey(p.getUniqueId()))
            return rank.get(p.getUniqueId());
        return null;
    }

    public static void setRank(Player p, String rankname) {
        if (rank.containsKey(p.getUniqueId())){
        	rank.remove(p.getUniqueId());
            rank.put(p.getUniqueId(), rankname);
        }else{
           rank.put(p.getUniqueId(), rankname);
        }
    }
    
    public static void loadPlayer(final Player p) {
        Bukkit.getScheduler().runTaskAsynchronously(main.getInstance(), new Runnable() {
            public void run() {
                try {
                    PreparedStatement statement = main.mysql.prepareStatement(INSERT);
                    statement.setString(1, p.getUniqueId().toString());
                    statement.setString(2, p.getName());
                    statement.setString(3, rank.get(p.getUniqueId()));
                    statement.setString(4, p.getName());
                    main.mysql.update(statement);

                    statement = main.mysql.prepareStatement(SELECT);
                    statement.setString(1, p.getUniqueId().toString());
                    ResultSet result = main.mysql.query(statement);
                    if (result.next())
                        addPlayer(p, result.getString("RANK"));
                    result.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static void savePlayer(final Player p) {
        Bukkit.getScheduler().runTaskAsynchronously(main.getInstance(), new Runnable() {
            public void run() {
                try {
                    PreparedStatement statement = main.mysql.prepareStatement(SAVE);
                    statement.setString(1, rank.get(p.getUniqueId()));
                    statement.setString(2, p.getUniqueId().toString());
                    main.mysql.update(statement);
                    removePlayer(p);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
