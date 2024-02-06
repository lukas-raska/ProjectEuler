package task_0007;

//By listing the first six prime numbers 2,3,5,7,11 and 13, we can see that the 6th prime is 13

//What is the 10001st prime number


import java.math.BigInteger;

public class Main {
    private static final int PRIME_INDEX = 10001;

    public static void main(String[] args) {

        System.out.println("Answer: " + getPrimeByIndex(PRIME_INDEX));

    }

    private static BigInteger getPrimeByIndex(int index){
        int minimalPrime = 2;
        BigInteger prime = new BigInteger(String.valueOf(minimalPrime));
        for (int i = 1; i<index; i++){
            prime = prime.nextProbablePrime();
        }
        return prime;
    }

}


