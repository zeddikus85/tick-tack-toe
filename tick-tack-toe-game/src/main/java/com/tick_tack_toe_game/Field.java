package com.tick_tack_toe_game;

import java.util.Arrays;

public class Field {
    private final String[][] currentField;
    private final int sideLength;

    public Field(int sideLength) {
        this.currentField = new String[sideLength][sideLength];
        this.sideLength = sideLength;
        for (String[] strings : currentField) {
            Arrays.fill(strings, ".");
        }
    }

    public void addMove(Coordinates coordinates, String currentPlayer) {
        this.currentField[coordinates.row][coordinates.column] = currentPlayer;
    }

    public int getSideLength() {
        return this.sideLength;
    }

    public String[][] getCurrentField() {
        return this.currentField;
    }

}
