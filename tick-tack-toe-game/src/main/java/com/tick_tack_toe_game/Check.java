package com.tick_tack_toe_game;

import static com.tick_tack_toe_game.Utils.getWinCount;

public class Check {

    public static boolean checkForWin(Coordinates newMove, Player currentPlayer, Field field) {
        int winCount = getWinCount(field);
        return checkRow(newMove, currentPlayer, field, winCount)
                || checkColumn(newMove, currentPlayer, field, winCount)
                || checkDiagonalOne(newMove, currentPlayer, field, winCount)
                || checkDiagonalTwo(newMove, currentPlayer, field, winCount);
    }

    private static boolean checkRow(Coordinates coordinates, Player currentPlayer, Field field, int winCount) {
        int count = 0;

        for (int i = coordinates.getColumn() - winCount; i < coordinates.getColumn() + winCount; i++) {
            if (i >= 0 && i < field.getSize()) {
                if (field.getCurrentField()[coordinates.getRow()][i].equals(currentPlayer.getPlayerSymbol())) {
                    count++;
                    if (count == winCount) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private static boolean checkColumn(Coordinates coordinates, Player currentPlayer, Field field, int winCount) {
        int count = 0;

        for (int i = coordinates.getRow() - winCount; i < coordinates.getRow() + winCount; i++) {
            if (i >= 0 && i < field.getSize()) {
                if (field.getCurrentField()[i][coordinates.getColumn()].equals(currentPlayer.getPlayerSymbol())) {
                    count++;
                    if (count == winCount) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private static boolean checkDiagonalOne(Coordinates newMove, Player currentPlayer, Field field, int winCount) {
        int count = 0;
        int row = newMove.getRow() - winCount;
        int col = newMove.getColumn() - winCount;

        for (int i = 0; i <= winCount * 2; i++) {
            int currentRow = row + i;
            int currentCol = col + i;
            if (isValidPosition(currentRow, currentCol, field)) {
                if (field.getCurrentField()[currentRow][currentCol].equals(currentPlayer.getPlayerSymbol())) {
                    count++;
                    if (count == winCount) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean checkDiagonalTwo(Coordinates newMove, Player currentPlayer, Field field, int winCount) {
        int count = 0;
        int row = newMove.getRow() - winCount;
        int col = newMove.getColumn() + winCount;

        for (int i = 0; i <= winCount * 2; i++) {
            int currentRow = row + i;
            int currentCol = col - i;
            if (isValidPosition(currentRow, currentCol, field)) {
                if (field.getCurrentField()[currentRow][currentCol].equals(currentPlayer.getPlayerSymbol())) {
                    count++;
                    if (count == winCount) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean isValidPosition(int row, int col, Field field) {
        return row >= 0 && row < field.getSize() &&
                col >= 0 && col < field.getSize();
    }

    public static boolean checkForDraw(Field field) {
        for (int i = 0; i < field.getSize(); i++) {
            for (int y = 0; y < field.getSize(); y++) {
                if (field.getCurrentField()[i][y].equals(".")) {
                    return false;
                }
            }
        }
        return true;
    }
}
