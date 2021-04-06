import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] tree = new long[1000007];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(tree, 0, N);
        long min = 0, max = tree[N-1];
        long minLen = Long.MAX_VALUE;
        long maxCut = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (tree[i] < mid) continue;
                sum += (tree[i] - mid);
            }

            if (sum < M) {
                max = mid - 1;
            } else {
                if (sum <= minLen) {
                    minLen = sum;
                    maxCut = mid;
                }
                min = mid + 1;
            }
        }

        System.out.println(maxCut);
        br.close();
    }
}
