package task_0012;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int MAX_NUMBER_OF_DIVISORS = 500;

    public static void main(String[] args) {

        LocalDateTime start = LocalDateTime.now();

        int toAdd = 1;
        int triangleNumber = 0;
        int numberOfDivisors = 0;

        //dokud počet celočíselných dělitelů nepřekročí stanovenou mez
        while (numberOfDivisors <= MAX_NUMBER_OF_DIVISORS) {

            //získám člena posloupnosti a zvýším navyšující číslo pro další iteraci
            triangleNumber += toAdd++;

            //spočtu počet dělitelů pro aktuální člen posloupnosti
            numberOfDivisors = getNumberOfDivisors(triangleNumber);
        }


        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);

        System.out.println("Number of divisors: " + numberOfDivisors);
        System.out.println("Answer (triangle number): " + triangleNumber);
        System.out.println("Doba chodu: " + duration.toMinutesPart() + ":" + duration.toSecondsPart() + ":" + duration.toNanosPart());


    }

    private static int getNumberOfDivisors(int triangleNumber) {

        List<Integer> divisorList = new ArrayList<>(); //seznam pro ukládání dělitelů
        int divisor = 1;    //hodnota, kterou se budu pokoušet dělit člen posl.

        //iteruji, dokud nenarazím na nejvyšší možný dělitel
        while (divisor <= triangleNumber / divisor) {
            //pokud naleznu, přidám do seznamu
            if (triangleNumber % divisor == 0) {
                divisorList.add(divisor); //přidám samotného dělitele
                if (divisor != triangleNumber) { //a přidám i číslo, které jsem dostal po vydělení (pokud se
                    // nerovnají, což nastane pouze u 1
                    divisorList.add(triangleNumber / divisor);
                }
            }
            divisor++;
        }
        return divisorList.size();

    }

}
