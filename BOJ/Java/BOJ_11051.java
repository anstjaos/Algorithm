import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11051 {
    private static int DIV = 10007;
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        br.close();

        int[] factorial = new int[N+1];
        factorial[0] = factorial[1] = 1;
        for (int i = 2; i <= N; i++) {
            factorial[i] = (factorial[i-1] * i) % 10007;
        }

        System.out.println((factorial(N) * modInverse((factorial(N - K) * factorial(K)) % 10007, 10007 - 2)) % 10007);
    }

    private static int factorial(int N) {
        if (N <= 1) {
            return 1;
        }
        return (N * factorial(N - 1)) % DIV;
    }

    private static int modInverse(int a, int p) {
        int ret = 1;
        while(p > 0) {
            if(p % 2 == 1) {
                ret *= a;
                p--;
                ret %= DIV;
            }
            a *= a;
            a %= DIV;
            p >>= 1;
        }
        return ret;
    }
}
