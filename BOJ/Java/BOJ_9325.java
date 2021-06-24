import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            int s = Integer.parseInt(br.readLine());

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int q = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken());
                s += q * p;
            }
            sb.append(s).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
