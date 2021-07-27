import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        Arrays.sort(arr);
        int left = 0, right = N - 1, result = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == M) {
                result++;
                left++;
                right--;
            } else if (sum < M) {
                left++;
            } else right--;
        }

        System.out.println(result);
    }
}
