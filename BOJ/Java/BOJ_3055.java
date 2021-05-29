import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055 {
    private static class Move {
        int x, y;

        public Move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int dirX[] = {-1, 0, 1, 0};
    private static int dirY[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        Queue<Move> water = new LinkedList<>();
        Queue<Move> gosum = new LinkedList<>();
        boolean[][] visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                char cur = input.charAt(j);
                map[i][j] = cur;
                if (cur == 'S') {
                    gosum.add(new Move(i, j));
                    visit[i][j] = true;
                }
                if (cur == '*') water.add(new Move(i, j));
            }
        }
        br.close();

        int count = 0;
        while (true) {
            int gosumSize = gosum.size();
            if (gosumSize == 0) {
                count = Integer.MAX_VALUE;
                break;
            }

            boolean isSuccess = false;
            for (int i = 0; i < gosumSize; i++) {
                Move cur = gosum.poll();

                char curChar = map[cur.x][cur.y];
                if (curChar == '*') continue;
                if (curChar == 'D') {
                    isSuccess = true;
                    break;
                }

                for (int x = 0; x < 4; x++) {
                    int nextX = cur.x + dirX[x];
                    int nextY = cur.y + dirY[x];

                    if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
                    char next = map[nextX][nextY];
                    if (next == 'X' || next == '*' || visit[nextX][nextY]) continue;

                    visit[nextX][nextY] = true;
                    gosum.add(new Move(nextX, nextY));
                }
            }

            if (isSuccess) break;

            int waterSize = water.size();
            for (int i = 0; i < waterSize; i++) {
                Move cur = water.poll();

                for (int x = 0; x < 4; x++) {
                    int nextX = cur.x + dirX[x];
                    int nextY = cur.y + dirY[x];

                    if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
                    char next = map[nextX][nextY];
                    if (next == 'X' || next == 'D' || next == '*') continue;

                    map[nextX][nextY] = '*';
                    water.add(new Move(nextX, nextY));
                }
            }

            count++;
        }

        System.out.println(count == Integer.MAX_VALUE ? "KAKTUS" : count);
    }
}
