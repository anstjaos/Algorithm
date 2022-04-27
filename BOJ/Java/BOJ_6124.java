import java.io.*;
import java.util.StringTokenizer;

public class BOJ_6124 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int maxSum = 0, resultRow = 999, resultCol = 999;
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    for (int t = 0; t < 3; t++) sum += map[i + k][j + t];
                }

                if (maxSum < sum) {
                    maxSum = sum;
                    resultRow = i;
                    resultCol = j;
                } else if (maxSum == sum) {
                    if (resultRow > i) {
                        resultRow = i;
                        resultCol = j;
                    } else if (resultRow == i && resultCol > j) {
                        resultCol = j;
                    }
                }
            }
        }

        System.out.println(maxSum);
        System.out.println((resultRow + 1) + " " + (resultCol + 1));
    }
}
