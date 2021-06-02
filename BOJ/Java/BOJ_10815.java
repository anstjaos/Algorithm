import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int findNum = Integer.parseInt(st.nextToken());

            int leftIndex = 0, rightIndex = N - 1;
            boolean isFind = false;

            while (leftIndex <= rightIndex) {
                int mid = (leftIndex + rightIndex) / 2;

                if (arr[mid] == findNum) {
                    isFind = true;
                    break;
                }

                if (arr[mid] < findNum) leftIndex = mid + 1;
                else rightIndex = mid - 1;
            }

            if (isFind) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        br.close();
        System.out.println(sb);
    }
}
