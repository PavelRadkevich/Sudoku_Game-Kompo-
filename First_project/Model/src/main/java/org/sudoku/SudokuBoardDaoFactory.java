<<<<<<< HEAD
package org.sudoku;

public class SudokuBoardDaoFactory {
    public Dao<SudokuBoard> getFileDao(String filename) {
        return new FileSudokuBoardDao(filename);
    }
}
=======
package org.sudoku;

public class SudokuBoardDaoFactory {
    public Dao getFileDao(String filename) {
        return new FileSudokuBoardDao(filename);
    }
}
>>>>>>> 7a747dfae27c99e64036897ca0e29bfbec53252b
