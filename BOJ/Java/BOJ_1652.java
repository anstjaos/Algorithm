import java.io.*;

public class BOJ_1652 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        String[] map = new String[N];
        for (int i = 0; i < N; i++) map[i] = br.readLine();
        br.close();

        boolean[][] width = new boolean[N][N];
        boolean[][] length = new boolean[N][N];

        int totalWidth = 0, totalLength = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i].charAt(j) == 'X') continue;

                if (!width[i][j]) {
                    int widthCount = 1;
                    for (int k = j + 1; k < N; k++) {
                        if (map[i].charAt(k) == 'X' || width[i][k]) break;
                        widthCount++;
                    }

                    if (widthCount >= 2) {
                        totalWidth++;
                        for (int k = 0; k < widthCount; k++) width[i][j + k] = true;
                    }
                }

                if (!length[i][j]) {
                    int lengthCount = 1;
                    for (int k = i + 1; k < N; k++) {
                        if (map[k].charAt(j) == 'X' || length[k][j]) break;
                        lengthCount++;
                    }

                    if (lengthCount >= 2) {
                        totalLength++;
                        for (int k = 0; k < lengthCount; k++) length[i + k][j] = true;
                    }
                }
            }
        }

        System.out.println(totalWidth + " " + totalLength);
    }
}
