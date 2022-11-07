package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuGrupsTest {
    @Test
    public void testVerifyTrue() {

        SudokuField[] fields = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            fields[i] = new SudokuField();
            fields[i].setFieldValue(i + 1);
        }
        SudokuGroups row = new SudokuRow(fields);
        SudokuGroups column = new SudokuColumn(fields);
        SudokuGroups box = new SudokuBox(fields);

        assertTrue(row.verify());
        assertTrue(column.verify());
        assertTrue(box.verify());

    }
    @Test
    public void testVerifyFalse() {

        SudokuField[] fields = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            fields[i] = new SudokuField();
            fields[i].setFieldValue(3);
        }
        SudokuGroups row = new SudokuRow(fields);
        SudokuGroups column = new SudokuColumn(fields);
        SudokuGroups box = new SudokuBox(fields);


        assertFalse(row.verify());
        assertFalse(column.verify());
        assertFalse(box.verify());

    }
}
