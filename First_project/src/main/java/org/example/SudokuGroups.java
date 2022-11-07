package org.example;

import java.util.Arrays;

public abstract class SudokuGroups {
    protected SudokuField[] fields;

    SudokuGroups(final SudokuField[] fields) {
    this.fields = fields;
    }

    public boolean verify() {
        for (int j = 0; j < 9; j++) {
            for (int k = j + 1; k < 9; k++) {
                if (k != j && fields[k].getFieldValue() == fields[j].getFieldValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < 9; i++) {
            str = str +fields[i].getFieldValue() + " ";
        }
        return str;
    }
}
