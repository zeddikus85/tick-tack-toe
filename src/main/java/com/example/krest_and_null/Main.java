package com.example.krest_and_null;

import com.example.krest_and_null.data.Field;
import com.example.krest_and_null.data.Players;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean gameOn = true;
        Field field = new Field();
        String currentPlayer = Players.PLAYER1.getPlayersType();

        System.out.println("Start game!");

        while (gameOn) {
            System.out.println("Player " + currentPlayer + " move.");
            printField(field);

            field = new Field(field, readCoordinates(), currentPlayer);

            if (Objects.equals(currentPlayer, Players.PLAYER1.getPlayersType())) {
                currentPlayer = Players.PLAYER2.getPlayersType();
            } else {
                currentPlayer = Players.PLAYER1.getPlayersType();
            }
        }

    }

    public static Coordinates readCoordinates() {
        System.out.print("Entered coordinate X: ");
        int coordinateX = scanner.nextInt();

        System.out.print("Entered coordinate Y: ");
        int coordinateY = scanner.nextInt();

        return new Coordinates(coordinateX, coordinateY);
    }

    public static void printField(Field field){
        System.out.println("  1 2 3 X");
        for (int i = 0; i < field.conditionField.size(); i++) {
            if (i == 0) {
                System.out.print("1 ");
            }
            if (i == 3) {
                System.out.print("2 ");
            }
            if (i == 6) {
                System.out.print("3 ");
            }
            if (i == 2 || i == 5 || i == 8 ) {
                System.out.println(field.conditionField.get(i) + " ");
            } else {
                System.out.print(field.conditionField.get(i) + " ");
            }
        }
        System.out.println("Y");
    }

}
