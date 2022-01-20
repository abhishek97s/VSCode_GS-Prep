package low;

import java.util.Arrays;

public class AddFraction {

    /**
     * Given two fractions passed in as int arrays,
     * returns the fraction which is result of adding the two input fractions.
     */
    public static int[] addFractions(int[] fraction1, int[] fraction2) {
        // Write your code here
        if(fraction1 == null || fraction2 == null
            || fraction1.length<2 || fraction2.length <2
        )   return new int[]{};
        
        return new int[] { fraction2[1] * fraction1[0] + fraction2[0] * fraction1[1], fraction1[1] * fraction2[1] };
    }

    public static void main(String[] args) {
        int[] result = addFractions(new int[] { 2, 3 }, new int[] { 1, 2 });
        System.out.println(Arrays.toString(result));
        if (result[0] == 7 && result[1] == 6) {
            System.out.println("Test passed.");
            // return true;
        } else {
            System.out.println("Test failed.");
            // return false;
        }
    }
}