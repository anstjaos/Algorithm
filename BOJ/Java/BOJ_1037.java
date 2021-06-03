import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        Arrays.sort(arr);
        int result = 0;
        if (N % 2 == 0) {
            result = arr[N / 2] * arr[N/2 - 1];
        } else {
            result = arr[N/2] * arr[N/2];
        }

        System.out.println(result);
    }
}
