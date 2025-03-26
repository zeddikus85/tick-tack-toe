package main;

public class Output {

    public static void printPrepare() {
        System.out.println("Setting up the game");
        System.out.println("First you need to specify the field length");
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

    public static void printCurrentPlayerMove(String name) {
        System.out.println("Player " + name + " move");
    }

}
