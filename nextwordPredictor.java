package projects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class nextwordPredictor {
    public static void main(String[] args) {
        String input = "Sun and Moon";
        String[] phrasesToList = generatePredictedText(input, true);

        for (int i = 0; i < phrasesToList.length; i++) {
            System.out.println(phrasesToList[i]);
        }
    }

    public static String[] generatePredictedText(String userInput, boolean caseSensitive) {
        String[] listOfAllPhrases = getWords("C:\\Users\\hp\\eclipse-workspace\\firstproject\\src\\projects\\pokemoncardsets.txt");

        return generatePhraseList(userInput, listOfAllPhrases, caseSensitive);
    }

    public static String[] generatePhraseList(String userInput, String[] listOfPhrases, boolean caseSensitive) {
        ArrayList<String> phrases = new ArrayList<>();
        for (int i = 0; i < listOfPhrases.length; i++) {
            if (caseSensitive) {
                if (listOfPhrases[i].startsWith(userInput)) {
                    phrases.add(listOfPhrases[i]);
                }
            } else {
                if (listOfPhrases[i].toUpperCase().startsWith(userInput.toUpperCase())) {
                    phrases.add(listOfPhrases[i]);
                }
            }
        }

        return phrases.toArray(new String[0]);
    }

    public static String[] getWords(String filepath) {
        ArrayList<String> phrases = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                phrases.add(currentLine);
            }
            bufferedReader.close();
            fileReader.close();
            Collections.sort(phrases);
        } catch (Exception e) {
            phrases.add(e.toString());
        }
        return phrases.toArray(new String[0]);
    }
}
