package org.sudoku.exception;


import java.io.IOException;

public class NoFileException extends IOException {
    public NoFileException(Throwable botak) {
        super(botak);
    }
}
