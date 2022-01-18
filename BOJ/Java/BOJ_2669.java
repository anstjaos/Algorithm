import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2669 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        boolean[][] arr = new boolean[105][105];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken()), startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken()), endY = Integer.parseInt(st.nextToken());

            for (int x = startX; x < endX; x++) {
                for (int y = startY; y < endY; y++) arr[x][y] = true;
            }
        }
        br.close();

        int result = 0;
        for (int i = 0; i < 105; i++) {
            for (int j = 0; j < 105; j++) {
                if (arr[i][j]) result++;
            }
        }

        System.out.println(result);
    }
}
