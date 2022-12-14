package org.sudoku;

import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FileSudokuBoardDaoTest {

    SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
    private BackTrackingSudokuSolver bs = new BackTrackingSudokuSolver();
    private SudokuBoard board = new SudokuBoard(bs);
    private SudokuBoard board2;
    private Dao<SudokuBoard> fileSBDao;

    @Test
    public void writeReadTest() throws FileNotFoundException {
        fileSBDao  = factory.getFileDao("xyz");
        fileSBDao.write(board);
        board2 = fileSBDao.read();
        assertEquals(board,board2);
    }

    @Test
    void exceptionReadTest() throws FileNotFoundException {
        fileSBDao  = factory.getFileDao("hhh");
        assertNull(fileSBDao.read());
    }

    @Test
    public void writeIOExceptionTest() throws FileNotFoundException {
        fileSBDao = factory.getFileDao("?");
        try {
            fileSBDao.write(board);
        } catch (RuntimeException re) {
            System.out.println(re);
        }
    }
}