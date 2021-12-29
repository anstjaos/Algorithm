import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1952 {
    private static int[] dirX = {0, 1, 0, -1};
    private static int[] dirY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        boolean[][] isVisit = new boolean[N][M];
        br.close();

        int curX = 0, curY = 0, curDir = 0, count = 0;
        while (true) {
            isVisit[curX][curY] = true;

            int nextDir = curDir, nextX = 0, nextY = 0;
            for (int i = 0; i < 3; i++) {
                nextDir = (curDir + i) % 4;
                nextX = curX + dirX[nextDir];
                nextY = curY + dirY[nextDir];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (isVisit[nextX][nextY]) continue;

                break;
            }
            if (Math.abs(curDir - nextDir) == 2) break;

            if (curDir != nextDir) count++;
            curDir = nextDir;
            curX = nextX;
            curY = nextY;
        }
        System.out.println(count);
    }
}
