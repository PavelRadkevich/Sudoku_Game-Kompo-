import java.util.Arrays;
import java.util.Collections;

public class SudokuBoard {
    int size = 9;
    int [][] sudokuBoard = new int [size][size];
    int [] exrow = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };


    public int getCell (int x, int y) {
        return sudokuBoard[x][y];
    }

    public void fillBoard(int [][] sudokuBoard, int row, int column, int[] exrow) {
    if (row == size && column == size)
        return;

    if (column == size) {
        row++;
        column=0;
    }

    Collections.shuffle(Arrays.asList(exrow));
    for (int i = 1; i <= 9; i++) {
        if (checkCell(sudokuBoard, i, row, column)) {
            sudokuBoard[row][column] = i;
            fillBoard(sudokuBoard, row, column++, exrow);
        }
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
