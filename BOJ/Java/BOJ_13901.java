import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13901 {
    private static int[] dirX = {-1, 1, 0, 0};
    private static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());
        int[][] map = new int[r][c];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int curX = Integer.parseInt(st.nextToken()), curY = Integer.parseInt(st.nextToken());

        int[] visitOrder = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int next = Integer.parseInt(st.nextToken()) - 1;
            visitOrder[i] = next;
        }
        br.close();

        int curOrder = 0;
        map[curX][curY] = 1;
        while (true) {
            int nextOrder = curOrder;
            boolean notToGo = false;

            int nextX = 0, nextY = 0;
            for (int i = 0; i <= 4; i++) {
                if (i == 4) {
                    notToGo = true;
                    break;
                }
                nextOrder = (curOrder + i) % 4;

                nextX = curX + dirX[visitOrder[nextOrder]];
                nextY = curY + dirY[visitOrder[nextOrder]];

                if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) continue;
                if (map[nextX][nextY] == 1) continue;

                break;
            }

            if (notToGo) break;
            curX = nextX;
            curY = nextY;
            map[curX][curY] = 1;
            curOrder = nextOrder;
        }

        System.out.println(curX + " " + curY);
    }
}
