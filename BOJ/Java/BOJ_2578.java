import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2578 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[][] bingo = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) bingo[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] input = new int[30];
        int count = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) input[count++] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int result = 0;
        int bingoCount = 0;

        for (int i = 0; i < 25; i++) {
            result++;
            int curNum = input[i];

            int row = -1, col = 0;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (bingo[j][k] == curNum) {
                        row = j;
                        col = k;
                        break;
                    }
                }
                if (row != -1) break;
            }

            bingo[row][col] = 0;
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (bingo[row][j] != 0) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) bingoCount++;

            isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][col] != 0) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) bingoCount++;

            if (row == col) {
                isBingo = true;
                if (bingo[0][0] != 0 || bingo[1][1] != 0 || bingo[2][2] != 0 || bingo[3][3] != 0 || bingo[4][4] != 0) {
                    isBingo = false;
                }
                if (isBingo) bingoCount++;
            }

            if ((row == 0 && col == 4) || (row + col == 4)) {
                isBingo = true;
                if (bingo[4][0] != 0 || bingo[3][1] != 0 || bingo[2][2] != 0 || bingo[1][3] != 0 || bingo[0][4] != 0) {
                    isBingo = false;
                }
                if (isBingo) bingoCount++;
            }

            if (bingoCount >= 3) break;
        }

        System.out.println(result);
    }
}
