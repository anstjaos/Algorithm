import java.io.*;
import java.util.Stack;

public class BOJ_17413 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        StringBuilder sb = new StringBuilder();
        int length = input.length();
        Stack<Character> stack = new Stack<>();

        boolean isTag = false;
        for (int i = 0; i < length; i++) {
            char cur = input.charAt(i);

            if (cur == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                isTag = true;
                sb.append(cur);
                continue;
            }
            else if (cur == '>') {
                isTag = false;
                sb.append(cur);
                continue;
            } else if (cur == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(cur);

                continue;
            }

            if (isTag) {
                sb.append(cur);
                continue;
            }

            stack.add(cur);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
