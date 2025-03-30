package com.tick_tack_toe_game;

public class Output {

    public static void printGameIntroduction() {
        System.out.println("""
        Welcome to the game Tic Tac Toe
            - Setting up the game -
        The number of characters to win depends on the size of the field:
        Length 3 - 3 characters are needed to win
        Length 4 - 4 characters are needed to win
        Length 5 or more - 5 characters are needed to win
        """);
    }

    public static void printStartGame() {
        System.out.println("Starting a new game!!!");
    }

    public static void printField(String[][] field) {
        System.out.print("   ");
        for (int col = 0; col < field.length; col++) {
            System.out.printf("%-2d ", col + 1);
        }
        System.out.println();

        for (int row = 0; row < field.length; row++) {
            System.out.printf("%-2d ", row + 1);
            for (String cell : field[row]) {
                System.out.printf("%-2s ", cell);
            }
            System.out.println();
        }
    }

    public static void printCurrentPlayerTurn(String name) {
        System.out.println("Player " + name + " move");
    }

}
