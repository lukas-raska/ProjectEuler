package task_0002;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SequenceBuilder {

        public  List<Integer> getFibonacci(int upperLimit) {
        List<Integer> sequence = new ArrayList<>(List.of(1, 2));
        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            sequence.add(sequence.get(i - 2) + sequence.get(i - 1));
            if (sequence.get(i) > upperLimit) {
                sequence.remove(i);
                break;
            }
        }
        return sequence;
    }

    public List<Integer> getEvenValued(List<Integer> sequence) {
        return sequence.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    public long sumOfMembers (List<Integer> sequence){
            return sequence.stream()
                    .mapToLong(Long::valueOf)
                    .sum();
    }
}
