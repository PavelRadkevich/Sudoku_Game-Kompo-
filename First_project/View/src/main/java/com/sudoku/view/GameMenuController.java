package com.sudoku.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.sudoku.*;

import java.io.File;
import java.util.ResourceBundle;


public class GameMenuController {
    static Stage stage;
    @FXML
    private GridPane grid;
    BackTrackingSudokuSolver bs;
    SudokuBoard board;
    SudokuBoard gameBoard;
    DifficultyLevel dl;
    ResourceBundle bundle = ResourceBundle.getBundle("Languages");
    File file;
    FileSudokuBoardDao dao;


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
                    TextField field = new TextField(Integer.toString(board.getCell(x, y)));
                    field.setMinSize(20,20);
                    field.setStyle(" -fx-font-family: Georgia; -fx-font-size: 18");
                    grid.add(field, x, y);
                }
                else {
                    TextField field = new TextField("");
                    field.setMinSize(20,20);
                    field.setStyle(" -fx-font-family: Georgia; -fx-font-size: 18");
                    grid.add(field, x, y);
                }
            }
        }
    }
    @FXML
    public void ButtonCheck(ActionEvent actionEvent) throws IndexOutRange {
        for (int i = 0; i < 81; i++) {
            String textField = String.valueOf(grid.getChildren().get(i));
            if (!(textField.matches("1-9") || textField.equals(""))) {
                alert (Alert.AlertType.WARNING, bundle.getString("niepoprawnaPlansza"));
                return;
            }
        }
        refillBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.checkCell(board.getCell(i, j), i, j)) {
                    alert(Alert.AlertType.INFORMATION, bundle.getString("win"));
                }
                else {
                    alert(Alert.AlertType.INFORMATION, bundle.getString("lose"));
                }
            }
        }
    }

    @FXML
    public void ButtonToFile(ActionEvent actionEvent) throws IndexOutRange {
        refillBoard();
        /*FileChooser fileChooser = new FileChooser();
        try {
            file = fileChooser.showSaveDialog(stage);
            FileSudokuBoardDao dao1 = new FileSudokuBoardDao(file.getName());
            dao1.write(board);
            dao = dao1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }
    @FXML
    public void refillBoard () throws IndexOutRange {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String textField = ((TextField) grid.getChildren().get(i * 9 + j)).getText();
                if (textField.equals("")) {
                    board.setCell(i, j, 0);
                }
                else {
                    board.setCell(i, j, Integer.parseInt(textField));
                }
            }
        }
    }
    @FXML
    public void alert (Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.showAndWait();
    }

}