package low;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeFactorization {
    public static ArrayList<Integer> primeFactorization(int x) {
        ArrayList<Integer> primeFac = new ArrayList<Integer>();

        //Edge cases
        if(x< 2)    return primeFac;
        if(x==2){
            primeFac.add(2);
            return primeFac;
        }

        int temp = x;
        for(int i= 2; i<= Math.sqrt(temp); i++) {
            if(x % i == 0) {
                primeFac.add(i);
                while(x % i == 0 && x > 1)
                    x /= i;
            }
        }

        if(x> 2)    primeFac.add(x);

        return primeFac;
    }

    public static void main(String args[]) {

        System.out.println(primeFactorization(315) + " " + primeFactorization(5));
        if (primeFactorization(42).equals(Arrays.asList(2, 3, 7))
                &&
                primeFactorization(5).equals(Arrays.asList(5))) {
            System.out.println("All passed");
        } else {
            System.out.println("Failed");
        }

    }
}
