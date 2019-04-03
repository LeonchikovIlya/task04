package model.entity;

import model.Component;
import model.Composite;


/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Text extends Composite {

    public Text() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Component component : getChild()){
            builder.append(component).append("\n");
        }
        return builder + "";
    }
}
