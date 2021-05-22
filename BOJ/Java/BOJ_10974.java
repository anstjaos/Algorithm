import java.io.*;

public class BOJ_10974 {
    private static StringBuilder sb;
    private static int N;
    private static boolean[] visit;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        arr = new int[N];
        br.close();

        solve(0);
        System.out.print(sb);
    }

    private static void solve(int count) {
        if (count == N) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            arr[count] = i;
            solve(count+1);
            visit[i] = false;
        }
    }
}
