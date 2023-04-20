package org.sudoku;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.sudoku.exception.ReadException;

public class FileSudokuBoardDao implements Dao<SudokuBoard> {

    private String filename;

    public FileSudokuBoardDao(String filenameK) {
        filename = filenameK;
    }

    @Override
    public SudokuBoard read() throws ReadException {
        SudokuBoard board = null;
        try (FileInputStream fileStream = new FileInputStream(filename);
             ObjectInputStream objectStream = new ObjectInputStream(fileStream)) {
            board = (SudokuBoard) objectStream.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            throw new ReadException(ioe);
        }

        return board;
    }

    @Override
    public void write(SudokuBoard board) {
        filename = filename + ".txt";
        try (FileOutputStream fileStream = new FileOutputStream(filename);
             ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)) {
            objectStream.writeObject(board);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

}