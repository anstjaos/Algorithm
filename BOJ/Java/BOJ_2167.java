import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int que = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int startRow, startCol, endRow, endCol;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < que; i++) {
            st = new StringTokenizer(br.readLine());
            startRow = Integer.parseInt(st.nextToken());
            startCol = Integer.parseInt(st.nextToken());
            endRow = Integer.parseInt(st.nextToken());
            endCol = Integer.parseInt(st.nextToken());

            int result = 0;
            for (int j = startRow - 1; j < endRow; j++) {
                for (int k = startCol - 1; k < endCol; k++) {
                    result += arr[j][k];
                }
            }
            sb.append(result + "\n");
        }

        System.out.println(sb.toString());
    }
}