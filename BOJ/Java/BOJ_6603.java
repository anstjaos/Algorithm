import java.io.*;
import java.util.StringTokenizer;

public class BOJ_6603 {
    private static int k;
    private static int[] arr;
    private static boolean[] isSelect;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            arr = new int[k];
            isSelect = new boolean[k];

            for (int i = 0; i < k; i++) arr[i] = Integer.parseInt(st.nextToken());
            solve(0, 0);
            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    private static void solve(int cur, int count) {
        if (count == 6) {
            for (int i = 0; i < k; i++) {
                if (!isSelect[i]) continue;

                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (; cur < k; cur++) {
            if (isSelect[cur]) continue;

            isSelect[cur] = true;
            solve(cur + 1, count + 1);
            isSelect[cur] = false;
        }
    }
}
