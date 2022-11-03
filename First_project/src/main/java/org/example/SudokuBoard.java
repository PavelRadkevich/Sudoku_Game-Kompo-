package org.example;

public class SudokuBoard {
    private final SudokuField[] sudokuBoard = new SudokuField[81];
    private final SudokuRow[] sudokuRows = new SudokuRow[9];
    private final SudokuColumn[] sudokuColumns = new SudokuColumn[9];
    private final SudokuBox[] sudokuBoxes = new SudokuBox[9];
    private SudokuSolver solver;



    public SudokuBoard() {
        for (int i = 0; i < 9; i++){
            sudokuRows[i] = new SudokuRow();
            sudokuColumns[i] = new SudokuColumn();
            sudokuBoxes[i] = new SudokuBox();
        }

        int num = 0;
        for (int i = 0; i < 81; i++) {
            sudokuBoard[i] = new SudokuField();
            sudokuBoard[i].setFieldValue(0);
            sudokuRows[i/9].setValue(i%9, sudokuBoard[i]);
            sudokuColumns[i%9].setValue(i/9, sudokuBoard[i]);
        }
        Boxes();
    }

    public SudokuRow getRow (int x){
        return sudokuRows[x];
    }

    public SudokuColumn getColumn(int y){
        return sudokuColumns[y];
    }

    public SudokuBox getBox(int x, int y){
        return sudokuBoxes[1];
    }

    public int getCell(int x, int y) {
        if (x >= 0 && x < 9 && y >= 0 && y < 9) {
            return sudokuBoard[9 * x + y].getFieldValue();
        } else {
            return 0;
        }
    }

    public void setCell(int x, int y, int value) throws IndexOutRange {
        if (x >= 0 && x < 9 && y >= 0 && y < 9 && value >= 1 && value <= 9) {
            sudokuBoard[9 * x + y].setFieldValue(value);
        } else if (x < 0 || x >= 9) {
            throw new IndexOutRange("Wrong column number: " + x);
        } else if (y < 0 || y >= 9) {
            throw new IndexOutRange("Wrong row number: " + y);
        } else {
            sudokuBoard[9 * x + y].setFieldValue(0);
        }
    }

    public boolean checkCell(int num, int x, int y) {
        for (int i = 0; i < 9; i++) {
            if (getCell(i, y) == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (getCell(x, i) == num) {
                return false;
            }
        }
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (getCell(i + x - x % 3, j + y - y % 3)== num) {
                    return false;
                }
            }
        }
        return true;
    }

    public void solveGame(SudokuSolver solver) throws IndexOutRange {
        this.solver = solver;
        solver.solve(this);
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudokuBoard[9 * i + j].getFieldValue() + " ");
            }
            System.out.println();
        }
    }

    private boolean checkBoard () {
        for (int i=0; i < 9; i++)
            if (!sudokuBoxes[i].verify() | !sudokuRows[i].verify() | !sudokuColumns[i].verify())
                return false;
        return true;
    }

    private void Boxes(){
        sudokuBoxes[0].setValue(0, sudokuBoard[0]);
        sudokuBoxes[0].setValue(1, sudokuBoard[1]);
        sudokuBoxes[0].setValue(2, sudokuBoard[2]);
        sudokuBoxes[1].setValue(0, sudokuBoard[3]);
        sudokuBoxes[1].setValue(1, sudokuBoard[4]);
        sudokuBoxes[1].setValue(2, sudokuBoard[5]);
        sudokuBoxes[2].setValue(0, sudokuBoard[6]);
        sudokuBoxes[2].setValue(1, sudokuBoard[7]);
        sudokuBoxes[2].setValue(2, sudokuBoard[8]);
        sudokuBoxes[0].setValue(3, sudokuBoard[9]);
        sudokuBoxes[0].setValue(4, sudokuBoard[10]);
        sudokuBoxes[0].setValue(5, sudokuBoard[11]);
        sudokuBoxes[1].setValue(3, sudokuBoard[12]);
        sudokuBoxes[1].setValue(4, sudokuBoard[13]);
        sudokuBoxes[1].setValue(5, sudokuBoard[14]);
        sudokuBoxes[2].setValue(3, sudokuBoard[15]);
        sudokuBoxes[2].setValue(4, sudokuBoard[16]);
        sudokuBoxes[2].setValue(5, sudokuBoard[17]);
        sudokuBoxes[0].setValue(6, sudokuBoard[18]);
        sudokuBoxes[0].setValue(7, sudokuBoard[19]);
        sudokuBoxes[0].setValue(8, sudokuBoard[20]);
        sudokuBoxes[1].setValue(6, sudokuBoard[21]);
        sudokuBoxes[1].setValue(7, sudokuBoard[22]);
        sudokuBoxes[1].setValue(8, sudokuBoard[23]);
        sudokuBoxes[2].setValue(6, sudokuBoard[24]);
        sudokuBoxes[2].setValue(7, sudokuBoard[25]);
        sudokuBoxes[2].setValue(8, sudokuBoard[26]);
        sudokuBoxes[3].setValue(0, sudokuBoard[27]);
        sudokuBoxes[3].setValue(1, sudokuBoard[28]);
        sudokuBoxes[3].setValue(2, sudokuBoard[29]);
        sudokuBoxes[4].setValue(0, sudokuBoard[30]);
        sudokuBoxes[4].setValue(1, sudokuBoard[31]);
        sudokuBoxes[4].setValue(2, sudokuBoard[32]);
        sudokuBoxes[5].setValue(0, sudokuBoard[33]);
        sudokuBoxes[5].setValue(1, sudokuBoard[34]);
        sudokuBoxes[5].setValue(2, sudokuBoard[35]);
        sudokuBoxes[3].setValue(3, sudokuBoard[36]);
        sudokuBoxes[3].setValue(4, sudokuBoard[37]);
        sudokuBoxes[3].setValue(5, sudokuBoard[38]);
        sudokuBoxes[4].setValue(3, sudokuBoard[39]);
        sudokuBoxes[4].setValue(4, sudokuBoard[40]);
        sudokuBoxes[4].setValue(5, sudokuBoard[41]);
        sudokuBoxes[5].setValue(3, sudokuBoard[42]);
        sudokuBoxes[5].setValue(4, sudokuBoard[43]);
        sudokuBoxes[5].setValue(5, sudokuBoard[44]);
        sudokuBoxes[3].setValue(6, sudokuBoard[45]);
        sudokuBoxes[3].setValue(7, sudokuBoard[46]);
        sudokuBoxes[3].setValue(8, sudokuBoard[47]);
        sudokuBoxes[4].setValue(6, sudokuBoard[48]);
        sudokuBoxes[4].setValue(7, sudokuBoard[49]);
        sudokuBoxes[4].setValue(8, sudokuBoard[50]);
        sudokuBoxes[5].setValue(6, sudokuBoard[51]);
        sudokuBoxes[5].setValue(7, sudokuBoard[52]);
        sudokuBoxes[5].setValue(8, sudokuBoard[53]);
        sudokuBoxes[6].setValue(0, sudokuBoard[54]);
        sudokuBoxes[6].setValue(1, sudokuBoard[55]);
        sudokuBoxes[6].setValue(2, sudokuBoard[56]);
        sudokuBoxes[7].setValue(0, sudokuBoard[57]);
        sudokuBoxes[7].setValue(1, sudokuBoard[58]);
        sudokuBoxes[7].setValue(2, sudokuBoard[59]);
        sudokuBoxes[8].setValue(0, sudokuBoard[60]);
        sudokuBoxes[8].setValue(1, sudokuBoard[61]);
        sudokuBoxes[8].setValue(2, sudokuBoard[62]);
        sudokuBoxes[6].setValue(3, sudokuBoard[63]);
        sudokuBoxes[6].setValue(4, sudokuBoard[64]);
        sudokuBoxes[6].setValue(5, sudokuBoard[65]);
        sudokuBoxes[7].setValue(3, sudokuBoard[66]);
        sudokuBoxes[7].setValue(4, sudokuBoard[67]);
        sudokuBoxes[7].setValue(5, sudokuBoard[68]);
        sudokuBoxes[8].setValue(3, sudokuBoard[69]);
        sudokuBoxes[8].setValue(4, sudokuBoard[70]);
        sudokuBoxes[8].setValue(5, sudokuBoard[71]);
        sudokuBoxes[6].setValue(6, sudokuBoard[72]);
        sudokuBoxes[6].setValue(7, sudokuBoard[73]);
        sudokuBoxes[6].setValue(8, sudokuBoard[74]);
        sudokuBoxes[7].setValue(6, sudokuBoard[75]);
        sudokuBoxes[7].setValue(7, sudokuBoard[76]);
        sudokuBoxes[7].setValue(8, sudokuBoard[77]);
        sudokuBoxes[8].setValue(6, sudokuBoard[78]);
        sudokuBoxes[8].setValue(7, sudokuBoard[79]);
        sudokuBoxes[8].setValue(8, sudokuBoard[80]);
    }
}

