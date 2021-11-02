import java.io.*;

public class BOJ_14624 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        if ((N & 1) == 1) {
            for (int i = 0; i < N; i++) sb.append("*");
            sb.append("\n");

            for (int i = 0; i < (N + 1) / 2; i++) {
                for (int j = 0; j < N / 2 - i; j++) sb.append(" ");
                sb.append("*");
                for (int j = 0; j < 2 * i - 1; j++) sb.append(" ");
                if (i != 0) sb.append("*");
                sb.append("\n");
            }
        } else {
            sb.append("I LOVE CBNU\n");
        }

        System.out.print(sb);
    }
}
