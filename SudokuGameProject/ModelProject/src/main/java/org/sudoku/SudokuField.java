package org.sudoku;

/*import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;*/
import java.io.Serializable;
import java.util.StringJoiner;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.sudoku.exception.NoAvaibleClone;


public class SudokuField implements Serializable, Comparable<SudokuField>, Cloneable {
    private int value = 0;
    private SudokuColumn column;
    private SudokuRow row;
    private SudokuBox box;


    public SudokuField() {

    }

    public int getFieldValue() {
        return value;
    }

    public void setColumn(SudokuColumn column) {
        this.column = column;
    }

    public void setRow(SudokuRow row) {
        this.row = row;
    }

    public void setBox(SudokuBox box) {
        this.box = box;
    }

    public SudokuColumn getColumn() {
        return column;
    }

    public SudokuRow getRow() {
        return row;
    }

    public SudokuBox getBox() {
        return box;
    }

    public void setFieldValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SudokuField that = (SudokuField) o;
        return new EqualsBuilder().append(value, that.value).append(getColumn(),
                that.getColumn()).append(getRow(), that.getRow()).append(getBox(),
                that.getBox()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(value).append(getColumn()).append(getRow()).append(getBox())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SudokuField.class.getSimpleName() + "@"
                + Integer.toHexString(this.hashCode()) + "[", "]")
                .add("value=" + value)
                .add("column=" + column)
                .add("row=" + row)
                .add("box=" + box)
                .toString();
    }

    @Override
    public SudokuField clone() throws NoAvaibleClone {
        /*try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream ous = new ObjectOutputStream(baos);
             ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
             ObjectInputStream ois = new ObjectInputStream(bais)) {
                ous.writeObject(this);
                ous.close();
            return (SudokuField)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/
        try {
            return (SudokuField) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new NoAvaibleClone(e);
        }
    }

    @Override
    public int compareTo(SudokuField o) {
        if (o == null) {
            throw new NullPointerException();
        } else if (o.getFieldValue() > this.getFieldValue()) {
            return -1;
        } else if (o.getFieldValue() < this.getFieldValue()) {
            return 1;
        }
        return 0;
    }
}