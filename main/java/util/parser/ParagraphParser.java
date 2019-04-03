package util.parser;

import model.Composite;
import model.entity.IndivisiblePart;
import model.entity.Paragraph;
import model.entity.Punct;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class ParagraphParser extends Parser {

    private static final String SENTENCE_REGEX = "[\\Q?!.\\E]";

    @Override
    public Composite parse(String string) {

        Composite paragraph = new Paragraph();

        Pattern p3 = Pattern.compile(SENTENCE_REGEX);
        Matcher m1 = p3.matcher(string);

        String[] sentencesArray = p3.split(string);

        for (String s : sentencesArray) {

            if (m1.find()) {

                if (getNext() != null) {
                    paragraph.addComponent(getNext().parse(s + m1.group()));
                } else {
                    paragraph.addComponent(new IndivisiblePart(s + m1.group()));
                }
            }
        }
        return paragraph;
    }

}
