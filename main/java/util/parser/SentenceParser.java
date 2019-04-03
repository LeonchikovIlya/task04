package util.parser;

import model.Composite;
import model.entity.Punct;
import model.entity.Sentence;
import model.entity.Word;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class SentenceParser extends Parser {

    private static final String WORDS_AND_PUNCT_REGEX = "([\\W]?\\s)|([\\Q?!.\\E])";

    @Override
    public Composite parse(String string) {

        Composite sentence = new Sentence();

        Pattern p4 = Pattern.compile(WORDS_AND_PUNCT_REGEX);

        Matcher m2 = p4.matcher(string);

        String[] wordsArray = p4.split(string);

        for (String s : wordsArray) {

            sentence.addComponent(new Word(s));

            if (m2.find()) {
                sentence.addComponent(new Punct(m2.group()));

            }
        }
        return sentence;
    }
}
