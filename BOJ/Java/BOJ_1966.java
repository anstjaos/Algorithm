import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1966 {
    public static class Document {
        int index;
        int importance;

        public Document(int index, int importance) {
            this.index = index;
            this.importance = importance;
        }
    }

    public static class Queue {
        private static final int QUEUE_SIZE = 206;
        private Document[] queue;
        private int front;
        private int rear;

        public Queue() {
            this.queue = new Document[QUEUE_SIZE];
            this.front = 0;
            this.rear = 0;
        }

        public void push(Document document) {
            rear = (rear + 1) % QUEUE_SIZE;
            queue[rear] = document;
        }

        public Document pop() {
            front = (front + 1) % QUEUE_SIZE;
            return queue[front];
        }

        public boolean isFirst() {
            int temp = front+1;
            int cur = (front + 1) % QUEUE_SIZE;
            while (temp != rear + 1) {
                if (queue[temp].importance > queue[cur].importance) return false;

                temp++;
                temp %= QUEUE_SIZE;
            }
            return true;
        }

        public void init() {
            front = rear = 0;
        }

        public boolean isEmpty() { return front == rear; }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        Queue queue = new Queue();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            queue.init();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.push(new Document(i, Integer.parseInt(st.nextToken())));
            }

            sb.append(getPrintOrder(queue, M)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static int getPrintOrder(Queue queue, int index) {
        int count = 0;
        while (!queue.isEmpty()) {
            if (queue.isFirst()) {
                count++;
                Document document = queue.pop();
                if (document.index == index) break;
            } else {
                queue.push(queue.pop());
            }
        }

        return count;
    }
}
