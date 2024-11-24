package com.example.krest_and_null;

import com.example.krest_and_null.data.Field;
import com.example.krest_and_null.data.Players;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List field = Field.field;
    static String currentPlayer = Players.Players1;

    public static void main(String[] args) {
        System.out.println("Start game!");

        while (true) {
            System.out.println("Player " + currentPlayer + " move.");
            saveMove(field, readCoordinates(), currentPlayer);
            printCurrentField(field);
            if (currentPlayer == Players.Players1) {
                currentPlayer = Players.Players2;
            } else {
                currentPlayer = Players.Players1;
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

    public static List<String> saveMove(List<String> field, Coordinates newCoordinates, String currentPlayer) {
        field.set(newCoordinates.coordinatesX - 1 + (newCoordinates.getCoordinatesY() - 1) * 3, currentPlayer);
        return field;
    }

    public static void printCurrentField(List<String> field){
        System.out.println("  1 2 3 X");
        for (int i = 0; i < field.size(); i++) {
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
                System.out.println(field.get(i));
            } else {
                System.out.print(field.get(i));
            }
        }
        System.out.println("Y");
    }

}
