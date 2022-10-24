package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SudokuBoard {
    private final int size = 9;
    private int[][] sudokuBoard = new int [size][size];
    private final ArrayList<Integer> list1
            = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    private int loopCount = 0;

    public SudokuBoard() {
    }

    private int getCell(int x, int y) {
        return sudokuBoard[x][y];
    }

    private boolean pathToSolve(int row, int column) {

        List<Integer> exrow = (List<Integer>) list1.clone();
        Collections.shuffle(exrow);


        if (column == size) {
            return true;
        }

        for (int i = 0; i < 9; i++) {
            if (checkCell(sudokuBoard, exrow.get(i), row, column)) {
                sudokuBoard[row][column] = exrow.get(i);
                if (pathToSolve(row, column + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void fillBoard() {
        for (int i = 0; i < 9; i++) {
            if (!pathToSolve(i, 0)) {
                resetRow(i);
                i--;

                loopCount++;
                if (loopCount == 30) {
                    loopCount = 0;
                    resetRow(i);
                    i--;
                }
            }
        }
    }

    private void resetRow(int row) {
        for (int j = 0; j < 9; j++) {
            sudokuBoard[row][j] = 0;
        }
    }

    private boolean checkCell(int [][]sudokuBoard, int num, int x, int y) {
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
                if (sudokuBoard[i + x - x % 3] [j + y - y % 3] == num) {
                    return false;
                }
            }
        }
        return true;
    }


    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudokuBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
}
