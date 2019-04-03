package controller;

import model.Component;
import model.entity.*;
import model.logic.Sorter;
import util.parser.ParagraphParser;
import util.parser.SentenceParser;
import util.parser.TextParser;
import util.reader.Reader;
import view.ConsolePrinter;
import view.FilePrinter;
import view.Printable;
import view.Printer;


/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Controller {

    public static void main(String[] args) {

        String wholeText = Reader.readFromFile("C:\\Users\\User\\IdeaProjects" +
                "\\Task04\\src\\main\\java\\util\\input\\input");

        TextParser textParser = new TextParser();

        ParagraphParser paragraphParser = new ParagraphParser();
        textParser.setNext(paragraphParser);
        SentenceParser sp = new SentenceParser();
        paragraphParser.setNext(sp);


        Text text = (Text) textParser.parse(wholeText);


        Printable filePrinter = Printer.createPrinter(Printer.Type.FILE);


        Printable consolePrinter = Printer.createPrinter(Printer.Type.CONSOLE);

      //  consolePrinter.print(text);

       /* for (String string : Sorter.byFirstConsonant(text)) {
            consolePrinter.print(string);
        }*/

        /*for (Component component : Sorter.bySentenceLength(text)) {
            consolePrinter.print(component);
        }*/

    }
}
