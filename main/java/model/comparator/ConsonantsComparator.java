package model.comparator;

import model.Component;

import java.util.Comparator;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class ConsonantsComparator implements Comparator<String> {

    private final static Comparator<String> instance = new ConsonantsComparator();
    private final static String CONSONANTS = "BCDFGHJKLMNPQRSTVXZW";

    public static Comparator<String> getInstance() {
        return instance;
    }

    private static boolean isConsonant(Character character) {
        return CONSONANTS.indexOf(Character.toUpperCase(character)) > -1;
    }

    private static Character getFirstConsonant(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (isConsonant(string.charAt(i))) {
                return string.charAt(i);
            }
        }
        return Character.MIN_VALUE;
    }

    @Override
    public int compare(String o1, String o2) {
        return getFirstConsonant(o1) - getFirstConsonant(o2);
    }
}
