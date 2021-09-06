import java.io.*;

public class BOJ_2445 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) sb.append("*");
            for (int j = 0; j < (N - i) * 2; j++) sb.append(" ");
            for (int j = 0; j < i; j++) sb.append("*");

            sb.append("\n");
        }

        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) sb.append("*");
            for (int j = 0; j < (N - i) * 2; j++) sb.append(" ");
            for (int j = 0; j < i; j++) sb.append("*");

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
