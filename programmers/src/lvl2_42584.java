import java.util.*;

public class lvl2_42584 {
    public static class Stock {
        public int idx, num;

        public Stock(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Stock> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            int num = prices[i];
            while (!stack.isEmpty()) {
                Stock top = stack.peek();
                if (top.num > num) {
                    stack.pop();
                    answer[top.idx] = i - top.idx;
                } else {
                    stack.push(new Stock(i, num));
                    break;
                }
            }

            if (stack.isEmpty()) {
                stack.push(new Stock(i, num));
            }
        }

        while (!stack.isEmpty()) {
            Stock top = stack.pop();
            answer[top.idx] = prices.length - top.idx - 1;
        }
        return answer;
    }
}
