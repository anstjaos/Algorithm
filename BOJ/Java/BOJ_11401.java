import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11401 {
    private static final long DIV = 1000000007;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println(factorial(N) * pow((factorial(K) * factorial(N-K) % DIV), DIV - 2) % DIV);
    }

    private static long factorial(long N) {
        long fac = 1L;

        while (N > 1) {
            fac = (fac * N) % DIV;
            N--;
        }
        return fac;
    }

    private static long pow(long base, long exp) {
        if (exp == 1) return base % DIV;

        long temp = pow(base, exp / 2);

        if (exp % 2 == 1) {
            return (temp * temp % DIV) * base % DIV;
        }
        return temp * temp % DIV;
    }
}
