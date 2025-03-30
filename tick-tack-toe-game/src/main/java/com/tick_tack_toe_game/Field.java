package com.tick_tack_toe_game;

import java.util.Arrays;

public final class Field {
    public static final String EMPTY_CELL = ".";
    private final String[][] currentField;
    private final int size;

    public Field(int size) {
        this.currentField = new String[size][size];
        this.size = size;
        for (String[] row : currentField) {
            Arrays.fill(row, EMPTY_CELL);
        }
    }

    public void makeMove(Coordinates coordinates, String playerType) {
        this.currentField[coordinates.getRow()][coordinates.getColumn()] = playerType;
    }

    public int getSize() {
        return this.size;
    }

    public String[][] getCurrentField() {
        return Arrays.stream(currentField)
                .map(String[]::clone)
                .toArray(String[][]::new);
    }

    public boolean validateCellIsEmpty(Coordinates coordinates) {
        return EMPTY_CELL.equals(getCell(coordinates));
    }

    private String getCell(Coordinates coordinates) {
        return currentField[coordinates.getRow()][coordinates.getColumn()];
    }

}
