package net.core.main.handlers;

import net.core.main.main;
import net.core.main.utils.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class scoreBoardHandler implements Listener{
	
	@SuppressWarnings("unused")
	private static main plugin;
	public scoreBoardHandler(main listener) {
		scoreBoardHandler.plugin = listener;
		//boardUpdater();
	}
	
public static Scoreboard board;
public static Objective objective;

public static String descriptionOne;
public static String descriptionTwo;
public static String descriptionThree;
public static String descriptionFour;
public static String descriptionFive;
	
    public static void makeScoreBoard(final Player p, String displayName, String displayName2, String title1, String description1, String title2, String description2, String title3, String description3, String title4, String description4, String title5, String description5){
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        board = scoreboardManager.getNewScoreboard();
        objective = board.registerNewObjective("lobby","dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(util.color(displayName));
        Score score1 = objective.getScore(util.color(displayName2));
        score1.setScore(15);
        Score score = objective.getScore(util.color(title1));
        score.setScore(14);
        Score score2 = objective.getScore(util.color("&a"));
        score2.setScore(13);
        Score score3 = objective.getScore(util.color(" "));
        score3.setScore(12);
        Score score4 = objective.getScore(util.color(title2));
        score4.setScore(11);
        Score score5 = objective.getScore(util.color("&b"));
        score5.setScore(10);
        Score score6 = objective.getScore(util.color("  "));
        score6.setScore(9);
        Score score7 = objective.getScore(util.color(title3));
        score7.setScore(8);
        Score score8 = objective.getScore(util.color("&c"));
        score8.setScore(7);
        Score score9 = objective.getScore(util.color("   "));
        score9.setScore(6);
        Score score10 = objective.getScore(util.color(title4));
        score10.setScore(5);
        Score score11 = objective.getScore(util.color("&d"));
        score11.setScore(4);
        Score score12 = objective.getScore(util.color("    "));
        score12.setScore(3);
        Score score13 = objective.getScore(util.color(title5));
        score13.setScore(2);
        Score score14 = objective.getScore(util.color("&e"));
        score14.setScore(1);
        
        descriptionOne = description1;
        descriptionTwo = description2;
        descriptionThree = description3;
        descriptionFour = description4;
        descriptionFive = description5;
        
        Team team1 = board.registerNewTeam("team1");
        team1.addEntry(util.color("&a"));
        
        Team team2 = board.registerNewTeam("team2");
        team2.addEntry(util.color("&b"));

        Team team3 = board.registerNewTeam("team3");
        team3.addEntry(util.color("&c"));
        
        Team team4 = board.registerNewTeam("team4");
        team4.addEntry(util.color("&d"));
        
        Team team5 = board.registerNewTeam("team5");
        team5.addEntry(util.color("&e"));
		p.setScoreboard(board);
    }
    
    /*public static void boardUpdater(){
    	Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
        		public void run() {
        			
        			for(final Player p : Bukkit.getOnlinePlayers()){
        				if(!(p.equals(null))){
        					
        			Team team1 = p.getScoreboard().getTeam("team1");
    				team1.setPrefix(util.color("&8&l" + "▶ "));
    				team1.setSuffix(util.color("&r" + descriptionOne));
        			
    				Team team2 = p.getScoreboard().getTeam("team2"); 
    				team2.setPrefix(util.color("&8&l" + "▶ "));
    				team2.setSuffix(util.color("&r" + descriptionTwo));
    				
    				Team team3 = p.getScoreboard().getTeam("team3");
    				team3.setPrefix(util.color("&8&l" + "▶ "));
    				team3.setSuffix(util.color("&r" + descriptionThree));
    				
    				Team team4 = p.getScoreboard().getTeam("team4");
    				team4.setPrefix(util.color("&8&l" + "▶ "));
    				team4.setSuffix(util.color("&r" + descriptionFour));
    				
    				Team team5 = p.getScoreboard().getTeam("team5");
    				team5.setPrefix(util.color("&8&l" + "▶ "));
    				team5.setSuffix(util.color("&r" + descriptionFive));
        			}
        			}
        			}
            	}, 0, 5);
					//END OF SCOREBOARD DISPLAYNAME
    }*/
}
