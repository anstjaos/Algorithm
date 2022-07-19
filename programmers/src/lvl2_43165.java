import java.util.*;

public class lvl2_43165 {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(numbers[0]);
        queue.add(numbers[0] * -1);

        for (int i = 1; i < numbers.length; i++) {
            int size = queue.size();
            for (int j = 0 ; j < size; j++) {
                int num = queue.poll();
                queue.add(num + (numbers[i]));
                queue.add(num + (numbers[i] * -1));
            }
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num == target) answer++;
        }
        return answer;
    }
}
