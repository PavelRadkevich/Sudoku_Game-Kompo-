package org.sudoku;

import org.sudoku.exception.IndexOutRange;

public class Main {
    public static void main(String[] args) throws IndexOutRange {
        BackTrackingSudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard sb = new SudokuBoard(bs);
        bs.solve(sb);
        JdbcSudokuBoardDao jdbc = new JdbcSudokuBoardDao("d");
        jdbc.write(sb);
    }
}
