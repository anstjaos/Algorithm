import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = new ArrayList<>();
        for (int i = N; i >= 1; i--) {
            result.add(arr[i], i);
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int res : result) {
            sb.append(res).append(" ");
        }
        System.out.println(sb);
    }
}
