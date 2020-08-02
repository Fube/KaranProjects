package fube;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

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

        /**
         * Fibonacci Sequence:
         * Enter a number and have the program generate the Fibonacci sequence to that number or to the Nth number.
         *
         * @param lim Limit of the sequence
         * @return ArrayList containing Fibonacci sequence up to lim
         */
        static ArrayList<BigInteger> fibonacciSeq(int lim, ArrayList<BigInteger>foo){

            if(foo.size() == 0){
                foo.add(BigInteger.ZERO);
                foo.add(BigInteger.ONE);
            }

            final int SIZE = foo.size();

            if(foo.size() >= lim)
                return foo;
            foo.add(foo.get(SIZE - 1).add(foo.get(SIZE - 2)));

            return fibonacciSeq(lim, foo);
        }

        /**
         * Prime Factorization:
         * Have the user enter a number and find all Prime Factors (if there are any) and display them.
         *
         * @param num Integer to find prime factors of
         * @return Returns Array of prime factors
         */
        static Set<Integer> primeFactorization(int num){

            Set foo = new HashSet<Integer>();
            for (int i = 2; i < num; i++){
                while(num % i == 0){
                    foo.add(i);
                    num/=i;
                }
            }
            foo.add(num);
            return foo;
        }
    }

    static void print(Object ...args){
        System.out.printf("%s\t:\t%s\n", args[0], args[1]);
    }



    public static void main(String[] args) {

        print("piToTheNthDigit", Numbers.piToTheNthDigit(30));

        print("eToTheNthDigit", Numbers.eToTheNthDigit(20));

        print("fibonacciSeq", Numbers.fibonacciSeq(3, new ArrayList<BigInteger>(){{
            add(new BigInteger("1"));
            add(new BigInteger("1"));
        }}));

        print("primeFactorization", Numbers.primeFactorization(111111));

    }
}
