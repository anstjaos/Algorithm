import java.io.*;
import java.util.Arrays;

public class BOJ_3896 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        boolean[] isPrime = new boolean[2650000];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < 1300000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 1300000; j+= i) {
                    isPrime[j] = false;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (isPrime[num]) {
                sb.append(0).append("\n");
                continue;
            }

            int start = num, end = num;

            while (true) {
                if (isPrime[--start]) break;
            }
            while (true) {
                if (isPrime[++end]) break;
            }
            sb.append(end - start).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
