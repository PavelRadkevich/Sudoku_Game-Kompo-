import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSudokuBoard {

    @Test
    void testFillBoard() {
        SudokuBoard board1 = new SudokuBoard();
        SudokuBoard board2 = new SudokuBoard();
        board2.fillBoard(9, 9);
        board1.fillBoard(9,9);
        int match = 0;
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board1.getCell(i, j) == board2.getCell(i, j)){
                    match++;
                }
            }
        }
        assertNotEquals(81, match);
    }

    @Test
    void testBoardCorrectness() {
        SudokuBoard board1 = new SudokuBoard();
        board1.fillBoard(9, 9);
        int sum = 0;

        for (int i=0; i<9; i++){             //check rows
            for (int j=0; j<9; j++) {
                sum += board1.getCell(i, j);
            }
            assertEquals(45, sum);
            sum = 0;
        }

        for (int j=0; j<9; j++){             //check columns
            for (int i=0; i<9; i++) {
                sum += board1.getCell(i, j);
            }
            assertEquals(45, sum);
            sum = 0;
        }

        for (int j=0; j<9; j++){             //check columns
            for (int i=0; i<9; i++) {
                sum += board1.getCell(i, j);
            }
            assertEquals(45, sum);
            sum = 0;
        }
        for (int x=0; x<=9; x+=3) {
            for (int y=0; y<=9; y+=3) {
                for (int i = 0; i <= i + 3; i++) {  //check boxes
                    for (int j = 0; j <= j + 3; j++) {
                        sum += board1.getCell(i + x - x % 3, j + y - y % 3);
                    }
                }
                assertEquals(45, sum);
                sum = 0;
            }
        }
    }
}