package high;

import java.util.*;

public class DecimalConversion1 {
    /**
     * Return the fraction output in the following way Examples: If after decimal,
     * repeating numbers are there in the output . eg. 1/3=0.333333333, this should
     * be represented as 0.(3) 6/11=0.54545454, this should be represented as 0.(54)
     * fractionRepresentation(1,2)=0.5 fractionRepresentation(1,3)=0.(3)
     * fractionRepresentation(6,11)=0.(54)
     */
    public static String fractionRepresentation(int num, int den) {
        if (num == 0)
            return "0";
        if (den == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        if (num < 0 || den < 0)
            sb.append("-");

        num = Math.abs(num);
        den = Math.abs(den);

        long ans = num / den;

        long reminder = num % den * 10;
        sb.append(String.valueOf(ans));
        if (reminder == 0)
            return sb.toString();

        sb.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while (reminder != 0) {
            if (map.containsKey(reminder)) {

                String s1 = sb.substring(0, map.get(reminder));
                String s2 = sb.substring(map.get(reminder), sb.length());

                return s1 + "(" + s2 + ")";
            }

            map.put(reminder, sb.length());
            ans = reminder / den;
            sb.append(String.valueOf(ans));
            reminder = (reminder % den) * 10;
        }
        return sb.toString();
    }

    public static void main(String args[]) {

        System.out.println(fractionRepresentation(1, 2) + " " + fractionRepresentation(1, 3) + " "
                + fractionRepresentation(6, 11) + " " + fractionRepresentation(1, 0) + " "
                + fractionRepresentation(428, 125)
                + " " + fractionRepresentation(47, 18) + " " + fractionRepresentation(-1, 2)
                + " " + fractionRepresentation(22, 7)

        );

        if (fractionRepresentation(1, 2).equals("0.5") 
                && fractionRepresentation(6, 11).equals("0.(54)")
                && fractionRepresentation(1, 0).equals("0")
                && fractionRepresentation(428, 125).equals("3.424")
                && fractionRepresentation(47, 18).equals("2.6(1)")

        ) {
            System.out.println("All passed");
        } else {
            System.out.println("Failed");
        }

    }
}