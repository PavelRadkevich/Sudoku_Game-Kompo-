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
    /*
        //////////SudokuBoard///////////////////
        String url = "jdbc:sqlite:./" + filename;
        Connection connection;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sqlCreate = """
                CREATE TABLE IF NOT EXISTS SudokuBoard (
                	ID INT IDENTITY(1,1) NOT NULL PRIMARY,
                	name text NOT NULL,
                	fields varchar(81)
                );""";
        String sqlInsert = "INSERT INTO SudokuBoard(name, fields) VALUES(?)";
        try (Statement stmt = connection.createStatement();) {
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try (PreparedStatement pstmt = connection.prepareStatement(sqlInsert)) {
            pstmt.setString(1, filename);
            pstmt.setString(2, sudokuBoard.getAllFields());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        /////////////SudokuField/////////////////
        /*for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String sqlFieldCreate = """
                    CREATE TABLE IF NOT EXISTS SudokuField (
                	ID INT IDENTITY(1,1) NOT NULL PRIMARY,
                	name text NOT NULL,
                	value INT NOT NULL,
                	row INT NOT NULL,
                	column INT NOT NULL,
                	box INT NOT NULL,
                	board INT NOT NULL,
                	FOREIGN KEY (board) REFERENCES SudokuBoard(ID)
                );""";
            String sqlFieldInsert = "INSERT INTO SudokuField(value, row, column, box, board) VALUES(?)";
            try (Statement stmt = connection.createStatement();) {
                stmt.execute(sqlFieldCreate);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try (PreparedStatement pstmt = connection.prepareStatement(sqlFieldInsert)) {
                pstmt.setInt(1, sudokuBoard.getCell(i, j));
                pstmt.setInt(2, sudokuBoard.getRow(j).numberOfGroup);
                pstmt.setInt(3, sudokuBoard.getColumn(i).numberOfGroup);
                pstmt.setInt(4, sudokuBoard.getBox(i, j).numberOfGroup);
                //pstmt.setInt(5, key);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            }
        }*/

    }

    @Override
    public SudokuBoard read() throws DaoException {
        /*
        BackTrackingSudokuSolver bs = new BackTrackingSudokuSolver();
        SudokuBoard sb = new SudokuBoard(bs);
        String url = "jdbc:sqlite:./" + filename;
        Connection connection;
        ResultSet query;
        String fields;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sqlSelect = """
                SELECT  id, name, fields
                FROM SudokuBoard
                WHERE name = ?
                """;

        try (PreparedStatement pstmt = connection.prepareStatement(sqlSelect)) {
            pstmt.setString(1, filename);
            query = pstmt.executeQuery();
            fields = query.getString(2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        sb.setAllFields(fields);

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

            return sb;

         */
        return null;
    }


}
