import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        br.close();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int leftIndex = 0, rightIndex = 0;
        int sum = 0, minLen = Integer.MAX_VALUE;

        while (rightIndex < N) {
            sum += arr[rightIndex];

            if (sum >= S) minLen = Math.min(minLen, rightIndex - leftIndex + 1);
            while (true) {
                if (sum - arr[leftIndex] < S || leftIndex == rightIndex) break;
                sum -= arr[leftIndex];
                leftIndex++;
                minLen = Math.min(minLen, rightIndex - leftIndex + 1);
            }
            rightIndex++;
        }

        while (leftIndex < N) {
            if (sum - arr[leftIndex] < S) break;
            sum -= arr[leftIndex];
            leftIndex++;
            minLen = Math.min(minLen, rightIndex - leftIndex);
        }
        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}
