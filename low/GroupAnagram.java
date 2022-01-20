package low;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * This program prints set of anagrams together in given string 
 * 
 * eg. 
 * setOfAnagrams("cat dog tac sat tas god dog") should print "cat tac dog god dog sat tas"
 *
 */

public class GroupAnagram {

    static String input = "cat dog tac sat tas god dog";

    static void setOfAnagrams(String inputString) {

        // your code goes here
        Map<String, ArrayList<String>> list = new HashMap<>();

        String[] words = inputString.split(" ");

        for (String word : words) {
            char[] chArr = word.toCharArray();
            Arrays.sort(chArr);
            String temp = new String(chArr);
            if (!list.containsKey(temp))
                list.put(temp, new ArrayList<>());
            list.get(temp).add(word);
        }
        System.out.println(list);

        list.keySet().stream()
                .filter(
                        k -> list.get(k).size() > 1)
                .forEach(
                        k -> list.get(k).forEach(
                                v -> System.out.print(v + " ")));
    }

    public static void main(String[] args) {

        String input = "cat dog tac sat tas god dog";
        setOfAnagrams(input);

    }
}
