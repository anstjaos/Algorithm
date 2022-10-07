import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1, maxX = 0, maxY = 0;
        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur > max) {
                    max = cur;
                    maxX = i;
                    maxY = j;
                }
            }
        }
        br.close();
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(maxX).append(" ").append(maxY);
        System.out.println(sb);
    }
}
