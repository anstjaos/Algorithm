import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2003 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        int sum = 0, left = 0, right = 0, result = 0;

        while (true) {
            if (sum >= M) {
                sum -= arr[left++];
            } else if(right >= N) {
                break;
            } else {
                sum += arr[right++];
            }

            if (sum == M) result++;
        }

        System.out.println(result);
    }
}
