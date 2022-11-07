package org.example;

public class SudokuBoard {
    private final SudokuField[][] sudokuBoard = new SudokuField[9][9];
    private SudokuSolver solver;



    public SudokuBoard(SudokuSolver solver) {
        this.solver = solver;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.sudokuBoard[i][j] = new SudokuField();
            }
        }
    }

    public int getCell(int x, int y) {
        if (x >= 0 && x < 9 && y >= 0 && y < 9) {
            return sudokuBoard[x][y].getFieldValue();
        } else {
            return 0;
        }
    }

    public void setCell(int x, int y, int value) throws IndexOutRange {
        if (x >= 0 && x < 9 && y >= 0 && y < 9 && value >= 1 && value <= 9) {
            this.sudokuBoard[x][y].setFieldValue(value);
        } else if (x < 0 || x >= 9) {
            throw new IndexOutRange("Wrong column number:" + x);
        } else if (y < 0 || y >= 9) {
            throw new IndexOutRange("Wrong row number:" + y);
        } else {
            this.sudokuBoard[x][y].setFieldValue(0);
        }
    }

    public SudokuColumn getColumn(int x) throws NullValue {
        if (sudokuBoard[x][0].getColumn() == null) {
            throw new NullValue("Null value of column:" + x);
        }
        return sudokuBoard[x][0].getColumn();
    }

    public SudokuRow getRow(int y) throws NullValue {
        if (sudokuBoard[0][y].getRow() == null) {
            throw new NullValue("Null value of row:" + y);
        }
        return sudokuBoard[0][y].getRow();
    }

    public SudokuBox getBox(int x, int y) throws NullValue {
        if (sudokuBoard[x][y].getBox() == null) {
            throw new NullValue("Null value of box of index x: " + x + " and index y: " + y);
        }
        return sudokuBoard[x][y].getBox();
    }

    public void updateBoard() {
        for (int i = 0; i < 9; i++) {
            SudokuField[] fields = new SudokuField[9];
            for (int j = 0; j < 9; j++) {
                fields[j] = sudokuBoard[i][j];
            }
            for (int j = 0; j < 9; j++) {
                SudokuRow row = new SudokuRow(fields);
                sudokuBoard[i][j].setRow(row);
            }
        }
        for (int i = 0; i < 9; i++) {
            SudokuField[] fields = new SudokuField[9];
            for (int j = 0; j < 9; j++) {
                fields[j] = sudokuBoard[j][i];
            }
            for (int j = 0; j < 9; j++) {
                SudokuColumn column = new SudokuColumn(fields);
                sudokuBoard[j][i].setColumn(column);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                SudokuField[] fields = new SudokuField[9];
                int number = 0;
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        fields[number] = sudokuBoard[i * 3 + x][j * 3 + y];
                        number++;
                    }
                }
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        SudokuBox box = new SudokuBox(fields);
                        sudokuBoard[i + x][j + y].setBox(box);
                    }
                }
            }
        }
    }

    public void solveGame() throws IndexOutRange {
        this.solver = new BackTrackingSudokuSolver();
        solver.solve(this);
        updateBoard();
    }

    private boolean checkBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!sudokuBoard[i][j].getColumn().verify()) {
                    return false;
                }
                if (!sudokuBoard[i][j].getBox().verify()) {
                    return false;
                }
                if (!sudokuBoard[i][j].getRow().verify()) {
                    return false;
                }
            }
        }
            return true;
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
                if (getCell(i + x - x % 3, j + y - y % 3) == num) {
                    return false;
                }
            }
        }
        return true;
    }
}

