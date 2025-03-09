package main;

public class Utils {

    public static Coordinates convertToMassivCoordinates(Coordinates coordinates) {
        return new Coordinates(coordinates.row - 1, coordinates.column - 1);
    }

}
