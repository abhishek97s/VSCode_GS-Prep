package low;

/**
 *
 * Given two arrays of integers, returns the dot product of the arrays
 */
public class DotProduct {
    public static int dotProduct(int[] array1, int[] array2) {
        int ans = 0;
        for (int i = 0; i < array1.length && i < array2.length; i++) {
            ans += array1[i] * array2[i];
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(doPass());
    }

    private static boolean doPass() {
        int[] array1 = { 1, 2 };
        int[] array2 = { 2, 3 };
        int result = dotProduct(array1, array2);

        if (result == 8) {
            System.out.println("Passed.");
            return true;
        } else {
            System.out.println("Failed.");
            return false;
        }
    }
}