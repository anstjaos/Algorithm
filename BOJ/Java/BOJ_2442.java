import java.io.*;

public class BOJ_2442 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        br.close();

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N - i; j++) {
                sb.append(" ");
            }

            for (int j = 0; j < 2 * i - 1; j++) sb.append("*");

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
