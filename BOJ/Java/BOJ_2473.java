import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);

        long[] select = new long[3];
        long result = Long.MAX_VALUE;
        for (int i = 0; i < N -2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = arr[left] + arr[right] + arr[i];

                if (Math.abs(sum) < result) {
                    result = Math.abs(sum);
                    select[0] = arr[i];
                    select[1] = arr[left];
                    select[2] = arr[right];
                }

                if (sum > 0) right--;
                else left++;
            }
        }

        Arrays.sort(select);

        StringBuilder sb = new StringBuilder();
        sb.append(select[0]).append(" ").append(select[1]).append(" ").append(select[2]);

        System.out.println(sb);
    }
}
