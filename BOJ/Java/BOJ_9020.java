import java.io.*;
import java.util.Arrays;

public class BOJ_9020 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        boolean[] isPrime = new boolean[10005];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < 10005; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < 10005; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int p = n / 2;
            int q = n / 2;

            while(true) {
                if(isPrime[p] && isPrime[q]) {
                    sb.append(p + " " + q + "\n");
                    break;
                }
                p--;
                q++;
            }
        }
        br.close();
        System.out.println(sb);
    }
}
