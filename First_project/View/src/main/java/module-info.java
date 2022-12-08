module com.sudoku.view {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.sudoku.Model;

    opens com.sudoku.view to javafx.fxml;
    exports com.sudoku.view;
}