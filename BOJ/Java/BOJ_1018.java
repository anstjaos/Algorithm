import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1018 {

    private static final String[] chess = new String[]{"BWBWBWBW", "WBWBWBWB"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        String[] input = new String[N+5];
        int result = 2123456789;
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                result = Math.min(result, getMinChess(input, i, j));
            }
        }
        System.out.println(result);
        br.close();
    }

    private static int getMinChess(String[] input, int startRow, int startCol) {
        int result = 2123456789;
        int start = 0;

        int temp = 0;
        for (int i = 0; i < 8; i++) {
            String curRow = input[startRow + i];
            for (int j = 0; j < 8; j++) {
                if (curRow.charAt(startCol + j) != chess[start].charAt(j)) {
                    temp++;
                }
            }
            start = (start+ 1) % 2;
        }

        result = Math.min(result, temp);
        temp = 0;
        start = 1;
        for (int i = 0; i < 8; i++) {
            String curRow = input[startRow + i];
            for (int j = 0; j < 8; j++) {
                if (curRow.charAt(startCol + j) != chess[start].charAt(j)) {
                    temp++;
                }
            }
            start = (start+ 1) % 2;
        }

        result = Math.min(result, temp);

        return result;
    }
}
