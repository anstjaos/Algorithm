import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
    private static long A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(getPow(B) % C);

        br.close();
    }

    private static long getPow(long exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return A;

        long n = getPow(exponent / 2) % C;
        if (exponent % 2 == 0) {
            return (n * n) % C;
        } else {
            return (((n*n) % C) * A) % C;
        }
    }
}
