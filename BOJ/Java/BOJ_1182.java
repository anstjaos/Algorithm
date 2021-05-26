import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1182 {
    private static int N, S, result, select;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        result = 0;

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        solve(0, 0);
        System.out.println(result);
    }

    private static void solve(int index, int sum) {
        if (sum == S && select > 0) {
            result++;
        }

        for (; index < N; index++) {
            select++;
            solve(index+1, sum + arr[index]);
            select--;
        }
    }
}
