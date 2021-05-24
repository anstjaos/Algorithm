import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10819 {
    private static int sum, N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sum = 0;
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        solve(0);
        System.out.println(sum);
    }

    private static void solve(int index) {
        if (index == N-1) {
            int temp = 0;
            for (int i = 0; i < N -1; i++) {
                temp += Math.abs(arr[i] - arr[i+1]);
            }

            sum = Math.max(sum, temp);
            return;
        }

        for (int i = index + 1; i < N; i++) {
            solve(index + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
            solve(index + 1);

            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}
