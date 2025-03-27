package com.tick_tack_toe_game;

public class Utils {

    public static Coordinates convertToMassivCoordinates(Coordinates coordinates) {
        return new Coordinates(coordinates.row - 1, coordinates.column - 1);
    }

    public static int getWinCount(Field field) {
        if (field.sideLength == 4) {
            return 4;
        }
        if (field.sideLength >= 5) {
            return 5;
        }
        return 3;
    }

}
