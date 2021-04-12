import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr, 0, N);
        int result = 0, sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];
            result += sum;
        }

        System.out.println(result);
        br.close();
    }
}
