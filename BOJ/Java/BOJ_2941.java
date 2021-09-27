import java.io.*;
import java.util.Stack;

public class BOJ_2941 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        Stack<Character> stack = new Stack<>();
        int length = input.length();

        for (int i = 0; i < length; i++) {
            char cur = input.charAt(i);

            if (stack.isEmpty()) {
                stack.push(cur);
                continue;
            }

            if (cur == '=') {
                if (stack.peek() == 'z') {
                    stack.pop();
                    if (!stack.isEmpty() && stack.peek() == 'd') stack.pop();
                    stack.push('-');
                } else {
                    stack.pop();
                    stack.push('-');
                }
            } else if (cur == '-') {
                stack.pop();
                stack.push('-');
            } else if (cur == 'j') {
                char top = stack.peek();
                if (top == 'l' || top == 'n') {
                    stack.pop();
                    stack.push('-');
                } else {
                    stack.push(cur);
                }
            } else {
                stack.push(cur);
            }
        }

        System.out.println(stack.size());
    }
}
