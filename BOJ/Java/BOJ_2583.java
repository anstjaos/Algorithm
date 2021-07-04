import java.io.*;
import java.util.*;

public class BOJ_2583 {
    private static boolean[][] arr;
    private static int N, M, K;
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()), x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) arr[x][y] = true;
            }
        }
        br.close();

        List<Integer> widthArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!arr[i][j]) widthArr.add(dfs(i, j));
            }
        }

        Collections.sort(widthArr);
        StringBuilder sb = new StringBuilder();
        sb.append(widthArr.size()).append("\n");
        for (int i = 0; i < widthArr.size(); i++) sb.append(widthArr.get(i)).append(" ");
        System.out.println(sb);
    }

    private static int dfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        arr[x][y] = true;
        int result = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dirX[i];
                int nextY = cur[1] + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (arr[nextX][nextY]) continue;

                arr[nextX][nextY] = true;
                result++;
                queue.add(new int[]{nextX, nextY});
            }
        }
        return result;
    }
}
