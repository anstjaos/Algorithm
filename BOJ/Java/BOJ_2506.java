import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0, plus = 1;
        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (next == 1) {
                sum += plus;
                plus++;
            } else plus = 1;
        }
        br.close();

        System.out.println(sum);
    }
}
