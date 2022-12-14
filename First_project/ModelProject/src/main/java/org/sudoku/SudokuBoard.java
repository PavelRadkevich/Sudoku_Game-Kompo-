package org.sudoku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringJoiner;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;



public class SudokuBoard implements Serializable, Cloneable {
    private final SudokuField[][] sudokuBoard = new SudokuField[9][9];
    private SudokuSolver solver;



    public SudokuBoard(SudokuSolver solver) {
        this.solver = solver;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.sudokuBoard[i][j] = new SudokuField();
            }
        }
        this.updateBoard();
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

    public SudokuColumn getColumn(int x) {
        return sudokuBoard[x][0].getColumn();
    }

    public SudokuRow getRow(int y) {
        return sudokuBoard[0][y].getRow();
    }

    public SudokuBox getBox(int x, int y)  {
        return sudokuBoard[x][y].getBox();
    }

    private void updateBoard() {
        for (int i = 0; i < 9; i++) {
            ArrayList<SudokuField> fields = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                fields.add(j, sudokuBoard[i][j]);
            }
            for (int j = 0; j < 9; j++) {
                SudokuRow row = new SudokuRow(fields, i);
                sudokuBoard[i][j].setRow(row);
            }
        }
        for (int i = 0; i < 9; i++) {
            ArrayList<SudokuField> fields = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                fields.add(j, sudokuBoard[j][i]);
            }
            for (int j = 0; j < 9; j++) {
                SudokuColumn column = new SudokuColumn(fields, i);
                sudokuBoard[j][i].setColumn(column);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ArrayList<SudokuField> fields = new ArrayList<>();
                int number = 0;
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        fields.add(number, sudokuBoard[i * 3 + x][j * 3 + y]);
                        number++;
                    }
                }
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        SudokuBox box = new SudokuBox(fields);
                        sudokuBoard[i * 3 + x][j * 3 + y].setBox(box);
                    }
                }
            }
        }
    }

    public void solveGame() throws IndexOutRange {
        this.solver = new BackTrackingSudokuSolver();
        solver.solve(this);
    }

    public boolean checkCell(int num, int x, int y) throws IndexOutRange {
        setCell(x, y, num);
        if (!sudokuBoard[x][y].getColumn().verify()) {
            sudokuBoard[x][y].setFieldValue(0);
            return false;
        }
        if (!sudokuBoard[x][y].getRow().verify()) {
            sudokuBoard[x][y].setFieldValue(0);
            return false;
        }
        if (!sudokuBoard[x][y].getBox().verify()) {
            sudokuBoard[x][y].setFieldValue(0);
            return false;
        }
        sudokuBoard[x][y].setFieldValue(0);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SudokuBoard board = (SudokuBoard) o;
        return new EqualsBuilder().append(sudokuBoard, board.sudokuBoard).append(solver,
                board.solver).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(sudokuBoard).append(solver).toHashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SudokuBoard.class.getSimpleName() + "@"
                + Integer.toHexString(this.hashCode()) + "[", "]")
                .add("Solver=" + solver.getClass().getSimpleName() + "@"
                        + Integer.toHexString(solver.hashCode()))
                .toString();
    }


    @Override
    public SudokuBoard clone() {
        try {
            SudokuBoard clone = (SudokuBoard) super.clone();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    clone.sudokuBoard[i][j] = this.sudokuBoard[i][j].clone();
                }
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}