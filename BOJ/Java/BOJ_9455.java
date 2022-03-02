import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9455 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());

            int[][] map = new int[row][col];
            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int moveCount = 0;
            for (int i = 0; i < col; i++) {
                for (int j = row - 2; j >= 0; j--) {
                    if (map[j][i] == 0) continue;

                    map[j][i] = 0;
                    boolean isMove = false;
                    for (int k = j + 1; k < row; k++) {
                        if (map[k][i] == 1) {
                            map[k - 1][i] = 1;
                            moveCount += (k - j - 1);
                            isMove = true;
                            break;
                        }
                    }

                    if (!isMove) {
                        map[row-1][i] = 1;
                        moveCount += (row - 1 - j);
                    }
                }
            }

            sb.append(moveCount).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
