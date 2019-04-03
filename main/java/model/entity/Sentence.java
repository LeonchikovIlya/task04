package model.entity;

import model.Component;
import model.Composite;

import java.util.List;
import java.util.Objects;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Sentence extends Composite {

    public Sentence() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Component component : getChild()) {
            builder.append(component);
        }

        return builder + "";
    }
}
