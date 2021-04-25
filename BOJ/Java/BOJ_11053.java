import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] lengthArr = new int[N];

        lengthArr[0] = 1;
        int maxResult = 1;
        for (int i = 1; i < N; i++) {
            int result = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] >= arr[i]) continue;

                result = Math.max(result, lengthArr[j]);
            }
            lengthArr[i] = result + 1;
            maxResult = Math.max(maxResult, lengthArr[i]);
        }

        System.out.println(maxResult);
        br.close();
    }
}
