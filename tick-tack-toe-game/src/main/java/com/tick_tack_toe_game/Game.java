package com.tick_tack_toe_game;

public final class Game {
    private static final String PLAYER_X_SYMBOL = "X";
    private static final String PLAYER_0_SYMBOL = "0";

    private Game () {}

    public static void start() {
        try {
            initializeGame();
        } finally {
            Input.closeResources();
        }
    }

    private static void initializeGame() {
        Output.printGameIntroduction();

        Field field = createGameField();
        Player[] players = registerPlayer();

        playGame(field, players);
    }

    private static Field createGameField() {
        int size = Input.requestFieldLength();
        return new Field(size);
    }

    private static Player[] registerPlayer() {
        return new Player[] {
                createPlayer(PLAYER_X_SYMBOL),
                createPlayer(PLAYER_0_SYMBOL)
        };
    }

    private static Player createPlayer(String playerSymbol) {
        String playerName = Input.requestPlayerName(playerSymbol);
        return new Player(playerSymbol, playerName);
    }

    private static void playGame(Field field, Player[] players) {
        Output.printStartGame();
        Output.printField(field.getCurrentField());

        int currentPlayerIndex = 0;
        boolean gameOver = false;

        while (!gameOver) {
            gameOver = playTurn(field, players[currentPlayerIndex]);
            currentPlayerIndex = changePlayerIndex(currentPlayerIndex);
        }
    }

    private static boolean playTurn(Field field, Player player) {
        Output.printCurrentPlayerTurn(player.getPlayerName());
        Coordinates currentMoveCoordinates = Utils.convertToMassivCoordinates(Input.requestNextMove(field));
        field.makeMove(currentMoveCoordinates, player.getPlayerSymbol());
        Output.printField(field.getCurrentField());

        if (Check.checkForWin(currentMoveCoordinates, player, field)) {
            System.out.printf("!!! Player '%s' win !!!%n", player.getPlayerName());
            return true;
        }

        if (Check.checkForDraw(field)) {
            System.out.println("The field is completely full, draw!");
            return true;
        }

        return false;
    }

    private static int changePlayerIndex(int currentPlayerIndex) {
        if (currentPlayerIndex == 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
