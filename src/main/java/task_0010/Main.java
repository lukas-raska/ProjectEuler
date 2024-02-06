package task_0010;

//The sum of the primes below 10 is 2+3+5+7=17

//Find the sum of all the primes below two million

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        System.out.println("Answer: " + getSumOfPrimes(2000000));

    }

    public static long getSumOfPrimes(int upperLimit){
        BigInteger prime = new BigInteger("2");
        long sum = 0;
        do {
            sum+=prime.longValue();
            prime=prime.nextProbablePrime();
        }while (prime.longValue()<upperLimit);
        return sum;
    }
}
