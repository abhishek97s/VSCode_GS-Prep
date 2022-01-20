package medium;

import java.util.HashSet;
import java.util.Set;

public class Pangram {
	private static class PanagramDetector {

		public String findMissingLetters(String sentence) {
			Set<Character> charsPresent= new HashSet<>();

            for(char c: sentence.toCharArray()){
                charsPresent.add(c);
            }

            StringBuilder sb= new StringBuilder();

            for(char c= 'a'; c<= 'z'; c++){
                if(!charsPresent.contains(c))   sb.append(c);                
            }
            return sb.toString();
		}

	}

	public static void main(String[] args) {
		PanagramDetector pd = new PanagramDetector();
		boolean success = true;

		success = success && "".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dog"));
		success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));

		if (success) {
			System.out.println("Pass ");
		} else {
			System.out.println("Failed");
		}
	}
}
