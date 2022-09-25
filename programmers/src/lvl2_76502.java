import java.util.*;

public class lvl2_76502 {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            Stack<Character> stack = new Stack<>();
            boolean isSuccess = true;
            for (int j = 0; j < length; j++) {
                char cur = s.charAt((i + j) % length);
                switch (cur) {
                    case '[':
                    case '(':
                    case '{':
                        stack.push(cur);
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.peek() != '[') {
                            isSuccess = false;
                            break;
                        }
                        stack.pop();
                        break;
                    case '}':
                        if (stack.isEmpty() || stack.peek() != '{') {
                            isSuccess = false;
                            break;
                        }
                        stack.pop();
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.peek() != '(') {
                            isSuccess = false;
                            break;
                        }
                        stack.pop();
                        break;
                }
                if (!isSuccess) break;
            }

            if (stack.isEmpty() && isSuccess) answer++;
        }
        return answer;
    }
}
