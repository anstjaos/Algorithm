import java.io.*;
import java.util.*;

public class BOJ_1525 {
    private static int[] dirX = {-1, 0, 1, 0}, dirY = {0, 1, 0, -1};
    private static Set<Integer> check = new HashSet<>();

    private static class Puzzle {
        int state, count;

        public Puzzle(int state, int count) {
            this.state = state;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[][] arr = new int[3][3];
        int start = 1;

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                start = (start * 10) + arr[i][j];
            }
        }

        check.add(start);
        System.out.println(bfs(start));
        br.close();
    }

    private static int bfs(int start) {
        int result = -1;
        Queue<Puzzle> queue = new LinkedList<>();
        queue.add(new Puzzle(start, 0));

        while (!queue.isEmpty()) {
            Puzzle cur = queue.poll();
            if (cur.state == 1123456780) {
                result = cur.count;
                break;
            }

            int[][] arr = new int[3][3];
            int num = cur.state;

            int curX = 0, curY = 0;
            for (int i = 2; i >= 0; i--) {
                for (int j = 2; j >= 0; j--) {
                    arr[i][j] = num % 10;
                    if (arr[i][j] == 0) {
                        curX = i;
                        curY = j;
                    }
                    num /= 10;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dirX[i], nextY = curY + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= 3 || nextY >= 3) continue;
                int[][] temp = new int[3][3];
                for (int j = 0; j < 3; j++) {
                    temp[j] = Arrays.copyOf(arr[j], 3);
                }

                int before = temp[curX][curY];
                temp[curX][curY] = temp[nextX][nextY];
                temp[nextX][nextY] = before;

                int curNum = 1;
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) curNum = curNum * 10 + temp[j][k];
                }

                if (check.contains(curNum)) continue;

                queue.add(new Puzzle(curNum, cur.count + 1));
                check.add(curNum);
            }
        }

        return result;
    }
}
