package com.example.krest_and_null.data;

public enum Players {
    PLAYER1("Player1", "X"),
    PLAYER2("Player2", "0");

    private final String playersID;
    private final String playersType;

    Players(String playersID, String playersType) {
        this.playersID = playersID;
        this.playersType = playersType;
    }

    public String getPlayersID() {
        return playersID;
    }

    public String getPlayersType() {
        return playersType;
    }

}
