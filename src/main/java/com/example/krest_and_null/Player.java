package com.example.krest_and_null;

import java.util.Scanner;

public class Player {
    public Coordinates enterСoordinates() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entered coordinate X: ");
        int coordinateX = scanner.nextInt();

        System.out.print("Entered coordinate Y: ");
        int coordinateY = scanner.nextInt();

        scanner.close();

        return new Coordinates(coordinateX, coordinateY);
    }
}
