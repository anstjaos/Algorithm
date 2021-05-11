import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        Arrays.sort(arr);

        int start = 0, end = N-1;
        int minSum = Integer.MAX_VALUE;
        int resultA = arr[start], resultB = arr[end];

        while (start < end) {
            int sum = Math.abs(arr[start] + arr[end]);

            if (sum < minSum) {
                minSum = sum;
                resultA = arr[start];
                resultB = arr[end];
            }

            if (arr[start] + arr[end] < 0) start++;
            else end--;
        }

        System.out.println(resultA + " " + resultB);
    }
}
