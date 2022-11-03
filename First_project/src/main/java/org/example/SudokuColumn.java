package org.example;

public class SudokuColumn {
    private final SudokuField[] sudokuColumn = new SudokuField[9];

    public SudokuColumn (){}

    public void setValue (int x, SudokuField value){
        sudokuColumn[x] = value;
    }

    public boolean verify(){
        for (int j=0; j<sudokuColumn.length;j++)
            for (int k=j+1;k<sudokuColumn.length;k++)
                if (k!=j && sudokuColumn[k] == sudokuColumn[j])
                    return false;
        return true;
    }

    public boolean verify(int num){
        for (int i = 0; i < 9; i++) {
            if (sudokuColumn[i].getFieldValue() == num) {
                return false;
            }
        }
        return true;
    }
}
