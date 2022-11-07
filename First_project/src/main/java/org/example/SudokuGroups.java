package org.example;

public abstract class SudokuGroups {
    protected SudokuField[] fields;

    SudokuGroups(final SudokuField[] fields) {
    this.fields = fields;
    }

    public boolean verify() {
        for (int j = 0; j < fields.length; j++) {
            for (int k = j + 1; k < fields.length; k++) {
                if (k != j && fields[k] == fields[j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
