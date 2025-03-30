package com.tick_tack_toe_game;

public final class Coordinates {
    private final int row;
    private final int column;

    Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
