package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuBoardTest {

    @Test
    public void testSetCell () {
        SudokuBoard board = new SudokuBoard();
        board.setCell(1,1, 5);
        assertEquals(board.getCell(1, 1), 5);
        board.setCell(2, 2, -1);
        assertEquals(board.getCell(2, 2), 0);
        board.setCell(3,3,10);
        assertEquals(board.getCell(3, 3), 10);
    }
}
