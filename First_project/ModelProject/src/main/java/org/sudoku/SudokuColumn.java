package org.sudoku;

import java.util.ArrayList;

public class SudokuColumn extends SudokuGroups {
    public SudokuColumn(ArrayList<SudokuField> fields) {
        super(fields);
    }
    public SudokuColumn(ArrayList<SudokuField> fields, int numberOfGroup) {
        super(fields, numberOfGroup);
    }
}