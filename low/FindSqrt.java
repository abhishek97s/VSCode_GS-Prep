package low;

public class FindSqrt {
    /*
     * double squareRoot( double x )
     *
     */

    // sqrt<n+1>=(sqrt<n>+(num/sqrt<n>))/2.0

    public static double squareRoot(double x) {
        // temporary variable to calculate squareroot
        double t;
        double sqrtroot = x / 2; // let the square root is half of the number
        do {
            t = sqrtroot;
            sqrtroot = (t + (x / t)) / 2;
        } while ((t - sqrtroot) != 0);
        return sqrtroot;
    }

    public static void main(String args[]) {
        double[] inputs = { 2, 4, 100, 1 };
        double[] expected_values = { 1.41421, 2, 10, 1};
        double threshold = 0.001;
        for (int i = 0; i < inputs.length; i++) {
            if (Math.abs(squareRoot(inputs[i]) - expected_values[i]) > threshold) {
                System.out.printf("Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i],
                        squareRoot(inputs[i]));
            }
        }
        System.out.println("All tests passed");
    }
}
