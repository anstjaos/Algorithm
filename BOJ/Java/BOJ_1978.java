import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[1005];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < 1005; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j < 1005; j+= i) {
                    isPrime[j] = false;
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrime[num]) count++;
        }

        System.out.println(count);
        br.close();
    }
}
