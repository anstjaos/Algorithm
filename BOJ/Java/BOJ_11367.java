import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11367 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            sb.append(st.nextToken()).append(" ");

            int score = Integer.parseInt(st.nextToken());

            if (score >= 97) sb.append("A+\n");
            else if (score >= 90) sb.append("A\n");
            else if (score >= 87) sb.append("B+\n");
            else if (score >= 80) sb.append("B\n");
            else if (score >= 77) sb.append("C+\n");
            else if (score >= 70) sb.append("C\n");
            else if (score >= 67) sb.append("D+\n");
            else if (score >= 60) sb.append("D\n");
            else sb.append("F\n");
        }
        br.close();
        System.out.print(sb);
    }
}
