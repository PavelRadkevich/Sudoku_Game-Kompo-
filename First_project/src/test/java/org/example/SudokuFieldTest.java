package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
