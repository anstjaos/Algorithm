import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18258 {
    private static class Deque {
        int[] queue;
        int front, rear;

        public Deque() {
            this.queue = new int[2000001];
            front = rear = -1;
        }

        public void push(int num) {
            queue[++rear] = num;
        }

        public int isEmpty() {
            if (front == rear) return 1;
            return 0;
        }

        public int pop() {
            if (isEmpty() == 1) return -1;
            return queue[++front];
        }

        public int size() {
            return rear - front;
        }

        public int front() {
            if (isEmpty() == 1) return -1;
            return queue[front + 1];
        }

        public int back() {
            if (isEmpty() == 1) return -1;
            return queue[rear];
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque deque = new Deque();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String input = st.nextToken();

            if (input.equals("push")) {
                deque.push(Integer.parseInt(st.nextToken()));
            } else if (input.equals("pop")) {
                sb.append(deque.pop()).append("\n");
            } else if (input.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (input.equals("empty")) {
                sb.append(deque.isEmpty()).append("\n");
            } else if (input.equals("front")) {
                sb.append(deque.front()).append("\n");
            } else if (input.equals("back")) {
                sb.append(deque.back()).append("\n");
            }
        }
        br.close();
        System.out.print(sb);
    }
}
