import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2436 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long gcd = Long.parseLong(st.nextToken()), lcm = Long.parseLong(st.nextToken());
        br.close();

        long a = gcd, b = lcm;
        long multi= gcd * lcm;

        for (long i = 2 * gcd; i * i <= multi; i += gcd) {
            if (multi % i == 0) {
                long temp = multi / i;

                if (gcd(i, temp) == gcd) {
                    if (a + b > i + temp) {
                        a = i;
                        b = temp;
                    }
                }
            }
        }

        System.out.println(a + " " + b);
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
