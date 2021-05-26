import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15658 {
    private static int N, maxVal, minVal;
    private static int[] arr, operators, selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        maxVal = Integer.MIN_VALUE;
        minVal = Integer.MAX_VALUE;
        arr = new int[N];
        operators = new int[4];
        selected = new int[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) operators[i] = Integer.parseInt(st.nextToken());
        br.close();

        solve(0);
        System.out.println(maxVal);
        System.out.println(minVal);
    }

    private static void solve(int index) {
        if (index == N - 1) {
            int sum = arr[0];

            for (int i = 0; i < N - 1; i++) {
                switch (selected[i]) {
                    case 0:
                        sum += arr[i+1];
                        break;
                    case 1:
                        sum -= arr[i+1];
                        break;
                    case 2:
                        sum *= arr[i+1];
                        break;
                    case 3:
                        if (sum > 0) sum /= arr[i+1];
                        else sum = (Math.abs(sum) / arr[i+1]) * -1;
                        break;
                }
            }
            maxVal = Math.max(maxVal, sum);
            minVal = Math.min(minVal, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] <= 0) continue;

            operators[i]--;
            selected[index] = i;
            solve(index+1);
            operators[i]++;
        }
    }
}
