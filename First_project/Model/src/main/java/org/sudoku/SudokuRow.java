package org.sudoku;

import java.util.ArrayList;

public class SudokuRow extends SudokuGroups {
    public SudokuRow(ArrayList<SudokuField> fields) {
        super(fields);
    }
    public SudokuRow(ArrayList<SudokuField> fields, int numberOfGroup) {
        super(fields, numberOfGroup);
    }

}