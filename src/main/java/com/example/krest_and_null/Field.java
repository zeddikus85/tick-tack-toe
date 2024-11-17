package com.example.krest_and_null;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Field {
    final List<String> newField = new ArrayList<>(Arrays.asList(" ", "1", "2", "3", "1", ".", ".", ".", "2", ".", ".", ".", "3", ".", ".", "."));

    public void printField(List<String> field) {
        for (int i = 0; i < field.size(); i++){
            if (i == 3 || i == 7 || i == 11 || i == 15) {
                System.out.println(field.get(i) + " ");
            } else{
                System.out.print(field.get(i) + " ");
            }
        }
    }

    public List<String> saveMove(List<String> field, Coordinates newCoordinates, String player) {
        field.set(newCoordinates.coordinatesX + 1 + (newCoordinates.getCoordinatesY() * 4)-1 , player);
        return field;
    }
}
