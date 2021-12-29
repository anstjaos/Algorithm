import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10163 {
    private static class ColorPaper {
        int startX, startY, width, height;

        public ColorPaper(int startX, int startY, int width, int height) {
            this.startX = startX;
            this.startY = startY;
            this.width = width;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[][] arr = new int[1005][1005];
        int N = Integer.parseInt(br.readLine());

        ColorPaper[] colorPapers = new ColorPaper[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            colorPapers[i] = new ColorPaper(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();

        for (int k = 0; k < N; k++) {
            ColorPaper cur = colorPapers[k];

            for (int i = 0; i < cur.width; i++) {
                for (int j = 0; j < cur.height; j++) {
                    arr[cur.startX + i][cur.startY + j] = k + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < N; k++) {
            ColorPaper cur = colorPapers[k];

            int count = 0;
            for (int i = 0; i < cur.width; i++) {
                for (int j = 0; j < cur.height; j++) {
                    if (arr[cur.startX + i][cur.startY + j] == k + 1) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
