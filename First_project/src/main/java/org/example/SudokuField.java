<<<<<<< HEAD
package org.example;

public class SudokuField {
    private int value = 0;
    private SudokuColumn column;
    private SudokuRow row;
    private SudokuBox box;


    public SudokuField() {

    }

    public int getFieldValue() {
        return value;
    }

    public void setColumn(SudokuColumn column) {
        this.column = column;
    }

    public void setRow(SudokuRow row) {
        this.row = row;
    }

    public void setBox(SudokuBox box) {
        this.box = box;
    }

    public SudokuColumn getColumn() {
        return column;
    }

    public SudokuRow getRow() {
        return row;
    }

    public SudokuBox getBox() {
        return box;
    }

    public void setFieldValue(int value) {
        this.value = value;
    }
}
=======
package org.example;

public class SudokuField {
    private int value = 0;

    public SudokuField () {}
    public int getFieldValue (){
        return value;
    }
    public void setFieldValue (int a){
        value = a;
    }

}
>>>>>>> f7b092090c6931d7b0ade96392d7a40ce27a4090
