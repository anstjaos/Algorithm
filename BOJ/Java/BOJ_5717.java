import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5717 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            result = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            if (result == 0) break;

            sb.append(result).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
