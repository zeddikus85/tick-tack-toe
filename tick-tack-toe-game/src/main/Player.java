package main;

public class Player {

    String currentPlayer = "X";

    public void changePlayer() {
        if (this.currentPlayer.equals("0")) {
            this.currentPlayer = "X";
        } else {
            this.currentPlayer = "0";
        }
    }

}
