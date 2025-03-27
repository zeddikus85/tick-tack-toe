package com.tick_tack_toe_game;

public class Player {

    String playerSymbol;
    String playerName;

    public Player(String symbol, String name) {
        this.playerSymbol = symbol;
        this.playerName = name;
    }

    public String getPlayerSymbol() {
        return this.playerSymbol;
    }

    public String getPlayerName() {
        return this.playerName;
    }
}
