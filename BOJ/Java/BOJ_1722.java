import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1722 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        long[] factorial = new long[21];
        boolean[] check = new boolean[21];
        Arrays.fill(factorial, 1);

        for (int i = 1; i <= 20; i++) factorial[i] = factorial[i-1] * i;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int query = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        StringBuilder sb = new StringBuilder();
        if (query == 1) {
            long k = Long.parseLong(st.nextToken());

            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (check[j]) continue;

                    if (factorial[N - i - 1] < k) k -= factorial[N - i - 1];
                    else {
                        arr[i] = j;
                        check[j] = true;
                        break;
                    }
                }
            }

            for (int i = 0; i < N; i++) sb.append(arr[i]).append(" ");
        } else {
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            long ans = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < arr[i]; j++) {
                    if (!check[j]) ans += factorial[N - i - 1];
                }
                check[arr[i]] = true;
            }
            sb.append(ans);
        }
        br.close();

        System.out.println(sb);
    }
}
