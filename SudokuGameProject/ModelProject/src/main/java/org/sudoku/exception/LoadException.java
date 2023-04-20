package org.sudoku.exception;

import java.io.IOException;

public class LoadException extends IOException {
    public LoadException(Throwable botak) {
        super(botak);
    }
}
