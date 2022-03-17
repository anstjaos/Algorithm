import java.io.*;
import java.util.Stack;

public class BOJ_2257 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        Stack<Integer> stack = new Stack<>();

        int before = 0;
        stack.push(0);
        br.close();

        int length = input.length();
        for (int i = 0; i < length; i++) {
            char cur = input.charAt(i);

            if (cur == '(') {
                stack.push(0);
            } else if (cur == ')') {
                before = stack.pop();
                stack.push(stack.pop() + before);
            } else if ('2' <= cur && cur <= '9') {
                stack.push(stack.pop() + before * (cur - '0' - 1));
            } else {
                if (cur == 'H') before = 1;
                else if (cur == 'C') before = 12;
                else if (cur == 'O') before = 16;

                stack.push(stack.pop() + before);
            }
        }

        System.out.println(stack.pop());
    }
}
