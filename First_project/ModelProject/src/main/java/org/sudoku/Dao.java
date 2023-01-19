package org.sudoku;

import org.sudoku.exception.DaoException;



public interface Dao<T> {
    T read() throws DaoException;

<<<<<<< HEAD
    void write(T obj) throws DaoException;
=======
    void write(T obj) throws FileNotFoundException;
>>>>>>> dbe782392f5324cc6875fc91ded96701cc6646e4
}