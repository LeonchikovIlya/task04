package model.logic;

import model.Component;
import model.comparator.ConsonantsComparator;
import model.entity.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Sorter {

    public static List<Component> bySentenceLength(Text text) {

        List<Component> list = new ArrayList<>();

        for (Component component : text.getChild()) {
            if (component instanceof Paragraph) {
                list.addAll(((Paragraph) component).getChild());
            }
        }
        list.sort(Comparator.comparingInt(o -> o.toString().length()));

        return list;
    }

    public static List<String> byFirstConsonant(Text text) {

        List<String> list = new ArrayList<>();

        for (Component component : text.getChild()) {
            if (component instanceof Paragraph) {

                for (Component component2 : ((Paragraph) component).getChild()) {
                    for (Component component3 :((Sentence) component2).getChild()){
                        if (component3 instanceof Word){

                            String pattern = "^(?i:[aeiouy]).*";
                            if (component3.toString().matches(pattern)){
                                list.add(component3.toString());
                            }
                        }

                    }
                }
            }
        }
        list.sort(ConsonantsComparator.getInstance());

        return list;
    }
}
