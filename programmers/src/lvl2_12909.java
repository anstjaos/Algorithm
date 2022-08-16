import java.util.Stack;

public class lvl2_12909 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean answer = true;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur == '(') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }

                stack.pop();
            }
        }

        if (!stack.isEmpty()) answer = false;
        return answer;
    }
}
