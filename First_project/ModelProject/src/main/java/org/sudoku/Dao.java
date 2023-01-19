package org.sudoku;

import org.sudoku.exception.DaoException;



public interface Dao<T> {
    T read() throws DaoException;

    void write(T obj) throws DaoException;
}