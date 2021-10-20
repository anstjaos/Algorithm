import java.io.*;
import java.util.Stack;

public class BOJ_10799 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        int length = input.length();

        int result = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char cur = input.charAt(i);

            if (cur == '(') {
                stack.push(cur);
                continue;
            }

            stack.pop();
            if (input.charAt(i - 1) == '(') result += stack.size();
            else result++;
        }

        System.out.println(result);
    }
}
