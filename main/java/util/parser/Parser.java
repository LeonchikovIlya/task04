package util.parser;

import model.Composite;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public abstract class Parser {

    private Parser next;

    public Parser() {
    }

    public void setNext(Parser next) {

        if (next != null) {
            this.next = next;
        }
    }

    public Parser getNext() {
        return next;
    }

    public abstract Composite parse(String string);

}
