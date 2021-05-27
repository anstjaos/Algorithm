import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15665 {
    private static int N, M;
    private static int[] numCount, selectArr;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numCount = new int[10001];
        selectArr = new int[M];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            numCount[num]++;
        }
        br.close();

        solve(0);
        System.out.print(sb);
    }

    private static void solve(int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
               sb.append(selectArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < 10001; i++) {
            if (numCount[i] <= 0) continue;

            selectArr[count] = i;
            solve(count + 1);
        }
    }
}
