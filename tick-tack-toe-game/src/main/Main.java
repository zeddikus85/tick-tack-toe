package main;

import static main.Сheck.checkForWin;

public class Main {
    static boolean gameOver = true;
    static Field field;
    static Player player = new Player();
    static Coordinates currentMoveCoordinates;

    public static void main(String[] args) {
        Output.printPrepare();

        int fieldLength = Input.fieldLength();
        field = new Field(fieldLength);

        Output.printStartGame();
        Output.printField(field.currentField);

        while (gameOver) {
            Output.printCurrentPlayerMove();
            currentMoveCoordinates = Utils.convertToMassivCoordinates(Input.nextMove());
            field.addMove(currentMoveCoordinates, player.currentPlayer);

            if (checkForWin(currentMoveCoordinates)) {
                gameOver = false;
                System.out.println("!!! Player '" + player.currentPlayer + "' win !!!");
            }
            player.changePlayer();

            Output.printField(field.currentField);
        }

    }

}
