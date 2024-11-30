package com.example.krest_and_null.data;

import com.example.krest_and_null.Coordinates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Field {
    public List<String> conditionField = new ArrayList<>(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", "."));

    public Field() {
    }

    public Field(Field field, Coordinates readCoordinates, String currentPlayer) {
        this.conditionField = field.conditionField;
        this.conditionField.set(readCoordinates.getCoordinatesX() - 1 + (readCoordinates.getCoordinatesY() - 1) *3, currentPlayer);
    }

}
