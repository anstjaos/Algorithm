import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2042 {
    private static int start;
    private static long[] arr;
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int depth = 0;
        while ((1 << depth) < N) depth++;
        start = (int) Math.pow(2, depth);
        arr = new long[start * 4];

        for (int i = 0; i < N; i++) {
            arr[start + i] = Long.parseLong(br.readLine());
        }

        for (int i = start; i > 1; i /= 2) {
            for (int j = 0; j < i; j++) {
                int cur = i + j;
                arr[cur / 2] += arr[cur];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                int curIdx = start + b - 1;
                arr[curIdx] = c;
                curIdx /= 2;
                while (curIdx > 0) {
                    arr[curIdx] = arr[curIdx * 2] + arr[curIdx * 2 + 1];
                    curIdx /= 2;
                }
            } else {
                sb.append(sum(1, start, 1, b,(int) c)).append("\n");
            }
        }
        br.close();
        System.out.print(sb);
    }

    private static long sum(int start, int end, int cur, int left, int right) {
        if (left > end || start > right) return 0;

        if (left <= start && end <= right) return arr[cur];

        int mid = (start + end) /2;
        return sum(start, mid, cur * 2, left, right) + sum(mid+1, end, cur * 2 + 1, left, right);
    }
}
