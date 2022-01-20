package low;

import java.util.Arrays;

public class SmallestNumber {
    public static int secondSmallest(int[] x) {
        // Your code

        // Java 8
        return x==null || x.length==0 ? 0 : Arrays.stream(x).sorted().limit(2).max().orElse(0);
    }

    public static int FindMin(int a[]) {
        /*
         ** Your code goes here
         */

        // Java 8
        return a==null || a.length==0 ? 0 : Arrays.stream(a).min().orElse(0);

    }

    public static void main(String args[]) {

        int[] a = { 0 };
        int[] b = { 0, 1 };

        boolean result = true;
        //secondSmallest method test cases
        result &= secondSmallest(a) == 0;
        result &= secondSmallest(b) == 1;

        result &= secondSmallest(new int[] { 3, 4, 5, 6, 1, 2 }) == 2;
        result &= secondSmallest(new int[] { 1 }) == 1;
        result &= secondSmallest(new int[]{}) == 0;
        result &= secondSmallest(null) == 0;


        // findMin method test cases
        result = result && FindMin(new int[] { 3, 4, 5, 6, 1, 2 }) == 1;
        result = result && FindMin(new int[] { 2, 1 }) == 1;
        result = result && FindMin(new int[] { 1 }) == 1;
        result = result && FindMin(new int[] { }) == 0;
        result = result && FindMin(null) == 0;

        if (result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}