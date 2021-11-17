import java.io.*;
import java.util.Stack;

public class BOJ_1935 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String input = br.readLine();

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        br.close();

        Stack<Double> stack = new Stack<>();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char cur = input.charAt(i);

            switch (cur) {
                case '*':
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.add(a * b);
                    break;
                case '+':
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a + b);
                    break;
                case '-':
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a - b);
                    break;
                case '/':
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a / b);
                    break;
                default:
                    stack.push((double) arr[cur - 'A']);
                    break;
            }
        }

        System.out.printf("%.2f%n", stack.pop());
    }
}
