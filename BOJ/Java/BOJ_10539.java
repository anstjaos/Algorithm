import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            int result = (cur * i) - sum;
            sb.append(result).append(" ");
            sum += result;
        }
        br.close();
        System.out.println(sb);
    }
}
