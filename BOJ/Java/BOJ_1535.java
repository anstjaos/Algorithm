import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1535 {
    private static int N, maxVal;
    private static int[] lose, gain;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        N = Integer.parseInt(br.readLine());
        maxVal = 0;
        lose = new int[N];
        gain = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) lose[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) gain[i] = Integer.parseInt(st.nextToken());
        br.close();

        solve(0, 0, 100);
        System.out.println(maxVal);
    }

    private static void solve(int idx, int val, int hp) {
        if (idx == N) {
            maxVal = Math.max(maxVal, val);
            return;
        }

        int nextHp = hp - lose[idx];
        if (nextHp > 0) solve(idx + 1, val + gain[idx], nextHp);
        solve(idx + 1, val, hp);
    }
}
