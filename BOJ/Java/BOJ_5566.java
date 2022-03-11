import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5566 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[] map = new int[N+5];
        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        int cur = 1;
        int count = 0;
        for (int i = 0; i < M; i++) {
            int next = Integer.parseInt(br.readLine());
            count++;

            cur += next;
            if (map[cur] > 0) {
                cur += map[cur];
            } else if (map[cur] < 0) {
                cur = Math.max(1, cur + map[cur]);
            }

            if (cur >= N) break;
        }
        br.close();
        System.out.println(count);
    }
}
