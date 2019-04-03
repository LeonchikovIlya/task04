package model;

import java.util.Objects;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Leaf implements Component {

    private String string;

    public Leaf() {
        this.string = "";
    }

    public Leaf(String string) {
        if (string != null) {
            this.string = string;
        }
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        if (string != null) {
            this.string = string;
        }
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Leaf leaf = (Leaf) o;
        return Objects.equals(string, leaf.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }
}
