import java.util.*;

public class lvl1_68644 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = set.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        Arrays.sort(answer);
        return answer;
    }
}
