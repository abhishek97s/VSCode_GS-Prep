package high;

import java.util.Arrays;

//Implement the 'walk' method.
//Assume robot inital position is (0,0).
//walk method take path where each character corresponds to a movement of the robot.
// The robot moves up, down, left, and right represented by the characters 'U', 'D', 'L', and 'R'
// Ignore other characters.

public class RobotMovement {

    // your code
    public static Integer[] walk(String path) {
        if(path== null || path.length()==0)     return new Integer[]{0, 0};
        int x = 0, y = 0;
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'U':
                    y += 1;
                    break;

                case 'D':
                    y -= 1;
                    break;

                case 'L':
                    x -= 1;
                    break;

                case 'R':
                    x += 1;
                    break;
            }
        }
        // System.out.println(x + " "+y);
        return new Integer[] { x, y };
    }

    public static boolean isEqual(Integer[] a, Integer[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean pass() {
        boolean res = true;

        {
            String test = "UUU";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[] { 0, 3 });
        }

        {
            String test = "ULDR";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[] { 0, 0 });
        }

        {
            String test = "ULLLDUDUURLRLR";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[] { -2, 2 });
        }

        {
            String test = "UP LEFT 2xDOWN DOWN RIGHT RIGHT UP UP";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[] { 1, 1 });
        }
        {
            String test = "";
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[] { 0, 0 });
        }
        {
            String test = null;
            Integer[] result = walk(test);
            res &= isEqual(result, new Integer[] { 0, 0 });
        }

        return res;
    }

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test failures");
        }
    }
}
