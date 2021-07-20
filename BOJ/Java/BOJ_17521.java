import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17521 {
    private static int W;
    private static long startCash, lastCash;
    private static int[] sellCoin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        startCash = Long.parseLong(st.nextToken());

        sellCoin = new int[W+5];
        for (int i = 1; i <= W; i++) sellCoin[i] = Integer.parseInt(br.readLine());

        br.close();

        solve(1, startCash, 0);
        System.out.println(lastCash);
    }

    private static void solve(int day, long cash, long coinCount) {
        if (day == W) {
            long result = cash + (coinCount * sellCoin[W]);
            lastCash = Math.max(lastCash, result);
            return;
        }

        long buyCount = (cash / sellCoin[day]);
        solve(day + 1, cash - (buyCount * sellCoin[day]), coinCount + buyCount);
        solve(day + 1, cash, coinCount);
        solve(day + 1, cash + (coinCount * sellCoin[day]), 0);
    }
}
