import java.io.*;
import java.util.StringTokenizer;

public class BOJ_8977 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        int startIdx = ((B % N) + N - 1) % N;
        int result = 0;

        for (int i = 0; i < K; i++) {
            int idx = (startIdx + i) % N;
            result += arr[idx];
        }

        System.out.println(result);
    }
}
