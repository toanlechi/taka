package vn.magik.hometest.helpers;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Class handle all issues data.
 */
public class CalculatorTextHelper {
    /**
     * Prepare word. If the keyword is more than one word, then display in two lines.
     * These two lines should have minimum difference in length.
     *
     * @param keywords keyword list input
     * @return keyword list has been precessed
     */
    public static List<String> formatWord(List<String> keywords) {
        List<String> result = new ArrayList<>();

        for (String word : keywords) {
            if (word != null) {
                result.add(formatWord(word));
            }
        }

        return result;
    }

    /**
     * Prepare word. If the keyword is more than one word, then display in two lines.
     * These two lines should have minimum difference in length.
     *
     * @param word keyword input
     * @return keyword has been precessed
     */
    public static String formatWord(String word) {
        if (word != null) {
            if (!word.trim().contains(" ")) {
                // If word is single then add to result
                return word.trim();
            } else {
                // String contain line one
                StringBuilder lineOne = new StringBuilder();
                // String contain line two
                StringBuilder lineTwo = new StringBuilder();

                List<String> words = new LinkedList<>(Arrays.asList(word.split("\\s")));

                while (words.size() != 0) {
                    // If length lineOne is less than or equal to lineTwo then add word first to lineOne
                    if (lineOne.length() <= lineTwo.length()) {
                        lineOne.append(words.get(0)).append(" ");
                        words.remove(0);
                    } else {
                        // Otherwise add word last to first lineTwo
                        lineTwo.insert(0, " ").insert(0, words.get(words.size() - 1));
                        words.remove(words.size() - 1);
                    }
                }

                // Add word after handle
                return String.format("%s\n%s",
                        lineOne.toString().trim(),
                        lineTwo.toString().trim());
            }
        } else {
            return "";
        }
    }

    /**
     * Convert JSONArray to list string.
     *
     * @param data data json
     * @return list string
     */
    public static List<String> convertJSONToListKeyword(Object data) {
        List<String> result = new ArrayList<>();
        try {
            if (data instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) data;
                for (int i = 0; i < jsonArray.length(); i++) {
                    result.add(jsonArray.getString(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
