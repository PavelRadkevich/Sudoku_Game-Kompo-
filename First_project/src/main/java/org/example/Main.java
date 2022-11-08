package org.example;
public class Main {
    public static void main(String[] args) throws IndexOutRange {
        SudokuSolver solver = new BackTrackingSudokuSolver();
        SudokuBoard board = new SudokuBoard(solver);
        board.printBoard();
        board.solveGame();
        System.out.println(" ");
        board.printBoard();
    }
}
