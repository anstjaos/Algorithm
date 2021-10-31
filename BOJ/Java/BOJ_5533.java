import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5533 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int score = arr[i][j];

                boolean isScore = false;
                for (int k = 0; k < N; k++) {
                    if (i == k) continue;

                    if (score == arr[k][j]) {
                        isScore = true;
                        break;
                    }
                }

                if (!isScore) result[i] += score;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.print(sb);
    }
}
