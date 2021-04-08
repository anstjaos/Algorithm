import java.io.*;
import java.util.Arrays;

public class BOJ_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] count = new int[N+5];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;
        count[1] = 1;
        count[2] = 2;
        count[3] = 3;
        for (int i= 2; i * i <= N; i++) {
            for (int j = 0; j + (i*i) <= N; j++) {
                count[j + (i*i)] = Math.min(count[j] + 1, count[j + (i*i)]);
            }
        }

        System.out.println(count[N]);
        br.close();
    }
}
