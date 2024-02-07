package task_0013;

//Work out the first ten digits of the sum of the following 150-digit number (input.txt)

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static final Path RELATIVE_PATH = Paths.get("src/main/java/task_0013/input.txt");

    public static void main(String[] args) {

        //načtení a naparsování dat z přiloženého souboru
        List<BigInteger> numbers = new ArrayList<>();

        try {
            numbers = Files
                    .readAllLines(RELATIVE_PATH.toAbsolutePath())
                    .stream()
                    .map(BigInteger::new)
                    .toList();

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getLocalizedMessage());
        }

        //výpočet součtu všech čísel
        BigInteger total = BigInteger.ZERO;
        for (BigInteger number: numbers){
            total=total.add(number);
        }

        //určení požadovaného podřetězce
        String result = total
                .toString()
                .substring(0,10);

        //výpis
        System.out.println("Answer: " + result);
    }


}
