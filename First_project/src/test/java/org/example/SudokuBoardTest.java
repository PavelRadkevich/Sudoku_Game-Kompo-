package org.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuBoardTest {

    public SudokuBoardTest() {
    }
    /*@Test
    public void testFillBoard() {
        SudokuBoard board1 = new SudokuBoard();
        SudokuBoard board2 = new SudokuBoard();
        board1.fillBoard();
        board2.fillBoard();
        int match = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board1.getCell(i, j) ==board2.getCell(i, j)) {
                        match++;
                    }
                }
            }
        assertNotEquals(81, match);
    }

   /* @Test
    public void testNotRepeat() {
        SudokuBoard board = new SudokuBoard();
        board.fillBoard();
        int match = 0;
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    for (int i = 0; i < 9; i++) {
                        if (board.getCell(i, y) == board.getCell(x,y)) {
                            match++;
                            if (i == x) {
                                match--;
                            }
                        }
                    }
                    for (int i = 0; i < 9; i++) {
                        if (board.getCell(x, i) == board.getCell(x,y)) {
                            match++;
                            if (i == y) {
                                match--;
                            }
                        }
                    }
                    for (int i = 0; i <= 2; i++) {
                        for (int j = 0; j <= 2; j++) {
                            if (board.getCell(i + x - x % 3, j + y - y % 3) == board.getCell(x,y)) {
                                match++;
                                if (i + x - x % 3 == x && j + y - y % 3 != y) {
                                    match--;
                                }
                            }
                        }
                    }
                }
            }
        assertEquals(0, match);
    }
    @Test
    public void testSumOfColumns() {
        SudokuBoard board = new SudokuBoard();
        board.fillBoard();
        int sum = 0;

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sum = sum + board.getCell(i, j);
                }
                assertEquals(45, sum);
                sum = 0;
            }
    }

    @Test
    public void testSumOfRows() {
        SudokuBoard board = new SudokuBoard();
        board.fillBoard();
        int sum = 0;

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sum = sum + board.getCell(j, i);
                }
                assertEquals(45, sum);
                sum = 0;
            }
    }*/

    @Test
    public void testFillBoard() {
        SudokuBoard board1 = new SudokuBoard();
        SudokuBoard board2 = new SudokuBoard();
        board1.fillBoard();
        board2.fillBoard();
        int match = 0;
        try {
            Method m = SudokuBoard.class.getDeclaredMethod("getCell", int.class, int.class);
            m.setAccessible(true);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (m.invoke(board1, i, j) == m.invoke(board2, i, j)) {
                        match++;
                    }
                }
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        assertNotEquals(81, match);
    }

    @Test
    public void testNotRepeat() {
        SudokuBoard board = new SudokuBoard();
        board.fillBoard();
        int match = 0;
        try {
            Method m = SudokuBoard.class.getDeclaredMethod("getCell", int.class, int.class);
            m.setAccessible(true);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    for (int x = 0; x < 9; x++) {
                        if (m.invoke(board, i, j) == m.invoke(board, i, x)) {
                            if (x != j) {
                                match++;
                            }
                        }
                        if (m.invoke(board, j, i) == m.invoke(board, x, i)) {
                            if (x != j) {
                                match++;
                            }
                        }
                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        assertEquals(0, match);
    }

    @Test
    public void testSumOfColumns() {
        SudokuBoard board = new SudokuBoard();
        board.fillBoard();
        int sum = 0;
        try {
            Method m = SudokuBoard.class.getDeclaredMethod("getCell", int.class, int.class);
            m.setAccessible(true);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int cell = (int) m.invoke(board, i, j);
                    sum += cell;
                }
                assertEquals(45, sum);
                sum = 0;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSumOfRows() {
        SudokuBoard board = new SudokuBoard();
        board.fillBoard();
        int sum = 0;
        try {
            Method m = SudokuBoard.class.getDeclaredMethod("getCell", int.class, int.class);
            m.setAccessible(true);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int cell = (int) m.invoke(board, j, i);
                    sum = sum + cell;
                }
                assertEquals(45, sum);
                sum = 0;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRepeatInBox() {
        SudokuBoard board = new SudokuBoard();
        board.fillBoard();
        int match = 0;
        try {
            Method m = SudokuBoard.class.getDeclaredMethod("getCell", int.class, int.class);
            m.setAccessible(true);
            for (int x = 0; x < 9; x++ ) {
                for (int y = 0; y < 9; y++) {
                    for (int i = 0; i <= 2; i++) {
                        for (int j = 0; j <= 2; j++) {
                            if (m.invoke(i + x - x % 3, j + y - y % 3) == m.invoke(x, y)) {
                                if((i + x - x % 3) != x && (j + y - y % 3) != y) {
                                    match++;
                                }
                            }
                        }
                    }
                }
            }
                    assertEquals(0, match);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}