import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11497 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);

            int[] result = new int[N];
            int start = 0, end = N - 1;

            for (int i = 0; i < N; i++) {
                if ((i & 1) == 0) {
                    result[start++] = arr[i];
                } else {
                    result[end--] = arr[i];
                }
            }

            int maxDiff = Math.abs(result[0] - result[N - 1]);
            for (int i = 1; i < N; i++) {
                maxDiff = Math.max(maxDiff, Math.abs(result[i] - result[i - 1]));
            }
            sb.append(maxDiff).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
