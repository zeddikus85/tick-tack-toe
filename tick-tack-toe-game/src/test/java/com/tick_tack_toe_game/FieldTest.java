package com.tick_tack_toe_game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void makeMoveTest() {
        Field field = new Field(3);
        Coordinates coordinates = new Coordinates(1, 1);
        Player player = new Player("X", "TestName");
        field.makeMove(coordinates, player.getPlayerSymbol());
        assertEquals(player.getPlayerSymbol(), field.getCurrentField()[1][1]);
    }

    @Test
    void tryMakeMoveToPlaceOccupiedByAnotherPlayer() {
        Field field = new Field(3);
        Coordinates coordinates = new Coordinates(1, 1);
        Player playerX = new Player("X", "PlayerX");
        Player player0 = new Player("0", "Player0");
        field.makeMove(coordinates, playerX.getPlayerSymbol());
        field.makeMove(coordinates, player0.getPlayerSymbol());
        assertEquals(playerX.getPlayerSymbol(), field.getCurrentField()[1][1]);
    }

    @Test
    void tryMakeMoveToPlaceOccupiedByCurrentPlayer() {
        Field field = new Field(3);
        Coordinates coordinates = new Coordinates(1, 1);
        Player playerX = new Player("X", "PlayerX");
        field.makeMove(coordinates, playerX.getPlayerSymbol());
        field.makeMove(coordinates, playerX.getPlayerSymbol());

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> field.makeMove(coordinates, playerX.getPlayerSymbol()),
                "Exception expected when cell is busy!"
        );

        assertEquals("The cell is already occupied!", exception.getMessage());
    }

}