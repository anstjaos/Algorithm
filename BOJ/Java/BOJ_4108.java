import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4108 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int[] dirX = {-1, -1, 0, 1, 1, 1, 0, -1}, dirY = {0, 1, 1, 1, 0, -1, -1, -1};

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

            if (r == 0 && c == 0) break;

            String[] arr = new String[r];
            for (int i = 0; i < r; i++) {
                arr[i] = br.readLine();
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    char cur = arr[i].charAt(j);
                    if (cur == '*') {
                        sb.append(cur);
                        continue;
                    }

                    int count = 0;
                    for (int k = 0; k < 8; k++) {
                        int nextX = i + dirX[k], nextY = j + dirY[k];

                        if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) continue;
                        if (arr[nextX].charAt(nextY) != '*') continue;

                        count++;
                    }
                    sb.append(count);
                }
                sb.append("\n");
            }
        }
        br.close();
        System.out.print(sb);
    }
}
