package fube;

import java.math.BigDecimal;

public class Main {

    static class Numbers{

        /**
         * Find PI to the Nth Digit:
         * Enter a number and have the program generate PI up to that many decimal places.
         * Keep a limit to how far the program will go.
         *
         * @param   lim Limits decimal places (lim <= 50)
         * @return  PI limited to lim decimal places
         */
        static BigDecimal piToTheNthDigit(int lim){

            if(lim > 50)
                throw new IllegalArgumentException("lim must be lower than or equal to 50");

            BigDecimal  foo = BigDecimal.TEN.pow(lim),
                        bar = new BigDecimal("3.1415926535897932384626433832795028841971693993751058209749445923078");

            return new BigDecimal(bar.multiply(foo).toBigInteger()).divide(foo);
        }

        /**
         * Find E to the Nth Digit:
         * Enter a number and have the program generate E up to that many decimal places.
         * Keep a limit to how far the program will go.
         *
         * @param   lim Limits decimal places (lim <= 50)
         * @return  E limited to lim decimal places
         */
        static BigDecimal eToTheNthDigit(int lim){
            if(lim > 50)
                throw new IllegalArgumentException("lim must be lower than or equal to 50");

            BigDecimal  foo = BigDecimal.TEN.pow(lim),
                    bar = new BigDecimal("2.71828182845904523536028747135266249775724709369995957496696762772407663");
            return new BigDecimal(bar.multiply(foo).toBigInteger()).divide(foo);
        }
    }



    public static void main(String[] args) {
        System.out.println(Numbers.piToTheNthDigit(49));
        System.out.println(Numbers.eToTheNthDigit(2));
    }
}
