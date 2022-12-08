package com.sudoku.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.sudoku.SudokuBoard;
import org.sudoku.BackTrackingSudokuSolver;

import java.io.IOException;

public class StartMenuController {
    static Stage stage;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onEasyButtonClick() throws IOException {
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GameMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 470, 412);
        newStage.setTitle("Game");
        newStage.setScene(scene);
        newStage.show();
    }
    @FXML
    protected void onMediumButtonClick() {

    }
    @FXML
    protected void onHardButtonClick() {

    }
}