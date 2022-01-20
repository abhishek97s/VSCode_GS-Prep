package medium;

public class PowerCalc {

    public static double solution3(double base, int exponent) {
        if (base == 0)
            return 0;
        if (exponent == 0)
            return 1;
        if (base == 1 || exponent == 1)
            return base;

        if (exponent > 0)
            return (base * solution3(base, exponent - 1));
        else
            return (1 / solution3(base, -exponent));

    }

    public static void main(String[] args) {
        checkTestCase();
    }

    public static void checkTestCase() {

        boolean result = true;
        result &= solution3(2, 5) == 32;
        result &= solution3(5, -2) == 0.04;
        result &= solution3(4, 3) == 64;
        result &= solution3(2, 5) == 32;
        result &= solution3(2, 4) == 16;
        result &= solution3(5, -2) == 0.04;
        result &= solution3(4, 1) == 4;
        result &= solution3(0, 1) == 0;
        result &= solution3(1, 5) == 1;
        result &= solution3(5, -3) == 0.008;
        result &= solution3(-4, -3) == -0.015625;

        if (result) {
            System.out.println("passed");
        } else
            System.out.println("failed");

    }
}
