package main;

import static main.Main.field;
import static main.Main.player;

public class Сheck {
    // Да это залипуха. Поидее на поле больше 3x3 кол-во для победы должно отличаться
    // не продумал ещё этот момент
    private static final int WIN_COUNT = 3;

    public static boolean checkForWin(Coordinates newMove) {
        if (checkAllDiagonal()) {
            return true;
        }
        return checkRow(newMove.row) || checkColumn(newMove.column);
    }

    private static boolean checkRow(int row) {
        int count = 0;
        for (int i = 0; i < field.sideLength - 1; i++) {
            if (field.currentField[row][i].equals(player.currentPlayer)) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    private static boolean checkColumn(int column) {
        int count = 0;
        for (int i = 0; i < field.sideLength - 1; i++) {
            if (field.currentField[i][column].equals(player.currentPlayer)) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    public static boolean checkAllDiagonal() {
        for (int row = 0; row <= field.sideLength - 3; row++) {
            for (int col = 0; col <= field.sideLength - 3; col++) {
                if (field.currentField[row][col].equals(player.currentPlayer)) {
                    boolean match = true;
                    for (int i = 1; i < 3; i++) {
                        if (!field.currentField[row][col].equals(field.currentField[row + i][col + i])) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        return true;
                    }
                }
            }
        }

        for (int row = WIN_COUNT - 1; row < WIN_COUNT; row++) {
            for (int col = 0; col <= field.sideLength - WIN_COUNT; col++) {
                if (field.currentField[row][col].equals(player.currentPlayer)) {
                    boolean match = true;
                    for (int i = 1; i < WIN_COUNT; i++) {
                        if (!field.currentField[row][col].equals(field.currentField[row - i][col + i])) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
