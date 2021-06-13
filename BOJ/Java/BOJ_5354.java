import java.io.*;

public class BOJ_5354 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                sb.append('#');
            }
            sb.append("\n");
            for (int i = 0; i < n - 2; i++) {
                sb.append('#');
                for (int j = 0; j < n - 2; j++) sb.append('J');
                sb.append('#').append("\n");
            }

            if (n > 1) {
                for (int i = 0; i < n; i++) {
                    sb.append('#');
                }
                sb.append("\n");
            }
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
