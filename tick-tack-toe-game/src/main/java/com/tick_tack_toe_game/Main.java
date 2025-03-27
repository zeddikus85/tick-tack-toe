package com.tick_tack_toe_game;

public class Main {

    public static void main(String[] args) {
        Output.printPrepare();

        int fieldLength = Input.fieldLength();
        Field field = new Field(fieldLength);

        String playerName = Input.getPlayerName("X");
        Player playerX = new Player("X", playerName);
        playerName = Input.getPlayerName("0");
        Player player0 = new Player("0", playerName);

        Player currentPlayer = playerX;

        Output.printStartGame();
        Output.printField(field.currentField);

        boolean gameOver = false;
        while (!gameOver) {
            Output.printCurrentPlayerMove(currentPlayer.getPlayerName());
            Coordinates currentMoveCoordinates = Utils.convertToMassivCoordinates(Input.nextMove());
            field.addMove(currentMoveCoordinates, currentPlayer.getPlayerSymbol());
            Output.printField(field.currentField);

            if (Check.checkForWin(currentMoveCoordinates, currentPlayer, field)) {
                gameOver = true;
                System.out.println("!!! Player '" + currentPlayer.getPlayerName() + "' win !!!");
            }

            if (currentPlayer == playerX) {
                currentPlayer = player0;
            } else {
                currentPlayer = playerX;
            }
        }

    }

}
