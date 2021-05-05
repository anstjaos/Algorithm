import java.io.*;
import java.util.Stack;

public class BOJ_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        Stack<Character> stack = new Stack<>();
        int length = input.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if ('A' <= c && c <= 'Z') sb.append(c);
            else {
                switch (c) {
                    case '+':
                    case '-':
                        while (!stack.isEmpty()) {
                            char top = stack.pop();
                            if (top == '(') {
                                stack.add(top);
                                break;
                            }
                            sb.append(top);
                        }

                        stack.add(c);
                        break;
                    case '*':
                    case '/':
                        while (!stack.isEmpty()) {
                            char top = stack.pop();
                            if (top == '(' || top == '+' || top == '-'){
                                stack.add(top);
                                break;
                            }
                            sb.append(top);
                        }
                        stack.add(c);
                        break;
                    case '(':
                        stack.add(c);
                        break;
                    case ')':
                        while (!stack.isEmpty()) {
                            char top = stack.pop();
                            if (top == '(') break;
                            sb.append(top);
                        }
                        break;
                }
            }
        }

        while (!stack.isEmpty()) {
            char top = stack.pop();
            sb.append(top);
        }

        System.out.println(sb);
    }
}
