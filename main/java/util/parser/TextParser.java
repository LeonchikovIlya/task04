package util.parser;

import model.Composite;
import model.entity.*;

import java.util.regex.Pattern;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class TextParser extends Parser {

    private static final String STRINGS_REGEX = "\n";
    private static final String ONLY_TEXT_PARAGRAPHS_REGEX = "^[A-Z](.+)([\\Q!?:.\\E])$|(^[-].+$)";

    @Override
    public Composite parse(String text) {

        Composite wholeText = new Text();

        Pattern p1 = Pattern.compile(STRINGS_REGEX);

        String[] textArray = p1.split(text);

        for (String s : textArray) {

            if (s.matches(ONLY_TEXT_PARAGRAPHS_REGEX)) {

                if (getNext() != null) {
                    wholeText.addComponent(getNext().parse(s));
                } else {
                    wholeText.addComponent(new IndivisiblePart(s));
                }
            } else {
                wholeText.addComponent(new CodeBlock(s));
            }
        }

        return wholeText;
    }
}
