import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_5800 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int k = 1; k <= K; k++) {
            sb.append("Class ").append(k).append("\n");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, Collections.reverseOrder());

            int maxDiff = 0;
            for (int i = 0; i < N - 1; i++) {
                maxDiff = Math.max(maxDiff, arr[i] - arr[i + 1]);
            }
            sb.append("Max ").append(arr[0]).append(", Min ").append(arr[N-1]).append(", Largest gap ").append(maxDiff).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
