import java.io.*;

public class BOJ_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[N+10];

        count[1] = 0;
        count[2] = count[3] = 1;

        for (int i = 4; i <= N; i++) {
            int result = Integer.MAX_VALUE;

            if (i % 3 == 0) result = Math.min(result, count[i/3] + 1);
            if (i % 2 == 0) result = Math.min(result, count[i/2] + 1);
            result = Math.min(result, count[i - 1] + 1);

            count[i] = result;
        }

        System.out.println(count[N]);
        br.close();
    }
}
