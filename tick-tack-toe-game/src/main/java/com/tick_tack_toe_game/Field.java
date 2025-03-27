package com.tick_tack_toe_game;

public class Field {
    public String[][] currentField;
    public int sideLength;

    public Field(int sideLength) {
        this.currentField = new String[sideLength][sideLength];
        this.sideLength = sideLength;
        for (int i = 0; i < currentField.length; i++) {
            for (int j = 0; j < currentField[i].length; j++) {
                currentField[i][j] = ".";
            }
        }
    }

    public void addMove(Coordinates coordinates, String currentPlayer) {
        this.currentField[coordinates.row][coordinates.column] = currentPlayer;
    }

}
