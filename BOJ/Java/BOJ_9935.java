import java.io.*;
import java.util.Stack;

public class BOJ_9935 {
    private static class Info {
        char c;
        int sameCount;

        public Info(char c, int sameCount) {
            this.c = c;
            this.sameCount = sameCount;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bomb = br.readLine();
        br.close();

        Stack<Info> stack = new Stack<>();
        int inputSize = input.length();
        int bombSize = bomb.length();

        Info before = new Info('a', 0);
        stack.add(before);
        for (int i = inputSize - 1; i >= 0; i--) {
            char c = input.charAt(i);
            int sameSize = 0;
            before = stack.peek();

            if (c == bomb.charAt(bombSize - 1 - before.sameCount)) {
                sameSize = before.sameCount + 1;
            } else if (c == bomb.charAt(bombSize - 1)){
                sameSize = 1;
            }

            stack.add(new Info(c, sameSize));

            if (sameSize == bombSize) {
                for (int j = 0; j < bombSize; j++) stack.pop();

            }
        }

        StringBuilder sb = new StringBuilder();

        if (stack.size() == 1) sb.append("FRULA ");
        else {
            while (!stack.isEmpty()) {
                char c = stack.pop().c;
                sb.append(c);
            }
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
