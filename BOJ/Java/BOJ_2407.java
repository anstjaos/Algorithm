import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int diff = N-M;

        BigInteger result = new BigInteger("1");
        if (diff > M) {
            for (int i = N; i > diff; i--) result = result.multiply(BigInteger.valueOf(i));
            for (int i = 2; i <= M; i++) result = result.divide(BigInteger.valueOf(i));
        } else {
            for (int i = N; i > M; i--) result = result.multiply(BigInteger.valueOf(i));
            for (int i = 2; i <= diff; i++) result = result.divide(BigInteger.valueOf(i));
        }

        System.out.println(result);

        br.close();
    }
}
