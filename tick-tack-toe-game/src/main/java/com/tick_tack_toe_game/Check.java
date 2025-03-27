package com.tick_tack_toe_game;

import static com.tick_tack_toe_game.Utils.getWinCount;

public class Check {
    private static int winCount;

    public static boolean checkForWin(Coordinates newMove, Player currentPlayer, Field field) {
        int winCount = getWinCount(field);
        return checkRow(newMove, currentPlayer, field, winCount)
                || checkColumn(newMove, currentPlayer, field, winCount)
                || checkDiagonalOne(newMove, currentPlayer, field, winCount)
                || checkDiagonalTwo(newMove, currentPlayer, field, winCount);
    }

    private static boolean checkRow(Coordinates coordinates, Player currentPlayer, Field field, int winCount) {
        int count = 0;

        for (int i = coordinates.column - winCount; i < coordinates.column + winCount; i++) {
            if (i >= 0 && i < field.sideLength) {
                if (field.currentField[coordinates.row][i].equals(currentPlayer.getPlayerSymbol())) {
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

        for (int i = coordinates.row - winCount; i < coordinates.row + winCount; i++) {
            if (i >= 0 && i < field.sideLength) {
                if (field.currentField[i][coordinates.column].equals(currentPlayer.getPlayerSymbol())) {
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
        int row = newMove.row - winCount;
        int col = newMove.column - winCount;

        for (int i = 0; i <= winCount * 2; i++) {
            int currentRow = row + i;
            int currentCol = col + i;
            if (isValidPosition(currentRow, currentCol, field)) {
                if (field.currentField[currentRow][currentCol].equals(currentPlayer.getPlayerSymbol())) {
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
        int row = newMove.row - winCount;
        int col = newMove.column + winCount;

        for (int i = 0; i <= winCount * 2; i++) {
            int currentRow = row + i;
            int currentCol = col - i;
            if (isValidPosition(currentRow, currentCol, field)) {
                if (field.currentField[currentRow][currentCol].equals(currentPlayer.getPlayerSymbol())) {
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
        return row >= 0 && row < field.sideLength &&
                col >= 0 && col < field.sideLength;
    }

}
