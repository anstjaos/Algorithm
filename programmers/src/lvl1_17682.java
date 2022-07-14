import java.util.*;

public class lvl1_17682 {
    public int solution(String dartResult) {
        Stack<Integer> stack = new Stack<>();

        int curScore = 0;
        char before = '0';
        for (int i = 0; i < dartResult.length(); i++) {
            char cur = dartResult.charAt(i);

            if ('0' <= cur && cur <= '9') {
                if (!('0' <= before && before <= '9')) {
                    stack.push(curScore);
                    curScore = 0;
                }
                curScore = curScore * 10 + (cur - '0');
            } else if (cur == 'D') {
                curScore = curScore * curScore;
            } else if (cur == 'T') {
                curScore = curScore * curScore * curScore;
            } else if (cur == '*') {
                if (!stack.empty()) stack.push(stack.pop() * 2);
                curScore *= 2;
            } else if (cur == '#') {
                curScore *= -1;
            }

            before = cur;
        }
        stack.push(curScore);
        int answer = 0;
        while (!stack.empty()) {
            answer += stack.pop();
        }
        return answer;
    }
}
