<<<<<<< HEAD
package com.sudoku.view;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX () {
        return this.x;
    }

    public int getY () {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return new EqualsBuilder().append(getX(), that.getX()).append(getY(), that.getY()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getX()).append(getY()).toHashCode();
    }
}
=======
package com.sudoku.view;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX () {
        return this.x;
    }

    public int getY () {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return new EqualsBuilder().append(getX(), that.getX()).append(getY(), that.getY()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getX()).append(getY()).toHashCode();
    }
}
>>>>>>> dbe782392f5324cc6875fc91ded96701cc6646e4
