package org.example;

public class SudokuRow {
    private final SudokuField[] sudokuRow = new SudokuField[9];

    public SudokuRow (){}

    public void setValue (int x, SudokuField value){
        sudokuRow[x] = value;
    }

    public boolean verify(){
        for (int j=0; j<sudokuRow.length;j++)
            for (int k=j+1;k<sudokuRow.length;k++)
                if (k!=j && sudokuRow[k] == sudokuRow[j])
                    return false;
        return true;
    }

    public boolean verify(int num){
        for (int i = 0; i < 9; i++) {
            if (sudokuRow[i].getFieldValue() == num) {
                return false;
            }
        }
        return true;
    }
}
