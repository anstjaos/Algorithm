import java.util.*;

public class lvl2_86971 {
    private boolean[][] connect;
    public int solution(int n, int[][] wires) {
        connect = new boolean[n + 1][n + 1];
        for (int[] wire : wires) {
            connect[wire[0]][wire[1]] = true;
            connect[wire[1]][wire[0]] = true;
        }

        int answer = 2123456789;
        for (int[] wire : wires) {
            connect[wire[0]][wire[1]] = false;
            connect[wire[1]][wire[0]] = false;

            answer = Math.min(answer, bfs(n));

            connect[wire[0]][wire[1]] = true;
            connect[wire[1]][wire[0]] = true;
        }
        return answer;
    }

    private int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] isVisit = new boolean[n + 1];
        isVisit[1] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            Integer num = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (isVisit[i]) continue;
                if (!connect[num][i]) continue;

                queue.add(i);
                isVisit[i] = true;
                count++;
            }
        }

        return (int) Math.abs(n - 2 * count);
    }
}
