import java.io.*;

public class BOJ_10990 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = N - i; j > 0; j--) sb.append(" ");

            sb.append("*");

            for (int j = 1; j < 2 * i - 2; j++) sb.append(" ");
            if (i != 1) sb.append("*");
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
