import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13172 {
    private static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long result = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
            long gcd = getGcd(S, N);
            N /= gcd;
            S /= gcd;

            long temp = 1;
            long square = MOD - 2;
            long copyN = N;
            while (square > 0) {
                if ((square & 1) == 1) temp = (temp * copyN) % MOD;
                copyN = (copyN * copyN) % MOD;
                square >>= 1;
            }

            result += (S * temp) % MOD;
            result %= MOD;
        }

        System.out.println(result);
        br.close();
    }

    private static long getGcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
