package org.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public abstract class SudokuGroups {
    protected List<SudokuField> fields = new ArrayList<>();

    SudokuGroups(final ArrayList<SudokuField> fields) {
    this.fields = fields;
    }

    public boolean verify() {
        for (int j = 0; j < 9; j++) {
            for (int k = j + 1; k < 9; k++) {
                if (k != j && fields.get(k).getFieldValue() == fields.get(j).getFieldValue()
                        && fields.get(k).getFieldValue() != 0
                        && fields.get(j).getFieldValue() != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getFields() {
        String str = "";
        for (int i = 0; i < 9; i++) {
            str = str + fields.get(i).getFieldValue() + " ";
        }
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SudokuGroups that = (SudokuGroups) o;
        return new EqualsBuilder().append(getFields(), that.getFields()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getFields()).toHashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SudokuGroups.class.getSimpleName() + "@"
                + Integer.toHexString(this.hashCode()) + "[", "]")
                .add("fields = " + this.getFields())
                .toString();
    }
}
