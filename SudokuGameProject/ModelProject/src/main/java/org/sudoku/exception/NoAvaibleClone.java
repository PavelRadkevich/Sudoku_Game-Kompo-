package org.sudoku.exception;

public class NoAvaibleClone extends CloneNotSupportedException {
    public NoAvaibleClone(Throwable botak) {
        super(String.valueOf(botak));
    }
}
