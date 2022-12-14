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
    public Dao<SudokuBoard> getFileDao(String filename) {
        return new FileSudokuBoardDao(filename);
    }
}

>>>>>>> 2b659905461f649eac73e98bd67cf301e4936055
