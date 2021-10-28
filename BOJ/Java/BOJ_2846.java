import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2846 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        int result = 0;
        int startIdx = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] <= arr[i-1]) {
                result = Math.max(result, arr[i-1] - arr[startIdx]);
                startIdx = i;
            }
        }

        result = Math.max(result, arr[N-1] - arr[startIdx]);
        System.out.println(result);
    }
}
