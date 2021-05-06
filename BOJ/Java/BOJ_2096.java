import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] maxArr = new int[N][3];
        int[][] minArr = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                maxArr[i][j] = minArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            maxArr[i][0] += Math.max(maxArr[i-1][0], maxArr[i-1][1]);
            minArr[i][0] += Math.min(minArr[i-1][0], minArr[i-1][1]);

            maxArr[i][1] += Math.max(maxArr[i-1][0], Math.max(maxArr[i-1][1], maxArr[i-1][2]));
            minArr[i][1] += Math.min(minArr[i-1][0], Math.min(minArr[i-1][1], minArr[i-1][2]));

            maxArr[i][2] += Math.max(maxArr[i-1][1], maxArr[i-1][2]);
            minArr[i][2] += Math.min(minArr[i-1][1], minArr[i-1][2]);
        }

        int maxResult = Math.max(maxArr[N-1][0], Math.max(maxArr[N-1][1], maxArr[N-1][2]));
        int minResult = Math.min(minArr[N-1][0], Math.min(minArr[N-1][1], minArr[N-1][2]));

        System.out.println(maxResult + " " + minResult);
        br.close();
    }
}
