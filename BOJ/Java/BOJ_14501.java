import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14501 {
    private static int N, result;
    private static int[] days, pays;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        days = new int[N];
        pays = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pays[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        solve(0, 0);
        System.out.println(result);
    }

    private static void solve(int index, int sum) {
        result = Math.max(result, sum);

        for (; index < N; index++) {
            if (index + days[index] > N) continue;

            solve(index + days[index], sum + pays[index]);
        }
    }
}
