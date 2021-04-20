import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11286 {
    private static class MinHeap {
        private int[] arr;
        private int size;

        public MinHeap() {
            arr = new int[100007];
            Arrays.fill(arr, Integer.MAX_VALUE);
            size = 0;
        }

        public void push(int num) {
            arr[++size] = num;

            int curIndex = size;
            while (curIndex > 1) {
                if (Math.abs(arr[curIndex/2]) < Math.abs(arr[curIndex])) break;
                if (Math.abs(arr[curIndex/2]) == Math.abs(arr[curIndex]) && arr[curIndex/2] < arr[curIndex]) break;

                int temp = arr[curIndex/2];
                arr[curIndex/2] = arr[curIndex];
                arr[curIndex] = temp;

                curIndex /= 2;
            }
        }

        public int pop() {
            if (size == 0) return 0;

            int result = arr[1];
            arr[1] = arr[size];
            arr[size--] = Integer.MAX_VALUE;

            int curIndex = 1;
            for (; curIndex * 2 <= size; ) {
                int temp;
                if (Math.abs(arr[curIndex * 2]) == Math.abs(arr[curIndex*2+1])) {
                    temp = Math.min(arr[curIndex * 2], arr[curIndex*2+1]);
                } else {
                    temp = (Math.abs(arr[curIndex * 2]) < Math.abs(arr[curIndex*2+1]) ? arr[curIndex*2] : arr[curIndex*2+1]);
                }

                if (Math.abs(temp) > Math.abs(arr[curIndex])) break;
                if (Math.abs(temp) == Math.abs(arr[curIndex]) && temp >= arr[curIndex]) break;

                int index;
                if (Math.abs(arr[curIndex * 2]) == Math.abs(arr[curIndex*2+1])) {
                    index = (arr[curIndex* 2] < arr[curIndex * 2 +1] ? curIndex*2: curIndex*2+1);
                } else {
                    index = (Math.abs(arr[curIndex * 2]) < Math.abs(arr[curIndex*2+1]) ? curIndex*2 : curIndex*2+1);
                }

                arr[index] = arr[curIndex];
                arr[curIndex] = temp;
                curIndex = index;
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

        System.out.println(sb);
        br.close();
    }
}
