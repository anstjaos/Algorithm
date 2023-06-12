import java.util.*;

public class lvl2_131704 {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        int num = 1, orderIndex = 0;

        while (orderIndex < order.length) {
            if (order[orderIndex] == num) {
                answer++;
                orderIndex++;
                num++;
            } else if (!stack.isEmpty() && stack.peek() == order[orderIndex]) {
                stack.pop();
                answer++;
                orderIndex++;
            } else {
                stack.push(num);
                num++;
            }
            if (num > order.length) break;
        }

        while (!stack.isEmpty() && stack.peek() == order[orderIndex]) {
            stack.pop();
            answer++;
            orderIndex++;
        }

        return answer;
    }
}
