import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2960 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        br.close();
        

        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);

        int count = 0, result = 0;

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                count++;
                if (count == K) {
                    result = i;
                    break;
                }

                for (int j = i * 2; j <= N; j += i) {
                    if (!isPrime[j]) continue;
                    isPrime[j] = false;
                    count++;
                    if (count == K) {
                        result = j;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
