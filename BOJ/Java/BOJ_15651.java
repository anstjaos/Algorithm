import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15651 {
    private static int N, M;
    private static int[] arr;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        sb = new StringBuilder();
        br.close();

        solve(0);
        System.out.print(sb);
    }

    private static void solve(int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[count] = i;
            solve(count + 1);
        }
    }
}
