package com.sudoku.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StartMenuController {
    static Stage stage;
    static String level;
    @FXML
    private Label welcomeText;


    public static String getLevel() {
        return level;
    }

    @FXML
    protected void onEasyButtonClick() throws IOException {
        level = "easy";
        buildGameScene();
    }
    @FXML
    protected void onMediumButtonClick() throws IOException {
        level = "medium";
        buildGameScene();
    }
    @FXML
    protected void onHardButtonClick() throws IOException {
        level = "hard";
        buildGameScene();
    }

    @FXML
    protected void buildGameScene() throws IOException {
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GameMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 470, 412);
        newStage.setTitle("Game");
        String stylesheet = Objects.requireNonNull(getClass().getResource("game.css")).toExternalForm();
        scene.getStylesheets().add(stylesheet);
        newStage.setScene(scene);
        newStage.show();
    }
}