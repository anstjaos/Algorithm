import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());

        int gcd = 1;

        while (true) {
            int temp = getGcd(A, B);
            if (temp == 1) break;
            A /= temp;
            B /= temp;
            gcd *= temp;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(gcd + "\n");
        sb.append(gcd * A * B);

        System.out.println(sb.toString());
        br.close();
    }

    private static int getGcd(int A, int B) {
        int min = Math.min(A, B);

        for (int i = min; i > 0; i--) {
            if (A % i == 0 && B % i == 0) {
                return i;
            }
        }

        return 1;
    }
}
