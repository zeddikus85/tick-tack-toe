package com.tick_tack_toe_game;

public class Utils {

    public static Coordinates convertToMassivCoordinates(Coordinates coordinates) {
        return new Coordinates(coordinates.getRow() - 1, coordinates.getColumn() - 1);
    }

    public static int getWinCount(Field field) {
        if (field.getSize() == 4) {
            return 4;
        }
        if (field.getSize() >= 5) {
            return 5;
        }
        return 3;
    }

}
