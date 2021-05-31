import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        br.close();

        boolean[] isPrime = new boolean[100000001];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < 100000001; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 100000001; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = a; i <= b; i++) {
            if (!isPrime[i]) continue;

            String s = String.valueOf(i);
            int left = 0, right = s.length() - 1;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) break;
                left++;
                right--;
            }

            if (left >= right) sb.append(i).append("\n");
        }
        sb.append(-1);
        System.out.println(sb);
    }
}
