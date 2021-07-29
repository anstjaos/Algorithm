import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(br.readLine());
        br.close();

        Arrays.sort(arr);
        long left = 0, right = arr[N-1];
        long r = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid == 0) mid = 1;

            long result = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) result += mid;
                else result += arr[i];
            }

            if (result <= M) {
                left = mid + 1;
                r = Math.max(r, mid);
            } else right = mid - 1;
        }

        System.out.println(r);
    }
}
