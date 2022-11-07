package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SudokuFieldTest {
    @Test
    public void getTest() {
        SudokuField[] fields = new SudokuField[9];
        for (int i = 0; i < 9; i++) {
            fields[i] = new SudokuField();
            fields[i].setFieldValue(i + 1);
        }
        SudokuRow row = new SudokuRow(fields);
        SudokuColumn column = new SudokuColumn(fields);
        SudokuBox box = new SudokuBox(fields);
        for (int i = 0; i < 9; i++) {
            fields[i].setRow(row);
            fields[i].setBox(box);
            fields[i].setColumn(column);
            assertEquals(row, fields[i].getRow());
            assertEquals(column, fields[i].getColumn());
            assertEquals(box, fields[i].getBox());
        }
    }
}
