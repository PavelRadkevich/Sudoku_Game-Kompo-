package org.sudoku;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sudoku.exception.DaoException;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FileSudokuBoardDaoTest {
    private final static Logger logger= LoggerFactory.getLogger(FileSudokuBoardDaoTest.class);
    SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
    private BackTrackingSudokuSolver bs = new BackTrackingSudokuSolver();
    private SudokuBoard board = new SudokuBoard(bs);
    private SudokuBoard board2;
    private Dao<SudokuBoard> fileSBDao;

    @Test
    public void writeReadTest() throws DaoException {
        fileSBDao  = factory.getFileDao("xyz");
        fileSBDao.write(board);
        board2 = fileSBDao.read();
        assertEquals(board,board2);
    }

    @Test
    void exceptionReadTest() {
        try {
            fileSBDao = factory.getFileDao("hhh");
            assertNull(fileSBDao.read());
        } catch (DaoException e) {
            logger.warn(e.toString());
        }
    }

    @Test
    public void writeIOExceptionTest() {
        fileSBDao = factory.getFileDao("?");
        try {
            fileSBDao.write(board);
        } catch (RuntimeException | DaoException re) {
            logger.warn(re.toString());
        }
    }
}