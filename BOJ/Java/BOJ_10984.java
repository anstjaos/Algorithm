import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int score = 0;
            double gpa = 0.0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Integer curScore = Integer.parseInt(st.nextToken());
                score += curScore;
                gpa += (double) curScore * Double.parseDouble(st.nextToken());
            }

            sb.append(score).append(" ").append(String.format("%.1f", gpa / (double) score)).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
