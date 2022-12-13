package org.sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardDaoFactoryTest {


    private SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
    @Test
    void getFileDao() {
        assertNotNull(factory.getFileDao("xyz"));
    }
}