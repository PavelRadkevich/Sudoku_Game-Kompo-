package org.sudoku;

import org.sudoku.exception.DaoException;

import java.sql.*;

public class JdbcSudokuBoardDao implements Dao<SudokuBoard>{
    String filename;

    public JdbcSudokuBoardDao (String filename_) {
        this.filename = filename_;
    }
    @Override
    public void write (SudokuBoard sudokuBoard) {
        String url = "jdbc:sqlite:./" + filename;
        Connection connection;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sqlCreate = """
                CREATE TABLE IF NOT EXISTS SudokuBoard (
                	id integer PRIMARY KEY,
                	name text NOT NULL,
                );""";
        String sqlInsert = "INSERT INTO SudokuBoard(name) VALUES(?)";
        try (Statement stmt = connection.createStatement();) {
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (PreparedStatement pstmt = connection.prepareStatement(sqlInsert)) {
            pstmt.setString(1, filename);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public SudokuBoard read() throws DaoException {
        String url = "jdbc:sqlite:./" + filename;
        Connection connection;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
