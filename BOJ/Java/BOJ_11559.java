import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_11559 {
    private static char[][] input = new char[15][6];
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};
    private static List<Block> blockList;
    private static boolean[][] visit;

    private static class Block {
        public int x, y;

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        for (int i = 0; i < 12; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 6; j++) {
                input[i][j] = temp.charAt(j);
            }
        }
        br.close();

        int result = 0;
        while (true) {
            boolean isBomb = false;
            visit = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (input[i][j] != '.') {
                        blockList = new ArrayList<>();
                        bfs(i, j, input[i][j]);

                        if (blockList.size() >= 4) {
                            isBomb = true;
                            for (Block block : blockList) {
                                input[block.x][block.y] = '.';
                            }
                        }
                    }
                }
            }

            if (!isBomb) break;
            result++;
            for (int col = 0; col < 6; col++) {
                for (int i = 11; i > 0; i--) {
                    if (input[i][col] == '.') {
                        for (int j = i - 1; j >= 0; j--) {
                            if (input[j][col] != '.') {
                                input[i][col] = input[j][col];
                                input[j][col] = '.';
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static void bfs(int x, int y, char blockColor) {
        Queue<Block> queue = new LinkedList<>();
        queue.add(new Block(x, y));
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Block cur = queue.poll();
            blockList.add(cur);

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i], nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= 12 || nextY >= 6) continue;
                if (visit[nextX][nextY] || input[nextX][nextY] != blockColor) continue;

                visit[nextX][nextY] = true;
                Block block = new Block(nextX, nextY);
                queue.add(block);
            }
        }
    }
}
