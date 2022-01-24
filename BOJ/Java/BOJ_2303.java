import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2303 {
    private static int[] cards;
    private static int maxVal, maxNum;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        maxVal = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cards = new int[5];
            for (int j = 0; j < 5; j++) cards[j] = Integer.parseInt(st.nextToken());
            solve(0, 0, 0, i + 1);
        }
        br.close();
        System.out.println(maxNum);
    }

    private static void solve(int count, int sum, int index, int order) {
        if (count == 3) {
            if (sum > maxVal) {
                maxVal = sum;
                maxNum = order;
            } else if (sum == maxVal) {
                maxNum = Math.max(maxNum, order);
            }
            return;
        }
        if (index >= 5) return;

        solve(count + 1, (sum + cards[index]) % 10, index + 1, order);
        solve(count, sum, index + 1, order);
    }
}
