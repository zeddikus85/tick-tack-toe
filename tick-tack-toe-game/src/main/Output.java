package main;

import static main.Main.player;

public class Output {

    public static void printPrepare() {
        System.out.println("Setting up the game");
        System.out.println("First you need to specify the field length");
    }

    public static void printStartGame() {
        System.out.println("Starting a new game!!!");
    }

    public static void printField(String[][] field) {
        for (String[] strings : field) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public static void printCurrentPlayerMove() {
        System.out.println("Player " + player.currentPlayer + " move");
    }

}
