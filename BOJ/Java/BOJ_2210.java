import java.io.*;
import java.util.*;

public class BOJ_2210 {
    private static int[][] numbers;
    private static int[] dirX = { -1, 0, 1, 0 }, dirY = { 0, 1, 0, -1 };
    private static Set<String> numberSet;

    private static class Number {
        int x, y, count;
        String num;

        public Number(int x, int y, int count, String num) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        numbers = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) numbers[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();

        numberSet = new HashSet<>();
        solve();
        System.out.println(numberSet.size());
    }

    private static void solve() {
        Queue<Number> queue = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) queue.add(new Number(i, j, 1, String.valueOf(numbers[i][j])));
        }

        while (!queue.isEmpty()) {
            Number cur = queue.poll();
            if (cur.count == 6) {
                numberSet.add(cur.num);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i], nextY = cur.y + dirY[i];
                if (nextX < 0 || nextY < 0 || nextX >= 5 || nextY >= 5) continue;

                queue.add(new Number(nextX, nextY, cur.count + 1, cur.num + numbers[nextX][nextY]));
            }
        }
    }
}
