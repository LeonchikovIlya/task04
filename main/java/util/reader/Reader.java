package util.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Reader {

    public static String readFromFile(String path) {

        String result = null;
        StringBuilder stringBuilder = new StringBuilder();

        if (path != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {// read byte!
                String str;
                while ((str = br.readLine()) != null) {
                    stringBuilder.append(str).append("\n");
                }
                result = stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
