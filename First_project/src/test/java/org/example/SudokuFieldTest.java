package org.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SudokuFieldTest {
    @Test
    public void getTest() {
        ArrayList<SudokuField> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(i, new SudokuField());
            fields.get(i).setFieldValue(i + 1);
        }
        SudokuRow row = new SudokuRow(fields);
        SudokuColumn column = new SudokuColumn(fields);
        SudokuBox box = new SudokuBox(fields);
        for (int i = 0; i < 9; i++) {
            fields.get(i).setRow(row);
            fields.get(i).setBox(box);
            fields.get(i).setColumn(column);
            assertEquals(row, fields.get(i).getRow());
            assertEquals(column, fields.get(i).getColumn());
            assertEquals(box, fields.get(i).getBox());
        }
    }


    @Test
    public void testEquals() throws IndexOutRange, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getField = SudokuBoard.class.getDeclaredMethod("getField", int.class, int.class);
        getField.setAccessible(true);
        SudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(bs);
        SudokuBoard board1 = new SudokuBoard(bs);
        for (int i = 0; i < 9; i++) {
            board.setCell(1, 1, i);
            board1.setCell(1, 1, i);
        }
        assertTrue(getField.invoke(board, 1, 1).equals(getField.invoke(board1, 1, 1)));
        assertFalse(getField.invoke(board, 1, 1).equals(null));
        assertFalse(getField.invoke(board, 1, 1).equals(bs));

    }
}
