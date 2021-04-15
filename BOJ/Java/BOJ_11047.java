import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        int index = 0;

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            if (coin[i] <= K) index = i;
        }

        int result = 0;
        while (K != 0) {
            if (coin[index] > K) {
                index--;
                continue;
            }

            int div = K / coin[index];
            K -= div * coin[index];
            result += div;
        }

        System.out.println(result);
        br.close();
    }
}
