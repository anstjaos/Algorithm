import java.io.*;

public class BOJ_11279 {
    private static class MaxHeap {
        private static final int HEAP_SIZE = 100007;
        int[] heap;
        int index;

        public MaxHeap() {
            this.heap = new int[HEAP_SIZE];
            index = 1;
        }

        public void push(int num) {
            int curIndex = index;
            heap[index++] = num;

            while (curIndex > 1 && heap[curIndex / 2] < heap[curIndex]) {
                int temp = heap[curIndex/2];
                heap[curIndex/2] = heap[curIndex];
                heap[curIndex] = temp;

                curIndex /= 2;
            }
        }

        public int pop() {
            if (index == 1) {
                return 0;
            }

            int result = heap[1];
            heap[1] = heap[--index];
            heap[index] = 0;

            for (int curIndex = 1; curIndex * 2 < index;) {
                int tempIndex = 0;
                if (heap[curIndex * 2] > heap[curIndex * 2 + 1]) {
                    tempIndex = curIndex * 2;
                } else {
                    tempIndex = curIndex * 2 + 1;
                }

                if (heap[tempIndex] <= heap[curIndex]) break;

                int temp = heap[tempIndex];
                heap[tempIndex] = heap[curIndex];
                heap[curIndex] = temp;

                curIndex = tempIndex;
            }

            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        MaxHeap maxHeap = new MaxHeap();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) sb.append(maxHeap.pop()).append("\n");
            else maxHeap.push(num);
        }
        System.out.print(sb);
        br.close();
    }
}
