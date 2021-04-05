import java.io.*;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int start = 0;
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            int value = Integer.parseInt(br.readLine());

            if (value > start) {
                for (int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = value;
            } else if (stack.peek() != value) {
                System.out.println("NO");
                br.close();
                return;
            }

            stack.pop();
            sb.append('-').append('\n');

        }

        br.close();

        System.out.print(sb);
    }
}
