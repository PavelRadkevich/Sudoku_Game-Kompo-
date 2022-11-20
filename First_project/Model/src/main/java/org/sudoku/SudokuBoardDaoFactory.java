package org.sudoku;

public class SudokuBoardDaoFactory {
    public Dao getFileDao(String filename) {
        return new FileSudokuBoardDao(filename);
    }
}
