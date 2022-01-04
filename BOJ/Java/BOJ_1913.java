import java.io.*;

public class BOJ_1913 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        br.close();

        int[][] map = new int[N][N];
        int num = 1;
        int x = N / 2, y = N / 2;
        int limit = 1;

        while (true) {
            for (int i = 0; i < limit; i++) {
                map[y--][x] = num++;
            }
            if (num - 1 == N * N) break;

            for (int i = 0; i < limit; i++) {
                map[y][x++] = num++;
            }
            limit++;
            for (int i = 0; i < limit; i++) {
                map[y++][x] = num++;
            }
            for (int i = 0; i < limit; i++) {
                map[y][x--] = num++;
            }
            limit++;
        }

        StringBuilder sb = new StringBuilder();

        x = y = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (T == map[i][j]) {
                    y = i + 1;
                    x = j + 1;
                }
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(y + " " + x);
        System.out.println(sb);
    }
}
