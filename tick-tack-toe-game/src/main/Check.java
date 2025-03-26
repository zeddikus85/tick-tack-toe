package main;

import static main.Main.currentPlayer;
import static main.Main.field;

public class Check {
    private static int winCount;

    public static boolean checkForWin(Coordinates newMove) {
        return checkRow(newMove) || checkColumn(newMove) || checkAllDiagonal(newMove);
    }

    private static boolean checkRow(Coordinates coordinates) {
        int count = 0;
        winCount = getWinCount();

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

    private static boolean checkColumn(Coordinates coordinates) {
        int count = 0;
        winCount = getWinCount();

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

    public static boolean checkAllDiagonal(Coordinates coordinates) {
        return checkDiagonalOne(coordinates) || checkDiagonalTwo(coordinates);
    }

    private static boolean checkDiagonalOne(Coordinates coordinates) {
        int count = 0;
        winCount = getWinCount();
        int row = coordinates.row - winCount;
        int col = coordinates.column - winCount;

        for (int i = 0; i <= winCount * 2; i++) {
            int currentRow = row + i;
            int currentCol = col + i;
            if (isValidPosition(currentRow, currentCol)) {
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

    private static boolean checkDiagonalTwo(Coordinates coordinates) {
        int count = 0;
        winCount = getWinCount();
        int row = coordinates.row - winCount;
        int col = coordinates.column + winCount;

        for (int i = 0; i <= winCount * 2; i++) {
            int currentRow = row + i;
            int currentCol = col - i;
            if (isValidPosition(currentRow, currentCol)) {
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

    private static int getWinCount() {
        if (field.sideLength == 3) {
            winCount = 3;
        }
        if (field.sideLength == 4) {
            winCount = 4;
        }
        if (field.sideLength >= 5) {
            winCount = 5;
        }
        return winCount;
    }

    private static boolean isValidPosition(int row, int col) {
        return row >= 0 && row < field.sideLength &&
                col >= 0 && col < field.sideLength;
    }

}
