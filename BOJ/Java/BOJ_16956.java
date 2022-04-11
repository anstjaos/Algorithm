import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16956 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == '.') map[i][j] = 'D';
            }
        }
        br.close();

        boolean isPossible = false;
        int[] dirX = { -1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'W') {
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + dirX[k], nextY = j + dirY[k];

                        if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
                        if (map[nextX][nextY] == 'S') {
                            isPossible = true;
                            break;
                        }
                    }
                }

                if (isPossible) break;
            }
            if (isPossible) break;
        }

        StringBuilder sb = new StringBuilder();
        if (!isPossible) {
            sb.append("1\n");
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) sb.append(map[i][j]);
                sb.append("\n");
            }
        } else {
            sb.append("0\n");
        }

        System.out.print(sb);
    }
}
