package org.example;

public class SudokuBoard {
    //private final int size = 9;
    private int[][] sudokuBoard = new int [9][9];
    private SudokuSolver solver;



    public SudokuBoard() {
    }

    public int getCell(int x, int y) {return sudokuBoard[x][y];}

    public void setCell(int x, int y, int value) {sudokuBoard[x][y] = value;}

    public void solveGame() {
        this.solver = new BackTrackingSudokuSolver();
        solver.solve(this);
    }
    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudokuBoard[i][j] + " ");
            }
            System.out.println();
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
                if (getCell(i + x - x % 3, j + y - y % 3) == num) {
                    return false;
                }
            }
        }
        return true;
    }
}

