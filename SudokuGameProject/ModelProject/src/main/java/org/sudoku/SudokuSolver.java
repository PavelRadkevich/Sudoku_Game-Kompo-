package org.sudoku;

import org.sudoku.exception.IndexOutRange;

public interface SudokuSolver {
    void solve(SudokuBoard board) throws IndexOutRange;
}
