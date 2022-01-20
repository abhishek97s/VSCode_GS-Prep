package medium;

// find the median of the two sorted arrays.
// ex. {1, 3} and {2} is 2

public class MedianSortedArrays {

    static double getMedian(int ar1[], int ar2[], int n, int m) {

        if ((ar1 == null && ar2 == null) || (n == 0 && m == 0))
            return 0.0;

        if (ar1 == null || ar1.length == 0)
            ar1 = new int[] {};
        if (ar2 == null || ar2.length == 0)
            ar2 = new int[] {};

        int idx1 = 0, idx2 = 0;
        int m1 = -1, m2 = -1;

        // Odd case, length is not divisible by 2
        if ((m + n) % 2 == 1) {
            for (int i = 0; i <= (m + n) / 2; i++) {
                if (idx1 < n && idx2 < m)
                    m1 = (ar1[idx1] > ar2[idx2]) ? ar2[idx2++] : ar1[idx1++];
                else if (idx1 < n)
                    m1 = ar1[idx1++];
                else
                    m1 = ar2[idx2++];
            }
            System.out.println(m1);
            return (double)m1;
        } else {    //Even length case, total length is divisble by 2
            for (int i = 0; i <= (m + n) / 2; i++) {
                m2 = m1;
                if (idx1 < n && idx2 < m)
                    m1 = (ar1[idx1] > ar2[idx2]) ? ar2[idx2++] : ar1[idx1++];
                else if (idx1< n)
                    m1 = ar1[idx1++];
                else
                    m1 = ar2[idx2++];
            }
            System.out.println((m1 + m2) / 2.0);
            return (m1 + m2) / 2.0;
        }

    }

    // Driver code
    public static void main(String[] args) {
        System.out.println(getMedian(new int[] { 2, 3, 5, 8 }, null, 4, 0));

        boolean result = true;
        result = result && (getMedian(new int[] { 1, 3 }, new int[] { 2, 4 }, 2, 2) == 2.5);
        System.out.println(result);
        result = result && getMedian(new int[] { 1, 3 }, new int[] { 2 }, 2, 1) == 2;
        System.out.println(result);
        // {1, 2, 3, 4}
        result = result && getMedian(new int[] { -5, 3, 6, 12, 15 }, new int[] { -12, -10, -6, -3, 4, 10 }, 5, 6) == 3;
        System.out.println(result);
        result = result && getMedian(new int[] { 2, 3, 5, 8 }, new int[] { 10, 12, 14, 16, 18, 20 }, 4, 6) == 11;
        System.out.println(result);
        result = result && getMedian(null, null, 0, 0) == 0.0;
        System.out.println(result);
        result = result && getMedian(new int[] { 2, 3, 5, 8 }, null, 4, 0) == 4;
        System.out.println(result);
        result = result && getMedian(null, new int[] { 2, 3, 5, 8 }, 0, 4) == 4;
        System.out.println(result);
        result = result && getMedian(null, new int[] { 2, 3, 5 }, 0, 3) == 3;
        System.out.println(result);
        result = result && getMedian(null, new int[] {}, 0, 0) == 0;
        System.out.println(result);
        result = result && getMedian(new int[] {}, new int[] { 2, 3, 5 }, 0, 3) == 3;
        /*
          */

        System.out.println(result);
    }
}

/*
 * result = result && logic(new int[] { 1, 3 }, new int[] { 2, 4 }) == 2.5;
 * result = result && logic(new int[] { 1, 3 }, new int[] { 2 }) == 2;
 * // {1, 2, 3, 4}
 * result = result && logic(new int[] { -5, 3, 6, 12, 15 }, new int[] { -12,
 * -10, -6, -3, 4, 10 }) == 3;
 * result = result && logic(new int[] { 2, 3, 5, 8 }, new int[] { 10, 12, 14,
 * 16, 18, 20 }) == 11;
 * result = result && logic(null, null) == 0.0;
 * result = result && logic(new int[] { 2, 3, 5, 8 }, null) == 4;
 * result = result && logic(null, new int[] { 2, 3, 5, 8 }) == 4;
 * result = result && logic(null, new int[] { 2, 3, 5 }) == 3;
 * result = result && logic(null, new int[] {}) == 0;
 * result = result && logic(new int []{}, new int[] { 2, 3, 5 }) == 3;
 * 
 * 
 * 
 */