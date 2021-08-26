import java.io.*;

public class BOJ_2444 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N - i; j++) sb.append(" ");
            for (int j = 0; j < i; j++) sb.append("*");
            for (int j = 0; j < i - 1; j++) sb.append("*");
            sb.append("\n");
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) sb.append(" ");
            for (int j = 0; j < N - i; j++) sb.append("*");
            for (int j = 0; j < N - i - 1; j++) sb.append("*");
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
