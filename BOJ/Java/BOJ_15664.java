import java.io.*;
import java.util.*;

public class BOJ_15664 {
    private static int N, M;
    private static int[] numCount, countArr;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numCount = new int[10001];
        countArr = new int[10001];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            numCount[num]++;
        }
        br.close();

        solve(0, 0);
        System.out.print(sb);
    }

    private static void solve(int idx, int count) {
        if (count == M) {
            for (int i = 0; i < 10001; i++) {
                int c = countArr[i];
                while (c-- > 0) sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (; idx < 10001; idx++) {
            if (numCount[idx] == 0) continue;

            numCount[idx]--;
            countArr[idx]++;
            solve(idx, count + 1);
            numCount[idx]++;
            countArr[idx]--;
        }
    }
}
