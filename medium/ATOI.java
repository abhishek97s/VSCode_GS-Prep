package medium;

public class ATOI {

    // Takes a string str and returns the int value represented by
    // the string.
    // For example, atoi("42") returns 42.

    public static int atoi(String str) {
        if (str == null || str.length() == 0 || str.length() == 1
                && (str.charAt(0) == '-' || str.charAt(0) > '9' || str.charAt(0) < '0'))
            return 0;

        if (str.charAt(0) == '-' && str.length() > 1)
            return -atoi(str.substring(1, str.length()));

        if (str.length() == 1 && ('9' <= str.charAt(0) || str.charAt(0) >= '0'))
            return (str.charAt(0) - '0');
        else
            return atoi(str.substring(0, str.length() - 1)) * 10 + (str.charAt(str.length() - 1) - '0');

    };

    public static boolean pass() {
        System.out.println(atoi("-155123"));
        System.out.println(atoi("----"));
        System.out.println(atoi("-1"));
        System.out.println(atoi("-a"));
        System.out.println(atoi("1"));
        System.out.println(atoi("11"));
        System.out.println(atoi("-15"));
        boolean result = true;
        // result = result && (atoi("-3") == -3);
        result = result && (atoi("151") == 151);
        result = result && (atoi(null) == 0);
        result = result && (atoi("15") == 15);
        result = result && (atoi("") == 0);
        result = result && (atoi("-111151") == -111151);

        return result;
    };

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("Pass");
        } else {
            System.out.println("Some fail");
        }
    }
}