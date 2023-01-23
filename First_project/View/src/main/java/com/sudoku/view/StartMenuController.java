package com.sudoku.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class StartMenuController {
    static Stage stage = new Stage();
    static String level;
    String lang = "PL";
    private ResourceBundle bundle = ResourceBundle.getBundle("Languages");
    @FXML
    private Label welcomeText;


    public static String getLevel() {
        return level;
    }

    @FXML
    protected void onEasyButtonClick() throws LoadException {
        level = "easy";
        buildGameScene();
    }
    @FXML
    protected void onMediumButtonClick() throws LoadException {
        level = "medium";
        buildGameScene();
    }
    @FXML
    protected void onHardButtonClick() throws LoadException {
        level = "hard";
        buildGameScene();
    }

    @FXML
    protected void buildGameScene() throws LoadException {
        try {
            Stage newStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GameMenu.fxml"), ResourceBundle.getBundle("Languages"));
            Scene scene = new Scene(fxmlLoader.load(), 470, 412);
            newStage.setTitle("Game");
            String stylesheet = Objects.requireNonNull(getClass().getResource("game.css")).toExternalForm();
            scene.getStylesheets().add(stylesheet);
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            throw new LoadException(e);
        }
    }

    public void Russian(ActionEvent actionEvent) throws LoadException {
        Locale.setDefault(new Locale("RU"));
        buildChoiceWindow();
    }

    public void Polish(ActionEvent actionEvent) throws LoadException {
        Locale.setDefault((new Locale("PL")));
        buildChoiceWindow();
    }

    public void buildChoiceWindow() throws LoadException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StartMenu.fxml"), bundle);
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new LoadException(e);
        }
    }
}