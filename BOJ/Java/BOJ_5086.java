import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5086 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;

            if (a > b) {
                if (a % b == 0) sb.append("multiple\n");
                else sb.append("neither\n");
            } else {
                if (b % a == 0) sb.append("factor\n");
                else sb.append("neither\n");
            }
        }
        br.close();
        System.out.print(sb);
    }
}
