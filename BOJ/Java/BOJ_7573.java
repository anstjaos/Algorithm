import java.io.*;
import java.util.StringTokenizer;

public class BOJ_7573 {
    private static class Fish {
        int x, y;

        public Fish(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Fish[] fishArr;
    private static int N, L, M, result;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;

        fishArr = new Fish[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            fishArr[i] = new Fish(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 1; k < L / 2; k++) {
                    findFish(i, j, k, L/2 - k);
                }
            }
        }

        System.out.println(result);
    }

    private static void findFish(int start, int end, int lengthX, int lengthY) {
        int count = 0;

        for (int i = 0; i < M; i++) {
            if (fishArr[start].x <= fishArr[i].x && fishArr[i].x <= fishArr[start].x + lengthX
                    && fishArr[end].y <= fishArr[i].y && fishArr[i].y <= fishArr[end].y + lengthY) {
                count++;
            }
        }

        result = Math.max(result, count);
    }
}
