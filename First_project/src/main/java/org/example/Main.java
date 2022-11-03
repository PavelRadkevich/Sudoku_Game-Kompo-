package org.example;
public class Main {
    public static void main(String[] args) throws IndexOutRange {
    SudokuBoard sb = new SudokuBoard();
    SudokuSolver ss = new BackTrackingSudokuSolver();
    sb.solveGame(ss);
    sb.printBoard();
    }
}
