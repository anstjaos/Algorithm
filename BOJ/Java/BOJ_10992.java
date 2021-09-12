import java.io.*;

public class BOJ_10992 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (i == N) {
                for (int j = 0; j < 2 * N - 1; j++) sb.append("*");
                break;
            }

            for (int j = 0; j < N - i; j++) sb.append(" ");
            sb.append("*");
            for (int j = 0; j < 2 * i - 2; j++) {
                if (j == 2 * i - 3 && i != 1) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
