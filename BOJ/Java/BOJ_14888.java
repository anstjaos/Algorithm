import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14888 {
    private static int N;
    private static int[] arr, order, operator;
    private static int minVal, maxVal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        order = new int[N-1];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) operator[i] = Integer.parseInt(st.nextToken());
        br.close();

        minVal = Integer.MAX_VALUE;
        maxVal = Integer.MIN_VALUE;

        solve(0);

        System.out.println(maxVal);
        System.out.println(minVal);
    }

    private static void solve(int count) {
        if (count == N - 1) {
            int sum = arr[0];

            for (int i = 0; i < N - 1; i++) {
                switch (order[i]) {
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
                        sum /= arr[i+1];
                        break;
                }
            }

            minVal = Math.min(minVal, sum);
            maxVal = Math.max(maxVal, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0) continue;

            operator[i]--;
            order[count] = i;
            solve(count + 1);
            operator[i]++;
        }
    }
}
