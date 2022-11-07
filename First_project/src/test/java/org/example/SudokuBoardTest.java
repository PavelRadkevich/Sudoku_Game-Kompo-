package org.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuBoardTest {

    @Test
    public void testSetCell () throws IndexOutRange {
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
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
    public void testCheckBoard() throws IndexOutRange {
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
        board.solveGame();
        try {
            Method m = SudokuBoard.class.getDeclaredMethod("checkBoard");
            m.setAccessible(true);
            assertTrue((Boolean) m.invoke(board));



        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testCheckBoardFalse() throws IndexOutRange {
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
        board.solveGame();
        try {
            Method m = SudokuBoard.class.getDeclaredMethod("checkBoard");
            m.setAccessible(true);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board.setCell(i, j, 1);
                    board.updateBoard();
                    assertFalse((Boolean) m.invoke(board));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetColumn() throws IndexOutRange, NullValue {
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
        board.solveGame();
        String str = "";
        for (int i = 0; i < 9; i++) {
            str = str + board.getCell(i, 0) + " ";
        }
        assertEquals(str,board.getColumn(0).toString());
    }

    @Test
    void testGetRow() throws IndexOutRange, NullValue {
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
        board.solveGame();
        String str = "";
        for (int i = 0; i < 9; i++) {
            str = str + board.getCell(0, i) + " ";
        }
        assertEquals(str,board.getRow(0).toString());
    }

    @Test
    void testGetbox() throws IndexOutRange, NullValue {
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
        board.solveGame();
        String str = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                str = str + board.getCell(i, j) + " ";
            }
        }
        assertEquals(str,board.getBox(0, 0).toString());
    }

    @Test
    public void GateOutOfRange() {
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
        assertEquals(board.getCell(-3,3), 0);
        assertEquals(board.getCell(4,-8), 0);
        assertEquals(board.getCell(13,3), 0);
        assertEquals(board.getCell(3,44), 0);
    }

    @Test
    void testNullValue() {
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
        try {
            board.getColumn(0);
        }
        catch (NullValue exp) {
            System.out.println(exp);
        }
        try {
            board.getBox(0,0);
        }
        catch (NullValue exp) {
            System.out.println(exp);
        }
        try {
            board.getRow(0);
        }
        catch (NullValue exp) {
            System.out.println(exp);
        }
    }

    @Test
    public void testIndex() {
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
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
