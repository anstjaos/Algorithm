import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2529 {
    private static int K;
    private static char[] arr;
    private static boolean[] visit;
    private static String minVal, maxVal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new char[K];
        for (int i = 0; i < K; i++) arr[i] = st.nextToken().charAt(0);
        visit = new boolean[10];
        minVal = "999999999";
        maxVal = "000000000";
        br.close();

        solve(0, 0,"");

        StringBuilder sb = new StringBuilder();
        sb.append(maxVal).append("\n").append(minVal);
        System.out.println(sb);
    }

    private static void solve(int index, int before, String num) {
        if (index == K + 1) {
            minVal = minVal.compareTo(num) < 0 ? minVal : num;
            maxVal = maxVal.compareTo(num) < 0 ? num : maxVal;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visit[i]) continue;

            if (index == 0) {
                visit[i] = true;
                solve(index + 1, i, num + i);
                visit[i] = false;
            } else {
                boolean isSuccess = true;
                switch (arr[index - 1]) {
                    case '<':
                        if (before > i) isSuccess = false;
                        break;
                    case '>':
                        if (before < i) isSuccess = false;
                        break;
                }

                if (!isSuccess) continue;

                visit[i] = true;
                solve(index + 1, i, num + i);
                visit[i] = false;
            }
        }
    }
}
