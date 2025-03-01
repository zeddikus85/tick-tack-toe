package main;

import java.util.Scanner;

public class Main {
    static String player;
    static boolean gameOver = true;
    static Field field;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the field length: ");
        int fieldLength = Integer.parseInt(scanner.nextLine());
        field = new Field(fieldLength);
        field.printField();

        for (int i = 0; gameOver; i++) {
            player = changePlayer();
            System.out.println("Player '" + player + "'");
            System.out.print("Enter row number: ");
            int row = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter colum number: ");
            int colum = Integer.parseInt(scanner.nextLine());
            field.currentField[row-1][colum-1] = player;
            if (checkForWin(row, colum)) {
                gameOver = false;
                System.out.println("!!! Player '" + player + "' win !!!");
            }
            field.printField();
        }


        scanner.close();
    }

    private static String changePlayer() {
        if (player == null || player.equals("0")) {
            return player = "X";
        } else {
            return player = "0";
        }
    }

    private static boolean checkForWin(int row, int column) {
        if (checkAllDiagonal()) {
            return true;
        }
        return checkRow(row) || checkColumn(column);
    }

    private static boolean checkRow(int row) {
        for (int i = 0; i < field.sideLength-2; i++)
            if (field.currentField[row-1][i].equals(player) &&
                    field.currentField[row-1][i+1].equals(player) &&
                    field.currentField[row-1][i+2].equals(player))
            {
                return true;
            }
        return false;
    }

    private static boolean checkColumn(int column) {
        for (int i = 0; i < field.sideLength-2; i++)
            if (field.currentField[i][column-1].equals(player) &&
                    field.currentField[i+1][column-1].equals(player) &&
                    field.currentField[i+2][column-1].equals(player))
            {
                return true;
            }
        return false;
    }

    public static boolean checkAllDiagonal() {
        // Проверка диагоналей, идущих слева направо
        int indexMaxRowOrColumn = field.sideLength;
        for (int row = 0; row < indexMaxRowOrColumn; row++) {
            if (checkDiagonal(row, 0)) {
                return true;
            }
        }
        for (int col = 1; col < indexMaxRowOrColumn; col++) {
            if (checkDiagonal(0, col)) {
                return true;
            }
        }

        // Проверка диагоналей, идущих справа налево
        for (int row = 0; row < indexMaxRowOrColumn; row++) {
            if (checkAntiDiagonal(row, indexMaxRowOrColumn - 1)) {
                return true;
            }
        }
        for (int col = indexMaxRowOrColumn - 2; col >= 0; col--) {
            if (checkAntiDiagonal(0, col)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkDiagonal(int startRow, int startCol) {
        int count = 0;
        for (int i = 0; i < field.sideLength - Math.max(startRow, startCol); i++) {
            if (field.currentField[startRow + i][startCol + i].equals(player)) {
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

    private static boolean checkAntiDiagonal(int startRow, int startCol) {
        int count = 0;
        for (int i = 0; i <= Math.min(startRow, startCol); i++) {
            if (field.currentField[startRow - i][startCol - i].equals(player)) {
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

}
