package org.example;

public class SudokuBoard {
    //private final int size = 9;
    private final int[][] sudokuBoard = new int [9][9];
    private SudokuSolver solver;



    public SudokuBoard() {
    }

    public int getCell(int x, int y) {
        if (x>=0 && x<9 && y>=0 && y<9)
            return sudokuBoard[x][y];
        else
            return 0;
    }

    public void setCell(int x, int y, int value){
        if (x>=0 && x<9 && y>=0 && y<9 && value >= 1 && value <= 9)
            sudokuBoard[x][y] = value;
        else
            sudokuBoard[x][y] = 0;

    }

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

