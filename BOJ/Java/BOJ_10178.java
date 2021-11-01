import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10178 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());

            sb.append("You get ").append(c / v).append(" piece(s) and your dad gets ").append(c % v).append(" piece(s).\n");
        }
        br.close();

        System.out.print(sb);
    }
}
