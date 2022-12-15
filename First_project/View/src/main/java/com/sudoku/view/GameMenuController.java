package com.sudoku.view;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import org.sudoku.BackTrackingSudokuSolver;
import org.sudoku.IndexOutRange;
import org.sudoku.SudokuBoard;


public class GameMenuController {
    static Stage stage;
    public ColumnConstraints column3;
    @FXML
    private GridPane grid;
    BackTrackingSudokuSolver bs;
    SudokuBoard board;
    SudokuBoard gameBoard;
    DifficultyLevel dl;


    @FXML
    private void initialize() throws Exception {
        bs = new BackTrackingSudokuSolver();
        board = new SudokuBoard(bs);
        board.solveGame();
        dl = new DifficultyLevel();
        gameBoard = dl.setLevel(board, StartMenuController.getLevel());
        gridFill(gameBoard);

    }

    @FXML
    protected void gridFill(SudokuBoard board) throws IndexOutRange {
        for (int x = 0; x < 9; x++){
            for (int y = 0; y < 9; y++){
                if (board.getCell(x, y) != 0) {
                    Label label = new Label(Integer.toString(board.getCell(x, y)));
                    label.setStyle(" -fx-font-family: Georgia; -fx-font-size: 25");
                    grid.add(label, x, y);
                }
            }
        }
    }



}