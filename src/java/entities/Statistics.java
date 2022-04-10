package entities;

import java.io.Serializable;

public class Statistics implements Serializable {

    int games, wins, losses, ties;

    public Statistics() {
        this.games = 0;
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
    }

    public void game() {
        games++;
    }

    public void win() {
        wins++;
    }

    public void loss() {
        losses++;
    }

    public void tie() {
        ties++;
    }

    public int getGames() {
        return games;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTies() {
        return ties;
    }
}