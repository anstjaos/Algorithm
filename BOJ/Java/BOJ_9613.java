import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long[] arr = new long[n];

            for (int i = 0; i < n; i++) arr[i] = Long.parseLong(st.nextToken());

            long sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    sum += getGcd(arr[i], arr[j]);
                }
            }
            sb.append(sum).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    private static long getGcd(long a, long b) {
        while (b > 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
