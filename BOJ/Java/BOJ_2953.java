import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int winnerNum = 0, winnerScore = 0;
        for (int i = 1; i <= 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int score = 0;
            for (int j = 0; j < 4; j++) score += Integer.parseInt(st.nextToken());

            if (score > winnerScore) {
                winnerNum = i;
                winnerScore = score;
            }
        }
        br.close();

        System.out.println(winnerNum + " " + winnerScore);
    }
}
