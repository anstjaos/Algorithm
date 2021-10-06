import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9085 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) result += Integer.parseInt(st.nextToken());

            sb.append(result).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
