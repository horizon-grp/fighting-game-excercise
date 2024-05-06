package org.example;

import org.example.types.Mode;

import java.util.ArrayList;

public class Fight {
    private ArrayList<Player> players;
    private boolean gameStatus;
    private Mode mode;

    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void play(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }
    public void pause(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    public boolean isGameStatus() {
        return gameStatus;
    }

    public Mode getMode() {
        return mode;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }
}
