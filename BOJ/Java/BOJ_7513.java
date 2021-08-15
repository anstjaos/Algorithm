import java.io.*;
import java.util.StringTokenizer;

public class BOJ_7513 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= tc; t++) {
            sb.append("Scenario #").append(t).append(":\n");

            int m = Integer.parseInt(br.readLine());
            String[] input = new String[m];
            for (int i = 0; i < m; i++) input[i] = br.readLine();

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int count = Integer.parseInt(st.nextToken());
                for (int j = 0; j < count; j++) sb.append(input[Integer.parseInt(st.nextToken())]);
                sb.append("\n");
            }
            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
