import java.io.*;
import java.util.Arrays;

public class BOJ_2309 {
    private static boolean[] visit;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        for (int i = 0 ; i < 9; i++) arr[i] = Integer.parseInt(br.readLine());
        br.close();
        Arrays.sort(arr);

        visit = new boolean[9];
        solve(0, 0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (visit[i]) sb.append(arr[i]).append("\n");
        }

        System.out.print(sb);
    }

    private static boolean solve(int index, int sum, int count) {
        if (count == 7) {
            return sum == 100;
        }

        for (int i = index; i < 9; i++) {
            visit[i] = true;
            if (solve(i + 1, sum + arr[i], count + 1)) return true;
            visit[i] = false;
        }

        return false;
    }
}
