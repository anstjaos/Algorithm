import java.io.*;

public class BOJ_4949 {
    public static class Stack {
        private char[] stack;
        private int index;

        public Stack() {
            stack = new char[105];
            index = 0;
        }

        public void init() {
            index = 0;
        }

        public void push(char input) {
            stack[index++] = input;
        }

        public char pop() {
            if (index == 0) return ' ';
            return stack[--index];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack();

        StringBuilder sb = new StringBuilder();
        while (true) {
            stack.init();
            String input = br.readLine();
            if (input.equals(".")) break;

            int length = input.length();

            boolean success = true;
            for (int i = 0; i < length; i++) {
                char curChar = input.charAt(i);

                if (curChar == '(' || curChar == '[') stack.push(curChar);
                if (curChar == ')') {
                    char popChar = stack.pop();
                    if (popChar != '(') {
                        success = false;
                        break;
                    }
                }
                if (curChar == ']') {
                    char popChar = stack.pop();
                    if (popChar != '[') {
                        success = false;
                        break;
                    }
                }
            }

            if (success && stack.index == 0) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
