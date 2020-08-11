package fube;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Numbers{

    private static Set findFactors(int num){

        Set foo = new HashSet<Integer>();
        for(int i = 1; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                foo.add(i);
                foo.add(num / i);
            }
        }
        return foo;
    }

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

        Set foo = new HashSet<Integer>(){{add(1);}};
        for (int i = 2; i <= Math.sqrt(num); i++){
            while(num % i == 0){
                foo.add(i);
                num/=i;
            }
        }
        foo.add(num);
        return foo;
    }

    /**
     * Next Prime Number:
     * Have the program find prime numbers until the user chooses to stop asking for the next one.
     */
    static void nextPrimeNumber(){

        Scanner sc = new Scanner(System.in);

        for(int i = 1;;i+=2){

            if(findFactors(i).size() <= 2) {
                System.out.println("Found prime number " + i);
                System.out.println("Continue?");
                if (!sc.nextLine().toLowerCase().equals("y"))
                    return;
            }
        }
    }

    /**
     * Mortgage Calculator:
     * Calculate the monthly payments of a fixed term mortgage over given Nth terms at a given interest rate.
     * Also figure out how long it will take the user to pay back the loan.
     * For added complexity, add an option for users to select the compounding interval (Yearly, Quarterly, Monthly, Bi-weekly, Weekly, Daily).
     *
     * @param amount amount of money loaned
     * @param time amortization period
     * @param rate interest rate
     * @param sInterval type of interval
     * @return a tuple containing the payment per interval & the time in months that it will take to pay back the loan.
     */
    static List mortgageCalc(double amount, double time, double rate, String sInterval){

        int interval;

        switch(sInterval.toLowerCase()){
            case "yearly":
                interval = 1;
                break;
            case "quarterly":
                interval = 4;
                break;
            case "monthly":
                interval = 12;
                break;
            case "semimonthly":
            case "semi-monthly":
            case "biweekly":
            case "bi-weekly":
                interval = 24;
                break;
            //Yes I know there are 52 weeks in a year but I chose to do it this way cause it makes more sense in this scenario.
            case "weekly":
                interval = 48;
                break;
            case "daily":
                interval = 365;
                break;
            default:
                throw new IllegalArgumentException("Illegal interval");
        }

        final double foo = rate/100/interval,
                     payPer = foo / (1 - Math.pow(foo+1, -(interval * time))) * amount;

        double j = 0;
        while (amount > 0) {
            j++;
            amount -= payPer - foo * amount;
        }
        final double amorti = j;

        return new ArrayList<Double>(){{add(payPer); add(amorti);}};
    }


}

public class Main {

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

        print("primeFactorization", Numbers.primeFactorization(Integer.MAX_VALUE - 1));

        //Numbers.nextPrimeNumber();
        print("mortgageCalc", Numbers.mortgageCalc(500, 0.5, 2.92, "monthly"));

    }
}
