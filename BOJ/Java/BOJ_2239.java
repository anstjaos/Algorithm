import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_2239 {
    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int[][] sudoku;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) sudoku[i][j] = input.charAt(j) - '0';
        }
        br.close();

        dfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j =0 ; j < 9; j++) sb.append(sudoku[i][j]);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static boolean dfs() {
        Point cur = findNextPoint();
        if (cur == null) return true;

        List<Integer> possibleNum = findPossibleNum(cur);
        if (possibleNum.size() == 0) return false;

        for (Integer next : possibleNum) {
            sudoku[cur.x][cur.y] = next;
            if (dfs()) return true;
        }
        sudoku[cur.x][cur.y] = 0;
        return false;
    }

    private static Point findNextPoint() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) return new Point(i, j);
            }
        }

        return null;
    }

    private static List<Integer> findPossibleNum(Point p) {
        boolean[] check = new boolean[10];
        Arrays.fill(check, true);

        for (int i = 0; i < 9; i++) {
            check[sudoku[p.x][i]] = false;
            check[sudoku[i][p.y]] = false;
        }

        int startX = p.x - (p.x % 3);
        int startY = p.y - (p.y % 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                check[sudoku[startX + i][startY + j]] = false;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1 ; i < 10; i++) {
            if (check[i]) result.add(i);
        }

        return result;
    }
}
