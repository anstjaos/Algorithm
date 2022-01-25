import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2875 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int maxTeam = 0;
        for (int i = 0; i <= K; i++) {
            int tempN = N - i, tempM = M - (K - i);
            maxTeam = Math.max(maxTeam, Math.min(tempN / 2, tempM));
        }

        System.out.println(maxTeam);
    }
}
