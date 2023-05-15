import java.util.*;

public class lvl2_154539 {
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        int[] answer = new int[length];

        Stack<Integer> stack = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (stack.peek() <= numbers[i]) {
                    stack.pop();
                } else break;
            }

            if (stack.isEmpty()) {
                answer[i] = -1;
                stack.push(numbers[i]);
                continue;
            }

            answer[i] = stack.peek();
            stack.push(numbers[i]);
        }
        return answer;
    }
}
