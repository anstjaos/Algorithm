import java.io.*;
import java.util.Arrays;

public class BOJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int INF = 2123456789;

        int[] arr = new int[6000];
        Arrays.fill(arr, INF);
        arr[0] = 0;
        arr[3] = 1;
        arr[5] = 1;

        int N = Integer.parseInt(br.readLine());
        for (int i = 6; i <= N; i++) {
            int min = Math.min(arr[i-3], arr[i-5]);
            if (min == INF) continue;

            arr[i] = min + 1;
        }

        int result = arr[N];
        if (result == INF) result = -1;
        System.out.println(result);
        br.close();
    }
}
