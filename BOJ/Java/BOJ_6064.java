import java.io.*;
import java.util.StringTokenizer;

public class BOJ_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            int result = x;
            int count = x % (M + 1);
            int lcd = getLcd(M, N);

            for (int j = 0; j < N; j++) {
                int ty = result % N == 0 ? N : result % N;
                if (ty == y) {
                    break;
                }

                result = ty + M;
                count += M;
            }

            if (count > lcd) sb.append(-1).append("\n");
            else sb.append(count).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static int getLcd(int m, int n) {
        int a = m, b = n;
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return Math.abs((m * n) / a);
    }
}
