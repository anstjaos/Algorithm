import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4592 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            int before = 0;
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == before) continue;

                before = num;
                sb.append(num).append(" ");
            }
            sb.append("$\n");
        }
        br.close();

        System.out.print(sb);
    }
}
