package vn.magik.hometest.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CalculatorTextHelper {
    public static List<String> splitWord(List<String> keyWords){
        List<String> result = new ArrayList<>();

        for (String word : keyWords){

            List<String> words = new LinkedList<>(Arrays.asList(word.split("\\s")));

            StringBuilder lineOne = new StringBuilder();
            StringBuilder lineTwo = new StringBuilder();

            while(words.size()!=0){
                if (lineOne.length()<=lineTwo.length()){
                    lineOne.append(words.get(0)).append(" ");
                    words.remove(0);
                } else {
                    lineTwo.insert(0, " ").insert(0, words.get(words.size()-1));
                    words.remove(words.size()-1);
                }
            }

            if (lineTwo.toString().length()==0){
                result.add(lineOne.toString().trim());
            } else {
                result.add(
                        lineOne.append(System.lineSeparator())
                                .append(lineTwo.toString()).toString().trim()
                );
            }
        }

        return result;
    }

}
