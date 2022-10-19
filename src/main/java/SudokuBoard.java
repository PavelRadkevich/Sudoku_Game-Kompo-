import java.util.Arrays;
import java.util.Collections;

public class SudokuBoard {
    int size = 9;
    int column = 0, row = 0;
    int [][] sudokuBoard = new int [row][column];
    int [] exrow = {1, 2, 3, 4, 5, 6, 7, 8, 9};



    public SudokuBoard () {

    }

    public int getCell (int x, int y) {
        return sudokuBoard[x][y];
    }

    public void fillBoard(int row, int column) {
    if (row == size-1 && column == size) {
        column = 0;
        row = 0;
        return;
    }

    if (column == size) {
        row++;
        column=0;
    }

    Collections.shuffle(Arrays.asList(exrow));
    for (int i = 1; i <= 9; i++) {
        if (checkCell(sudokuBoard, i, row, column)) {
            sudokuBoard[row][column] = i;
            fillBoard(row, column++);
        }
    }

    }

    public void printBoard () {
        for (int i=0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudokuBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean checkCell (int [][]sudokuBoard, int num, int x, int y) {
        for (int i = 0; i < 9; i++){
            if (getCell(i, y) == num)
                return false;
        }
        for (int i = 0; i < 9; i++){
            if (getCell(x, i) == num)
                return false;
        }
        for (int i = 0; i <= 2; i++){
            for (int j = 0; j<=2; j++){
                if (sudokuBoard[i + x - x % 3] [j + y - y % 3] == num)
                    return false;
            }
        }


        return true;
    }

}
