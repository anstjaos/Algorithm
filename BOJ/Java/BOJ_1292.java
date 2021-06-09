import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = new long[1005];
        int count = 0, num = 1;
        long sum = 0;
        for (int i = 1; i < 1001; i++) {
            sum += num;
            arr[i] = sum;
            count++;
            if (count == num) {
                count = 0;
                num++;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println(arr[B] - arr[A -1]);
    }
}
