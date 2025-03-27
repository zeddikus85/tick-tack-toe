package com.tick_tack_toe_game;

import static com.tick_tack_toe_game.Check.*;

public class Main {
    static boolean gameOver = true;
    static Field field;
    static Player playerX;
    static Player player0;
    static Player currentPlayer;
    static String playerName;
    static Coordinates currentMoveCoordinates;

    public static void main(String[] args) {
        Output.printPrepare();

        int fieldLength = Input.fieldLength();
        field = new Field(fieldLength);

        playerName = Input.getPlayerName("X");
        playerX = new Player("X", playerName);
        playerName = Input.getPlayerName("0");
        player0 = new Player("0", playerName);

        currentPlayer = playerX;

        Output.printStartGame();
        Output.printField(field.currentField);

        while (gameOver) {
            Output.printCurrentPlayerMove(currentPlayer.playerName);
            currentMoveCoordinates = Utils.convertToMassivCoordinates(Input.nextMove());
            field.addMove(currentMoveCoordinates, currentPlayer.getPlayerSymbol());
            Output.printField(field.currentField);

            if (Check.checkForWin(currentMoveCoordinates)) {
                gameOver = false;
                System.out.println("!!! Player '" + currentPlayer.playerName + "' win !!!");
            }

            if (currentPlayer == playerX) {
                currentPlayer = player0;
            } else {
                currentPlayer = playerX;
            }
        }

    }

}
