package task_0002;

//Even SequenceBuilder Numbers

//Each new term in the SequenceBuilder sequence is generated by adding the previous two terms. By starting 1 and 2, the
// first 10 terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
//By considering the terms in the SequenceBuilder sequence whose values do not exceed four milion, find the sum of the
// even-valued terms.


import java.util.List;

public class Main {

    public static int upperLimit = 4000000;

    public static void main(String[] args) {

        SequenceBuilder builder = new SequenceBuilder();

        List<Integer> fibonacciSequence = builder.getFibonacci(upperLimit);
        List<Integer> evenValuedTerms = builder.getEvenValued(fibonacciSequence);
        long result = builder.sumOfMembers(evenValuedTerms);


        System.out.println("\nSoučet sudých členů: " + result);

    }


}
