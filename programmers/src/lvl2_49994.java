public class lvl2_49994 {
    public int solution(String dirs) {
        int[] dirX = {-1, 0, 1, 0}, dirY = {0, 1, 0, -1};
        boolean[][][] map = new boolean[11][11][4];
        int curX = 5, curY = 5;

        int answer = 0;
        for (Character c : dirs.toCharArray()) {
            int index = getDirIndex(c);

            int nextX = curX + dirX[index];
            int nextY = curY + dirY[index];

            if (nextX < 0 || nextY < 0 || nextX > 10 || nextY > 10) continue;

            if (!map[curX][curY][index]) {
                map[curX][curY][index] = true;
                index = (index + 2) % 4;
                map[nextX][nextY][index] = true;
                answer++;
            }

            curX = nextX;
            curY = nextY;
        }

        return answer;
    }

    private int getDirIndex(char c) {
        return switch (c) {
            case 'U' -> 0;
            case 'D' -> 2;
            case 'L' -> 3;
            case 'R' -> 1;
            default -> -1;
        };
    }
}
