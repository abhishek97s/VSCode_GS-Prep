package medium;

/*
Question: 
Combine ingredients in a specific order, any of which may be repeated

As an example, consider the following  
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E 

Encode the string above using only 6 characters: A,B,*,C,*,E

Implement function that takes as input an un-encoded potion and returns the 
minimum number of characters required to encode

*/

public class MagicPotion
{
  private static int minimalSteps( String ingredients )
  {
        int len= ingredients.length();

        if(len<1)   return -1;

        StringBuilder magicPotion= new StringBuilder();
        magicPotion.append(ingredients.charAt(0));

        for(int i=1; i<len; i++){
            if(i*2 <= len && ((ingredients.substring(0, i)).equals(ingredients.substring(i, i*2)))){
                    magicPotion.append("*");
                    i= i*2-1;
            }
            else
                magicPotion.append(ingredients.charAt(i));
        }
        System.out.println(magicPotion.toString());
        return magicPotion.length();
	}

	public static void main(String[] args) {

		if (minimalSteps("ABABCABABCE") == 6 && minimalSteps("ABCABCE") == 5) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
}