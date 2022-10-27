package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuBoardTest {

    @Test
    public void testSetCell () throws IndexOutRange {
        SudokuBoard board = new SudokuBoard();
        for (int x =0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                for (int value = 1; value <= 9; value++) {
                    board.setCell(x,y,value);
                    assertEquals(board.getCell(x, y), value);
                }
            }
        }
        board.setCell(2, 2, -1);
        assertEquals(board.getCell(2, 2), 0);
        board.setCell(3,3,10);
        assertEquals(board.getCell(3, 3), 0);

    }

    @Test
    public void GateOutOfRange() {
        SudokuBoard board = new SudokuBoard();
        assertEquals(board.getCell(-3,3), 0);
        assertEquals(board.getCell(4,-8), 0);
        assertEquals(board.getCell(13,3), 0);
        assertEquals(board.getCell(3,44), 0);
    }

    @Test
    public void testIndex() {
        SudokuBoard board = new SudokuBoard();
        try {
            board.setCell(-3,5,7);
        }
        catch (IndexOutRange IOR) {
            System.out.println(IOR);
        }
        try {
            board.setCell(12,5,8);
        }
        catch (IndexOutRange IOR) {
            System.out.println(IOR);
        }
        try {
            board.setCell(3,-8,21);
        }
        catch (IndexOutRange IOR) {
            System.out.println(IOR);
        }
        try {
            board.setCell(3,30,3);
        }
        catch (IndexOutRange IOR) {
            System.out.println(IOR);
        }

    }
}
