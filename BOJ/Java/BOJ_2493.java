import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    private static class Tower {
        int index, height;

        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        Stack<Tower> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                int top = stack.peek().height;
                if (top <= cur) stack.pop();
                else break;
            }

            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            } else {
                sb.append(stack.peek().index).append(" ");
            }

            stack.push(new Tower(i, cur));
        }
        br.close();

        System.out.println(sb);
    }
}
