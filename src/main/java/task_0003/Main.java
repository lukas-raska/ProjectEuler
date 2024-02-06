package task_0003;

//The prime factors of 13195 are 5, 7, 13 and 29

//What is the largest prime factor of the number 600851475143 ?


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static final long input = 600851475143L;

    public static void main(String[] args) {

        System.out.println("Answer: " + Collections.max(getPrimeFactorList(input)));

    }

    public static List<Long> getPrimeFactorList(long inputNumber) {
        //výstupní proměnná
        List<Long> primeFactorList = new ArrayList<>();
        //pro ukládání prvočísel (začíná na hodnotě 2 - nejnižší možné prvočíslo
        BigInteger prime = BigInteger.valueOf(2);

        //v cyklu testuji dělení postupně rostoucími prvočísly
        //pokud je vstupní číslo prvočíslem dělitelné beze zbytku, toto prvočíslo patří mezi prvočíslené činitele
        //v případě nalezení podělím vstupní číslo nalezeným činitelem
        //cyklus skončí v momentě kdy podíl z předchozího kroku a aktuální zkoumané prvočíslo rovnají ==> jejich
        // podíl tedy roven 1
        while (inputNumber > 1) {
            if (inputNumber % prime.longValue() == 0) {
                primeFactorList.add(prime.longValue());
                inputNumber /= prime.longValue();
            }
            prime = prime.nextProbablePrime();
        }
        return primeFactorList;
    }
}