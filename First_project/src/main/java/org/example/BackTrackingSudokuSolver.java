
package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class BackTrackingSudokuSolver implements SudokuSolver {

    private final String name = "BackTrackingSudokuSolver";
    private final ArrayList<Integer> list1
            = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    int loopCount = 0;

    public void solve(SudokuBoard board) throws IndexOutRange {
        for (int i = 0; i < 9; i++) {
            if (!pathToSolve(i, 0, board)) {
                resetRow(i, board);
                i--;

                loopCount++;
                if (loopCount == 30) {
                    loopCount = 0;
                    resetRow(i, board);
                    i--;
                }
            }
        }
    }

    private boolean pathToSolve(int row, int column, SudokuBoard board) throws IndexOutRange {

        List<Integer> exrow = (List<Integer>) list1.clone();
        Collections.shuffle(exrow);


        if (column == 9) {
            return true;
        }

        for (int i = 0; i < 9; i++) {
            if (board.checkCell(exrow.get(i), row, column)) {
                board.setCell(row, column, exrow.get(i));
                if (pathToSolve(row, column + 1, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void resetRow(int row, SudokuBoard board) throws IndexOutRange {
        for (int j = 0; j < 9; j++) {
            board.setCell(row, j, 0);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BackTrackingSudokuSolver that = (BackTrackingSudokuSolver) o;
        return new EqualsBuilder().append(name, that.name).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name).toHashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BackTrackingSudokuSolver.class.getSimpleName()
                + "@" + Integer.toHexString(this.hashCode()) + "[", "]")
                .toString();
    }
}

