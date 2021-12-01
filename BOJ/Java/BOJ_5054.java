import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5054 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int result = 0;
            for (int i = 0; i < n - 1; i++) {
                result += arr[i+1] - arr[i];
            }
            result += arr[n - 1] - arr[0];
            sb.append(result).append("\n");
        }

        br.close();
        System.out.print(sb);
    }
}
