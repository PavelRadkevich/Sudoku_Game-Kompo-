<<<<<<< HEAD
package org.sudoku;

import java.io.FileNotFoundException;

public interface Dao<T> {
    T read() throws FileNotFoundException;

    void write(T obj) throws FileNotFoundException;
}
=======
package org.sudoku;

import java.io.FileNotFoundException;

public interface Dao<T> {
    T read() throws FileNotFoundException;

    void write(T obj) throws FileNotFoundException;
}
>>>>>>> 7a747dfae27c99e64036897ca0e29bfbec53252b
