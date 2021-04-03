import java.io.*;

public class BOJ_10773 {
    public static class Stack {
        int[] stack;
        int index;

        public Stack() {
            stack = new int[100005];
            index = 0;
        }

        public void push(int num) {
            stack[index++] = num;
        }

        public void pop() {
            if (index == 0) return;
            index--;
        }

        public int sum() {
            int result = 0;
            for (int i = 0; i < index; i++) {
                result += stack[i];
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack stack = new Stack();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                stack.pop();
                continue;
            }
            stack.push(num);
        }

        int result = stack.sum();

        System.out.println(result);
        br.close();
    }
}
