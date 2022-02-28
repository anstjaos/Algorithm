import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1850 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken());
        br.close();

        long gcd = getGCD(A, B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gcd; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }

    private static long getGCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
