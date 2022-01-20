package medium;

import java.util.HashSet;

public class UniqueTuples {

    public static HashSet<String> uniqueTuples(String input, int len) {
        // your code
        if(input==null || len<1 || input.length()<1 )   return new HashSet<>();

        HashSet<String> result = new HashSet<String>();
        for (int i = 0; i < input.length() - len + 1; i++) {
            result.add(input.substring(i, i + len));
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        String input = "aaab";
        HashSet<String> result = uniqueTuples(input, 2);
        if (result.contains("aa") && result.contains("ab")) {
            System.out.println("Test passed.");

        } else {
            System.out.println("Test failed.");

        }
    }
}