package com.tick_tack_toe_game;

import java.util.Scanner;

public final class Input {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int MIN_LENGTH_FIELD = 3;
    private static final int MAX_LENGTH_FIELD = 50;

    private Input() {}

    public static int requestFieldLength() {
        while (true) {
            try {
                System.out.printf("Enter the field length (minimum %d, maximum %d): ", MIN_LENGTH_FIELD, MAX_LENGTH_FIELD);
                int fieldLength = Integer.parseInt(SCANNER.nextLine());
                if (fieldLength >= MIN_LENGTH_FIELD && fieldLength <= MAX_LENGTH_FIELD) {
                    return fieldLength;
                }
                System.err.printf("The field length must be no less than %d and no more than %d%n", MIN_LENGTH_FIELD, MAX_LENGTH_FIELD);
            } catch (NumberFormatException e) {
                System.err.println("Error: Please enter a valid number!");
            }
        }
    }

    public static String requestPlayerName(String playerType) {
        while (true) {
            System.out.printf("Enter name for %s: ", playerType);
            String playerName = SCANNER.nextLine();
            if (!playerName.isEmpty()) {
                return playerName;
            } else {
                System.err.println("Name cannot be empty!");
            }
        }
    }

    public static Coordinates requestNextMove(Field field) {
        int fieldSize = field.getSize();

        while (true) {
            Output.printField(field.getCurrentField());
            System.out.println("Enter your move coordinates:");
            Coordinates coordinates = new Coordinates(
                    requestCoordinate("row", fieldSize, field),
                    requestCoordinate("column", fieldSize, field)
            );
            if (field.validateCellIsEmpty(coordinates)) {
                return coordinates;
            } else {
                System.out.println("Cell is already occupied, try again");
            }
        }
    }

    private static int requestCoordinate(String coordinateType, int fieldLength, Field field) {
        while (true) {
            try {
                System.out.printf("Enter %s 1-%d: ", coordinateType, fieldLength);
                int coordinate = Integer.parseInt(SCANNER.nextLine());
                if (coordinate <= 0 || coordinate > fieldLength) {
                    System.err.printf("Coordinates must be between 1 - %d", fieldLength);
                    Output.printField(field.getCurrentField());
                    continue;
                }

                return coordinate;

            } catch (NumberFormatException e) {
                System.err.println("Error: Please enter integers only!");
                Output.printField(field.getCurrentField());
            }
        }
    }

    public static void closeResources() {
        SCANNER.close();
    }


}
