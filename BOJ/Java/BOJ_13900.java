import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13900 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[100005];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        long[] sumArr = new long[100005];
        sumArr[0] = nums[0];

        for (int i = 1; i < N; i++) {
            sumArr[i] = sumArr[i-1] + nums[i];
        }

        long sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += nums[i] * (sumArr[N-1] - sumArr[i]);
        }
        System.out.println(sum);
    }
}
