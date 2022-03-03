import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13300 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[][] count = new int[10][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken());
            count[Y][S]++;
        }
        br.close();

        int roomCount = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (count[i][j] == 0) continue;

                roomCount += (count[i][j] / K);
                count[i][j] %= K;
                if (count[i][j] != 0) roomCount++;
            }
        }

        System.out.println(roomCount);
    }
}
