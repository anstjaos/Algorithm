import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10474 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
            if (A == 0 && B == 0) break;

            sb.append(A / B).append(" ").append(A % B).append(" / ").append(B).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
