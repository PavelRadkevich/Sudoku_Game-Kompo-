<<<<<<< HEAD
package org.sudoku;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuGroupsTest {
    @Test
    public void testVerifyTrue() {

        ArrayList<SudokuField> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(i, new SudokuField());
            fields.get(i).setFieldValue(i + 1);
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

        ArrayList<SudokuField> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(i, new SudokuField());
            fields.get(i).setFieldValue(3);
        }
        SudokuGroups row = new SudokuRow(fields);
        SudokuGroups column = new SudokuColumn(fields);
        SudokuGroups box = new SudokuBox(fields);


        assertFalse(row.verify());
        assertFalse(column.verify());
        assertFalse(box.verify());

    }

    @Test
    void equalsTest() {
        ArrayList<SudokuField> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(i, new SudokuField());
            fields.get(i).setFieldValue(3);
        }
        SudokuGroups row = new SudokuRow(fields);
        SudokuGroups column = new SudokuColumn(fields);
        assertTrue(row.equals(row));
        assertFalse(row.equals(column));
        column = null;
        assertFalse(row.equals(column));

    }

    @Test
    void toStringTest() {
        ArrayList<SudokuField> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(i, new SudokuField());
            fields.get(i).setFieldValue(i + 1);
        }
        SudokuGroups row = new SudokuRow(fields);
        String str = new StringJoiner(", ", SudokuGroups.class.getSimpleName() + "@"
                + Integer.toHexString(row.hashCode()) + "[", "]")
                .add("fields = " + row.getFields())
                .toString();
        assertEquals(row.toString(),str);
    }
}
=======
package org.sudoku;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuGroupsTest {
    @Test
    public void testVerifyTrue() {

        ArrayList<SudokuField> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(i, new SudokuField());
            fields.get(i).setFieldValue(i + 1);
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

        ArrayList<SudokuField> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(i, new SudokuField());
            fields.get(i).setFieldValue(3);
        }
        SudokuGroups row = new SudokuRow(fields);
        SudokuGroups column = new SudokuColumn(fields);
        SudokuGroups box = new SudokuBox(fields);


        assertFalse(row.verify());
        assertFalse(column.verify());
        assertFalse(box.verify());

    }

    @Test
    void equalsTest() {
        ArrayList<SudokuField> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(i, new SudokuField());
            fields.get(i).setFieldValue(3);
        }
        SudokuGroups row = new SudokuRow(fields);
        SudokuGroups column = new SudokuColumn(fields);
        assertTrue(row.equals(row));
        assertFalse(row.equals(column));
        column = null;
        assertFalse(row.equals(column));

    }
}
>>>>>>> 7a747dfae27c99e64036897ca0e29bfbec53252b
