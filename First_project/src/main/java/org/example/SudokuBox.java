<<<<<<< HEAD
package org.example;

public class SudokuBox extends SudokuGroups {
    public SudokuBox(SudokuField[] fields) {
        super(fields);
    }
}
=======
package org.example;

public class SudokuBox {
    private final SudokuField[] sudokuBox = new SudokuField[9];

    public SudokuBox (){}

    public void setValue (int x, SudokuField value){
        sudokuBox[x] = value;
    }

    public boolean verify(){
        for (int j=0; j<sudokuBox.length;j++)
            for (int k=j+1;k<sudokuBox.length;k++)
                if (k!=j && sudokuBox[k] == sudokuBox[j])
                    return false;
        return true;
    }

    public boolean verify(int num){
        for (int i = 0; i < 9; i++) {
            if (sudokuBox[i].getFieldValue() == num) {
                return false;
            }
        }
        return true;
    }
}
>>>>>>> f7b092090c6931d7b0ade96392d7a40ce27a4090
