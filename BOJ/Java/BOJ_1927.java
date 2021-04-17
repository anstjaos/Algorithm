import java.io.*;
import java.util.Arrays;

public class BOJ_1927 {
    private static class MinHeap {
        private static final int HEAP_SIZE = 100007;
        int[] heap;
        int size;

        public MinHeap() {
            this.heap = new int[HEAP_SIZE];
            Arrays.fill(heap, Integer.MAX_VALUE);
            size = 0;
        }

        public void push(int num) {
            heap[++size] = num;
            int curIndex = size;

            while (curIndex > 1 && heap[curIndex / 2] > heap[curIndex]) {
                int temp = heap[curIndex/2];
                heap[curIndex/2] = heap[curIndex];
                heap[curIndex] = temp;
                curIndex /= 2;
            }
        }

        public int pop() {
            if (size == 0) return 0;

            int result = heap[1];
            heap[1] = heap[size];
            heap[size--] = Integer.MAX_VALUE;

            for (int cur = 1; cur * 2 <= size; ) {
                int min = Math.min(heap[cur * 2], heap[cur * 2 + 1]);
                if (min >= heap[cur]) break;

                int minIndex;
                if (heap[cur * 2] < heap[cur * 2 + 1]) {
                    minIndex = cur*2;
                } else {
                    minIndex = cur*2 + 1;
                }

                int temp = heap[minIndex];
                heap[minIndex] = heap[cur];
                heap[cur] = temp;
                cur = minIndex;
            }

            return result;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        MinHeap minHeap = new MinHeap();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) sb.append(minHeap.pop()).append("\n");
            else minHeap.push(num);
        }
        System.out.print(sb);
        br.close();
    }
}
