<<<<<<< HEAD
package org.sudoku;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileSudokuBoardDao implements Dao<SudokuBoard> {

    private final String filename;

    FileSudokuBoardDao(String filenameK) {
        filename = filenameK + ".txt";
    }

    @Override
    public SudokuBoard read() {
        SudokuBoard board = null;
        try (FileInputStream fileStream = new FileInputStream(filename);
             ObjectInputStream objectStream = new ObjectInputStream(fileStream)) {
            board = (SudokuBoard) objectStream.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            return null;
        }

        return board;
    }

    @Override
    public void write(SudokuBoard board) {
        try (FileOutputStream fileStream = new FileOutputStream(filename);
             ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)) {
            objectStream.writeObject(board);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

}

=======
package org.sudoku;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileSudokuBoardDao implements Dao<SudokuBoard> {

    private final String filename;

    FileSudokuBoardDao(String filenameK) {
        filename = filenameK + ".txt";
    }

    @Override
    public SudokuBoard read() {
        SudokuBoard board = null;
        try (FileInputStream fileStream = new FileInputStream(filename);
             ObjectInputStream objectStream = new ObjectInputStream(fileStream)) {
            board = (SudokuBoard) objectStream.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            return null;
        }

        return board;
    }

    @Override
    public void write(SudokuBoard board) {
        try (FileOutputStream fileStream = new FileOutputStream(filename);
             ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)) {
            objectStream.writeObject(board);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

}

>>>>>>> 2b659905461f649eac73e98bd67cf301e4936055
