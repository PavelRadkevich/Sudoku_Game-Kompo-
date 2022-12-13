package com.sudoku.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.sudoku.BackTrackingSudokuSolver;
import org.sudoku.IndexOutRange;
import org.sudoku.SudokuBoard;

public class GameMenuController {
    @FXML
    private GridPane pane;
    BackTrackingSudokuSolver bs;
    SudokuBoard board;

    @FXML
    private void initialize() throws IndexOutRange {
        bs = new BackTrackingSudokuSolver();
        board = new SudokuBoard(bs);
        gridFill();
    }

    @FXML
    protected void gridFill() throws IndexOutRange {
        board.solveGame();
        for (int x = 0; x < 9; x++){
            for (int y = 0; y < 9; y++){
                Label label = new Label(Integer.toString(board.getCell(x, y)));
                pane.add(label, x, y);
            }
        }
    }
}
