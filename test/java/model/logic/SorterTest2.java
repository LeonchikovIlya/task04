package model.logic;

import model.Component;
import model.entity.*;
import org.junit.BeforeClass;
import org.junit.Test;
import util.parser.ParagraphParser;
import util.parser.SentenceParser;
import util.parser.TextParser;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SorterTest2 {

    private static Text text;

    @BeforeClass
    public static void init() {

        String wholeText = "Hi.My name is Ilya.I'm 23 years old.And i'll test this task!Hey.";

        TextParser textParser = new TextParser();

        ParagraphParser paragraphParser = new ParagraphParser();
        textParser.setNext(paragraphParser);
        SentenceParser sp = new SentenceParser();
        paragraphParser.setNext(sp);

        text = (Text) textParser.parse(wholeText);
    }

    @Test
    public void bySentenceLength() {

        List<Component> list = new ArrayList<>();

        Component firstSentence = new Sentence();
        ((Sentence) firstSentence).addComponent(new Word("Hi"));
        ((Sentence) firstSentence).addComponent(new Punct("."));
        list.add(firstSentence);

        Component secondSentence = new Sentence();
        ((Sentence) secondSentence).addComponent(new Word("Hey"));
        ((Sentence) secondSentence).addComponent(new Punct("."));
        list.add(secondSentence);

        Component thirdSentence = new Sentence();
        ((Sentence) thirdSentence).addComponent(new Word("My"));
        ((Sentence) thirdSentence).addComponent(new Punct(" "));
        ((Sentence) thirdSentence).addComponent(new Word("name"));
        ((Sentence) thirdSentence).addComponent(new Punct(" "));
        ((Sentence) thirdSentence).addComponent(new Word("is"));
        ((Sentence) thirdSentence).addComponent(new Punct(" "));
        ((Sentence) thirdSentence).addComponent(new Word("Ilya"));
        ((Sentence) thirdSentence).addComponent(new Punct("."));
        list.add(thirdSentence);

        Component forthSentence = new Sentence();
        ((Sentence) forthSentence).addComponent(new Word("I'm"));
        ((Sentence) forthSentence).addComponent(new Punct(" "));
        ((Sentence) forthSentence).addComponent(new Word("23"));
        ((Sentence) forthSentence).addComponent(new Punct(" "));
        ((Sentence) forthSentence).addComponent(new Word("years"));
        ((Sentence) forthSentence).addComponent(new Punct(" "));
        ((Sentence) forthSentence).addComponent(new Word("old"));
        ((Sentence) forthSentence).addComponent(new Punct("."));
        list.add(forthSentence);

        Component fifthSentence = new Sentence();
        ((Sentence) fifthSentence).addComponent(new Word("And"));
        ((Sentence) fifthSentence).addComponent(new Punct(" "));
        ((Sentence) fifthSentence).addComponent(new Word("i'll"));
        ((Sentence) fifthSentence).addComponent(new Punct(" "));
        ((Sentence) fifthSentence).addComponent(new Word("test"));
        ((Sentence) fifthSentence).addComponent(new Punct(" "));
        ((Sentence) fifthSentence).addComponent(new Word("this"));
        ((Sentence) fifthSentence).addComponent(new Punct(" "));
        ((Sentence) fifthSentence).addComponent(new Word("task"));
        ((Sentence) fifthSentence).addComponent(new Punct("!"));
        list.add(fifthSentence);

        assertEquals(list,Sorter.bySentenceLength(text));
    }

    @Test
    public void byFirstConsonant() {

        List<String> stringList = new ArrayList<>();

        stringList.add("Ilya");
        stringList.add("old");
        stringList.add("i'll");
        stringList.add("I'm");
        stringList.add("And");
        stringList.add("years");
        stringList.add("is");

        assertEquals(stringList,Sorter.byFirstConsonant(text));
    }
}