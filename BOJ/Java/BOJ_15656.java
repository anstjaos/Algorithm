import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15656 {
    private static int N, M;
    private static int[] arr, result;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        Arrays.sort(arr);
        solve( 0);
        System.out.print(sb);
    }

    private static void solve( int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) sb.append(result[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            result[count] = arr[i];
            solve(count + 1);
        }
    }
}
