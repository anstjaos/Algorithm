import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        br.close();

        Arrays.sort(arr);
        int left = 0, right = 0;

        int min = Integer.MAX_VALUE;
        while (left <= right && right < N) {
            int diff = arr[right] - arr[left];

            if (diff < M) right++;
            else {
                min = Math.min(min, diff);
                left++;
            }
        }

        System.out.println(min);
    }
}
