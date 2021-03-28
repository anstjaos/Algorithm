import java.io.*;

public class BOJ_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        int[][] arr = new int[20][20];
        for (int i = 1; i < 15; i++) arr[0][i] = i;

        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        while (tc > 0) {
            tc--;

            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(arr[k][n] + "\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
}
