module com.sudoku.view {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sudoku.view to javafx.fxml;
    exports com.sudoku.view;
}