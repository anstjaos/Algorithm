import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16198 {
    private static boolean[] isSelected;
    private static int[] arr;
    private static int result = Integer.MIN_VALUE;
    private static int N;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        N = Integer.parseInt(br.readLine());
        isSelected = new boolean[N];
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        solve(0, N);
        System.out.println(result);
    }

    private static void solve(int cur, int count) {
        if (count == 2) {
            result = Math.max(result, cur);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            if (isSelected[i]) continue;

            int left = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (!isSelected[j]) {
                    left = arr[j];
                    break;
                }
            }
            int right = 0;
            for (int j = i + 1; j < N; j++) {
                if (!isSelected[j]) {
                    right = arr[j];
                    break;
                }
            }

            isSelected[i] = true;
            solve(cur + (left * right), count - 1);
            isSelected[i] = false;
        }
    }
}
