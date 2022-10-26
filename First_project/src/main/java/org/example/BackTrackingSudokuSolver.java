package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BackTrackingSudokuSolver implements SudokuSolver {

    private final ArrayList<Integer> list1
            = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    int loopCount = 0;

    public void solve (SudokuBoard board) {
        for (int i = 0; i < 9; i++) {
            if (!pathToSolve(i, 0, board)) {
                resetRow(i, board);
                i--;

                loopCount++;
                if (loopCount == 30) {
                    loopCount = 0;
                    resetRow(i, board);
                    i--;
                }
            }
        }
    };

    private boolean pathToSolve(int row, int column, SudokuBoard board){

        List<Integer> exrow = (List<Integer>) list1.clone();
        Collections.shuffle(exrow);


        if (column == 9) {
            return true;
        }

        for (int i = 0; i < 9; i++) {
            if (board.checkCell(exrow.get(i), row, column)) {
                board.setCell(row, column, exrow.get(i)) ;
                if (pathToSolve(row, column + 1, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void resetRow(int row, SudokuBoard board) {
        for (int j = 0; j < 9; j++) {
            board.setCell(row, j, 0);
        }
    }
}

