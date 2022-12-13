package org.sudoku;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuFieldTest {
    @Test
    void equalsTest() {
        SudokuField field = new SudokuField();
        SudokuField field2 = new SudokuField();
        BackTrackingSudokuSolver sb = new BackTrackingSudokuSolver();
        assertTrue(field.equals(field));
        assertTrue(field.equals(field2));
        assertFalse(field.equals(sb));
        field2 = null;
        assertFalse(field.equals(field2));
    }

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
    void toStringTest() {
        SudokuField field = new SudokuField();
        String str = new StringJoiner(", ", SudokuField.class.getSimpleName() + "@"
                + Integer.toHexString(field.hashCode()) + "[", "]")
                .add("value=" + field.getFieldValue())
                .add("column=" + field.getColumn())
                .add("row=" + field.getRow())
                .add("box=" + field.getBox())
                .toString();
        assertEquals(str, field.toString());
    }
}
