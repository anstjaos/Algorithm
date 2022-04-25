import java.io.*;
import java.util.Stack;

public class BOJ_3986 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        while (N-- > 0) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();

            int length = input.length();
            for (int i = 0; i < length; i++) {
                char cur = input.charAt(i);

                if (stack.isEmpty()) {
                    stack.push(cur);
                } else {
                    char top = stack.peek();
                    if (top == cur) stack.pop();
                    else stack.push(cur);
                }
            }

            if (stack.size() == 0) count++;
        }
        br.close();

        System.out.println(count);
    }
}
