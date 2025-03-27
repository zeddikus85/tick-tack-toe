package com.tick_tack_toe_game;

public class Utils {

    public static Coordinates convertToMassivCoordinates(Coordinates coordinates) {
        return new Coordinates(coordinates.row - 1, coordinates.column - 1);
    }

    public static int getWinCount(Field field) {
        if (field.getSideLength() == 4) {
            return 4;
        }
        if (field.getSideLength() >= 5) {
            return 5;
        }
        return 3;
    }

}
