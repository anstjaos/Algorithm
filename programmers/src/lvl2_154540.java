import java.util.*;

public class lvl2_154540 {
    private class Point {
        int x, y;

        Point() {}
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[] solution(String[] maps) {
        boolean[][] isVisit = new boolean[maps.length][maps[0].length()];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (isVisit[i][j] || maps[i].charAt(j) == 'X') continue;

                answer.add(getSurvivalDays(i, j, isVisit, maps));
            }
        }

        if (answer.size() == 0) {
            return new int[]{-1};
        }

        Collections.sort(answer);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int getSurvivalDays(int x, int y, boolean[][] isVisit, String[] maps) {
        int[] dirX = {-1, 0, 1, 0}, dirY = {0, 1, 0, -1};
        Queue<Point> queue = new LinkedList<>();

        int sum = maps[x].charAt(y) - '0';
        isVisit[x][y] = true;
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];

                if (nextX < 0 || nextY < 0 || nextX >= maps.length || nextY >= maps[0].length()) continue;
                if (isVisit[nextX][nextY] || maps[nextX].charAt(nextY) == 'X') continue;

                sum += maps[nextX].charAt(nextY) - '0';
                queue.add(new Point(nextX, nextY));
                isVisit[nextX][nextY] = true;
            }
        }

        return sum;
    }
}
