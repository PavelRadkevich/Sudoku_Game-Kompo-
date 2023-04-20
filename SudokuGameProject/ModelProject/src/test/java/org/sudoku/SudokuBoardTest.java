package org.sudoku;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sudoku.exception.IndexOutRange;
import org.sudoku.exception.NoAvaibleClone;

import java.lang.reflect.Method;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuBoardTest {
    private final static Logger logger = LoggerFactory.getLogger(SudokuGroupsTest.class);
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
            Method m = SudokuBoard.class.getDeclaredMethod("updateBoard");
            m.setAccessible(true);
            assertTrue((Boolean) m.invoke(board));
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    assertTrue(board.getRow(i).verify());
                    assertTrue(board.getColumn(i).verify());
                    assertTrue(board.getBox(i, j).verify());
                }
            }
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
            Method m = SudokuBoard.class.getDeclaredMethod("updateBoard");
            m.setAccessible(true);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board.setCell(i, j, 1);
                    m.invoke(board);
                    assertFalse((Boolean) m.invoke(board));
                }
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    assertFalse(board.getRow(i).verify());
                    assertFalse(board.getColumn(i).verify());
                    assertFalse(board.getBox(i, j).verify());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetColumn() throws IndexOutRange {
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
        board.solveGame();
        String str = "";
        for (int i = 0; i < 9; i++) {
            str = str + board.getCell(i, 0) + " ";
        }
        assertEquals(str,board.getColumn(0).getFields());
    }

    @Test
    void testGetRow() throws IndexOutRange {
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
        board.solveGame();
        String str = "";
        for (int i = 0; i < 9; i++) {
            str = str + board.getCell(0, i) + " ";
        }
        assertEquals(str,board.getRow(0).getFields());
    }

    @Test
    void testGetbox() throws IndexOutRange {
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
        board.solveGame();
        String str = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                str = str + board.getCell(i, j) + " ";
            }
        }
        assertEquals(str,board.getBox(0, 0).getFields());
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
    public void testIndex() {
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
        try {
            board.setCell(-3,5,7);
        }
        catch (IndexOutRange IOR) {
            logger.warn(IOR.toString());
        }
        try {
            board.setCell(12,5,8);
        }
        catch (IndexOutRange IOR) {
            logger.warn(IOR.toString());
        }
        try {
            board.setCell(3,-8,21);
        }
        catch (IndexOutRange IOR) {
            logger.warn(IOR.toString());
        }
        try {
            board.setCell(3,30,3);
        }
        catch (IndexOutRange IOR) {
            logger.warn(IOR.toString());
        }

    }

    @Test
    void equalsTest() {
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
        assertTrue(board.equals(board));
        SudokuBoard board2 = new SudokuBoard(bs);
        assertTrue(board.equals(board2));
        assertFalse(board.equals(bs));
        bs = null;
        assertFalse(board.equals(bs));
    }

    @Test
    void toStringTest() {
        BackTrackingSudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
        String str = new StringJoiner(", ", SudokuBoard.class.getSimpleName() + "@"
                + Integer.toHexString(board.hashCode()) + "[", "]")
                .add("Solver=" + bs.getClass().getSimpleName() + "@"
                        + Integer.toHexString(bs.hashCode()))
                .toString();
        assertEquals(str, board.toString());
    }

    @Test
    void cloneTest() throws NoAvaibleClone {
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
        SudokuBoard clone = board.clone();
        assertTrue(board.equals(clone));
    }
}
