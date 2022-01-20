package high;

public class DecimalConversion {
    /**
     * Return the fraction output in the following way Examples: If after decimal,
     * repeating numbers are there in the output . eg. 1/3=0.333333333, this should
     * be represented as 0.(3) 6/11=0.54545454, this should be represented as 0.(54)
     * fractionRepresentation(1,2)=0.5 fractionRepresentation(1,3)=0.(3)
     * fractionRepresentation(6,11)=0.(54)
     */
    public static String fractionRepresentation(int num, int den) {
        double d = (double) num / (double) den;
        String strNum = String.valueOf(d);

        boolean isRepeat = false;

        String befDec = strNum.substring(0, strNum.indexOf(".") + 1);
        String aftDec = strNum.substring(strNum.indexOf(".") + 1, strNum.length());

        String str = "";

        for (int i = 0; i < aftDec.length(); i++) {

            if (str.length() > 0 && (str.length() + i < aftDec.length())
                    && str.equals(aftDec.substring(i, str.length() + i))) {
                isRepeat = true;
                break;
            }
            else
                str = str + aftDec.charAt(i);
        }
        return isRepeat == true ? befDec + "(" + str + ")" : befDec + str;
    }

    public static void main(String args[]) {
        // float f=6/11f;
        // System.out.println(f);
        System.out.println(
                fractionRepresentation(1, 2) + " " 
                + fractionRepresentation(1, 3) + " "
                + fractionRepresentation(6, 11)
                + " " + fractionRepresentation(7, 12)
                + " " + fractionRepresentation(22, 7)
                +" " +fractionRepresentation(-1, 2)
                +" "+fractionRepresentation(47, 18)
                );


        if (fractionRepresentation(1, 2).equals("0.5") && fractionRepresentation(6, 11).equals("0.(54)")
                && fractionRepresentation(1, 3).equals("0.(3)")) {
            System.out.println("All passed");
        } else {
            System.out.println("Failed");
        }

    }
}