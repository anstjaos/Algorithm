import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9084 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] coin = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            int[] count = new int[M + 5];
            count[0] = 1;

            for (int i = 0; i < N; i++) {
                for (int j = coin[i]; j <= M; j++) {
                    count[j] += count[j - coin[i]];
                }
            }

            sb.append(count[M]).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
