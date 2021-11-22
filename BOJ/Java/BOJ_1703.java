import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1703 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            if (a == 0) break;

            int cur = 1;
            for (int i = 0; i < a; i++) {
                cur *= Integer.parseInt(st.nextToken());
                cur -= Integer.parseInt(st.nextToken());
            }

            sb.append(cur).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
