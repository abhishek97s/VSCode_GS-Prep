package high;

import java.util.*;

class Dictionary {
    private String[] entries;

    public Dictionary(String[] entries) {
        this.entries = entries;
    }

    public String[] getEntries() {
        return entries;
    }

    public boolean contains(String word) {
        return Arrays.asList(entries).contains(word);
    }
}

public class DictionaryLongestWord {

    public static Set<String> longestWord(String letters, Dictionary dict) {

        if (letters == null || dict == null || letters.length() == 0)
            return Collections.emptySet();

        Set<String> words = new HashSet<>();
        int maxLen = 0;

        for (String word : dict.getEntries()) {
            if(word!=null && word.chars().allMatch(idx -> letters.indexOf(idx)>=0)){
                if(word.length()==maxLen)
                    words.add(word);
                if(word.length()>maxLen){
                    words.clear();
                    words.add(word);
                    maxLen= word.length();
                }
            }
        }
        System.out.println(words);
        return words;
    }

    public static boolean pass() {
        Dictionary dict = new Dictionary(
                new String[] { "to", "toe", "toee", "toes", "tooe", null, "dog", "god", "dogs", "banana" });
        boolean r = new HashSet<String>(Arrays.asList("tooe", "toee")).equals(longestWord("toee", dict));
        return r;
    }

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("Pass");
        } else {
            System.err.println("Fails");
        }
    }
}