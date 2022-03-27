import java.io.*;
import java.util.Stack;

public class BOJ_1725 {
    private static class Item {
        int height, index;

        public Item(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        Stack<Item> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());

            while (!stack.isEmpty()) {
                Item top = stack.peek();
                if (top.height > cur ) {
                    stack.pop();
                    int width = i;
                    if (!stack.isEmpty()) {
                        width -= stack.peek().index + 1;
                    }
                    result = Math.max(result, width * top.height);
                } else {
                    break;
                }
            }
            stack.push(new Item(cur, i));
        }

        while (!stack.isEmpty()) {
            Item top = stack.pop();

            int width = N;
            if (!stack.isEmpty()) {
                width -= stack.peek().index + 1;
            }
            result = Math.max(result, width * top.height);
        }
        br.close();
        System.out.println(result);
    }
}
