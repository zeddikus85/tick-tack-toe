package com.example.krest_and_null;

public class Game {
    public int moveCounter;

    public String identifyPlayer(int moveCounter) {
        if (moveCounter % 2 == 0) {
            return "O";
        } else {
            return "X";
        }
    }
}
