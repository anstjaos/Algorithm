import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[10005];
        long min = 1, max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long result = 0;
        while (min <= max) {
            long mid = (min + max) / 2;

            int count = 0;
            for (int i = 0; i < K; i++) {
                count += (arr[i] / mid);
            }

            if (count < N) max = mid -1;
            else {
                result = Math.max(result, mid);
                min = mid + 1;
            }
        }

        System.out.println(result);
        br.close();
    }
}
