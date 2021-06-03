import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14889 {
    private static int N, result;
    private static boolean[] startTeam;
    private static int[][] squard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        startTeam = new boolean[N];
        squard = new int[N][N];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                squard[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        solve(0, 0);
        System.out.println(result);
    }

    private static void solve(int cur, int count) {
        if (count == N / 2) {
            int startTeamScore = 0;
            for (int i = 0; i < N; i++) {
                if (!startTeam[i]) continue;
                for (int j = 0; j < N; j++) {
                    if (!startTeam[j] || i == j) continue;

                    startTeamScore += squard[i][j];
                }
            }

            int linkTeamScore = 0;
            for (int i = 0; i < N; i++) {
                if (startTeam[i]) continue;
                for (int j = 0; j < N; j++) {
                    if (startTeam[j] || i == j) continue;

                    linkTeamScore += squard[i][j];
                }
            }

            result = Math.min(result, Math.abs(startTeamScore - linkTeamScore));
            return;
        }

        for (; cur < N; cur++) {
            startTeam[cur] = true;
            solve(cur + 1, count + 1);
            startTeam[cur] = false;
        }
    }
}
