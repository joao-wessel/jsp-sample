package dao;

import entities.Player;
import entities.Statistics;
import java.util.HashMap;

public class StatisticsDao {

    HashMap<Player, Statistics> playerStatistics = new HashMap();

    public StatisticsDao() {
    }

    public Statistics readStatistics(Player player) {
        return playerStatistics.get(player);
    }

    public void newStatistics(Player player, Statistics statistics) {
        playerStatistics.put(player, statistics);
    }

    public void updateStatistics(Player player, int result) {
        Statistics score = playerStatistics.get(player);
        score.game();

        switch (result) {
            case 0:
                score.loss();
                break;
            case 1:
                score.win();
                break;
            default:
                score.tie();
                break;
        }
    }
}