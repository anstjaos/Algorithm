import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10866 {
    public static class Deque {
        static final int DEQUE_SIZE = 100005;
        private int[] deque;
        private int front;
        private int rear;

        public Deque() {
            deque = new int[DEQUE_SIZE];
            front = rear = 0;
        }

        public void pushFront(int num) {
            front = (front-1 + DEQUE_SIZE) % DEQUE_SIZE;
            deque[(front+1) % DEQUE_SIZE] = num;
        }

        public void pushBack(int num) {
            rear = (rear + 1) % DEQUE_SIZE;
            deque[rear] = num;
        }

        public int popFront() {
            if (empty() == 1) return -1;
            front = (front + 1) % DEQUE_SIZE;
            return deque[front];
        }

        public int popBack() {
            if (empty() == 1) return -1;
            int num = deque[rear];
            rear = (rear -1 + DEQUE_SIZE) % DEQUE_SIZE;
            return num;
        }

        public int size() {
            int size = 0;
            if (front > rear)
            {
                size = (DEQUE_SIZE - front + rear) % DEQUE_SIZE  ;
            }
            else
            {
                size = rear - front;
            }

            return size;
        }

        public int empty() {
            return front == rear ? 1 : 0;
        }

        public int front() {
            if (empty() == 1) return -1;
            return deque[(front+1)%DEQUE_SIZE];
        }

        public int back() {
            if (empty() == 1) return -1;
            return deque[rear];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque deque = new Deque();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front":
                    int num = Integer.parseInt(st.nextToken());
                    deque.pushFront(num);
                    break;
                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    deque.pushBack(num);
                    break;
                case "pop_front":
                    sb.append(deque.popFront()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deque.popBack()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.empty()).append("\n");
                    break;
                case "front":
                    sb.append(deque.front()).append("\n");
                    break;
                case "back":
                    sb.append(deque.back()).append("\n");
                    break;
            }
        }

        System.out.print(sb.toString());
        br.close();
    }
}
