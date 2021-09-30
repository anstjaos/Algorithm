import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14503 {
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int curX = Integer.parseInt(st.nextToken()), curY = Integer.parseInt(st.nextToken()), curDir = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        boolean[][] isClear = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int count = 0;
        while (true) {
            if (!isClear[curX][curY]) {
                isClear[curX][curY] = true;
                count++;
            }

            boolean isNext = false;
            int originDir = curDir;
            for (int i = 0; i < 4; i++) {
                curDir = (curDir + 3) % 4;
                int nextX = curX + dirX[curDir], nextY = curY + dirY[curDir];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;

                if (arr[nextX][nextY] == 0 && !isClear[nextX][nextY]) {
                    isNext = true;
                    curX = nextX;
                    curY = nextY;
                    break;
                }
            }

            if (!isNext) {
                int nextDir = (originDir + 2) % 4;
                int nextX = curX + dirX[nextDir], nextY = curY + dirY[nextDir];
                curDir = originDir;
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) break;
                if (arr[nextX][nextY] == 1) break;

                curX = nextX;
                curY = nextY;
            }
        }

        System.out.println(count);
    }
}
