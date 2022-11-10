package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class SudokuGroups {
    protected List<SudokuField> fields = new ArrayList<>();
    //protected SudokuField[] fields;

    SudokuGroups(final ArrayList<SudokuField> fields) {
    this.fields = fields;
    }

    public boolean verify() {
        for (int j = 0; j < 9; j++) {
            for (int k = j + 1; k < 9; k++) {
                if (k != j && fields.get(k).getFieldValue() == fields.get(j).getFieldValue()
                        && fields.get(k).getFieldValue() != 0
                        && fields.get(j).getFieldValue() != 0) {
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
            str = str + fields.get(i).getFieldValue() + " ";
        }
        return str;
    }
}
