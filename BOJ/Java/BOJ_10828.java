import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10828 {
    public static class Stack {
        int[] stack;
        int index;

        public Stack() {
            this.stack = new int[100005];
            index = 0;
        }

        public void push(int num) {
            stack[index++] = num;
        }

        public int pop() {
            if (index == 0) return -1;

            return stack[--index];
        }

        public int size() {
            return index;
        }

        public int empty() {
            return index == 0 ? 1 : 0;
        }

        public int top() {
            if (index == 0) return -1;
            return stack[index-1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Stack stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case "top":
                    sb.append(stack.top()).append("\n");
                    break;
            }
        }

        System.out.print(sb.toString());
        br.close();
    }
}
