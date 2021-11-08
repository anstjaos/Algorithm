import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            boolean findNum = false;
            int left = 0, right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] == num) {
                    findNum = true;
                    break;
                }
                else if (arr[mid] < num) left = mid + 1;
                else right = mid - 1;
            }

            if (findNum) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.print(sb);
        br.close();
    }
}
