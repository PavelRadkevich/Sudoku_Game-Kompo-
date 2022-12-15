package com.sudoku.view;

import org.sudoku.IndexOutRange;
import org.sudoku.SudokuBoard;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class DifficultyLevel {
    private Set<Coordinates> deleted = new HashSet<>();


    public SudokuBoard deleteFields(SudokuBoard sb, int number) throws IndexOutRange {
        while (deleted.size() != number) {
            int x = (int) ((Math.random() * ((8) + 1)) + 0);
            int y = (int) ((Math.random() * ((8) + 1)) + 0);
            deleted.add(new Coordinates(x, y));
        }
        for (Coordinates coordinates : deleted) {
            sb.setCell(coordinates.getX(), coordinates.getY(), 0);
        }
        return sb;
    }

    public SudokuBoard setLevel(SudokuBoard sb, String level) throws Exception {
        if (!(level == "easy" || level == "medium" || level == "hard")) {
            throw new Exception("Unknown Level");
        }

        switch (level) {
            case "easy": {
                deleteFields(sb, 10);
                break;
            }
            case "medium": {
                deleteFields(sb, 20);
                break;
            }
            case "hard": {
                deleteFields(sb, 40);
            }
        }
        return sb;
    }

}
