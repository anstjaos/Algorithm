import java.io.*;

public class BOJ_9012 {
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
        int N = Integer.parseInt(br.readLine());

        Stack stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            stack.init();
            String input = br.readLine();
            int inputLength = input.length();

            boolean success = true;
            for (int j = 0; j < inputLength; j++) {
                char curChar = input.charAt(j);

                if (curChar == '(') stack.push(curChar);
                else {
                    char popChar = stack.pop();
                    if (popChar != '(') {
                        success = false;
                        break;
                    }
                }
            }

            if (success && stack.index == 0) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.print(sb.toString());
        br.close();
    }
}
