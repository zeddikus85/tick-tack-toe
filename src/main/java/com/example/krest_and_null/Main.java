package com.example.krest_and_null;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        Player player = new Player();
        Game game = new Game();
        List<String> currentField = field.newField;

        System.out.println("Start game:");
        while (true) {
            game.moveCounter++;
            field.printField(currentField);
            Coordinates newCoordinates = player.enterСoordinates();
            field.saveMove(currentField, newCoordinates, game.identifyPlayer(game.moveCounter));
        }

    }
}
