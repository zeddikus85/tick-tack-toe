package main;

import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    public static int fieldLength() {
        System.out.print("Enter the field length: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getPlayerName(String player) {
        System.out.print("Enter name for " + player + ": ");
        return scanner.nextLine();
    }

    public static Coordinates nextMove() {
        System.out.print("Enter row number: ");
        int row = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter colum number: ");
        int colum = Integer.parseInt(scanner.nextLine());
        return new Coordinates(row, colum);
    }
}
