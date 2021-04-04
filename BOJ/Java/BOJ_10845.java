import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10845 {
    public static class Queue {
        int[] queue;
        int front;
        int rear;

        public Queue() {
            queue = new int[100005];
            front = rear = -1;
        }

        public void push(int num) {
            queue[++rear] = num;
        }

        public int pop() {
            if (empty() == 1) return -1;
            return queue[++front];
        }

        public int size() {
            return rear - front;
        }

        public int empty() {
            return front == rear ? 1 : 0;
        }

        public int front() {
            if (empty() == 1) return -1;

            return queue[front+1];
        }

        public int back() {
            if (empty() == 1) return -1;
            return queue[rear];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue queue = new Queue();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    queue.push(num);
                    break;
                case "pop":
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.empty()).append("\n");
                    break;
                case "front":
                    sb.append(queue.front()).append("\n");
                    break;
                case "back":
                    sb.append(queue.back()).append("\n");
                    break;
            }
        }

        System.out.print(sb.toString());
        br.close();
    }
}
