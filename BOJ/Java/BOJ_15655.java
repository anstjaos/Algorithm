import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15655 {
    private static int N, M;
    private static int[] arr;
    private static boolean[] isSelect;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        isSelect = new boolean[N];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        Arrays.sort(arr);
        solve(0, 0);
        System.out.print(sb);
    }

    private static void solve(int idx, int count) {
        if (count == M) {
            for (int i = 0; i < N; i++) {
                if (isSelect[i]) {
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (; idx < N; idx++) {
            if (isSelect[idx]) continue;

            isSelect[idx] = true;
            solve(idx +1, count+1);
            isSelect[idx] = false;
        }
    }
}
