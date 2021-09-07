import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4562 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            if (a >= b) sb.append("MMM BRAINS\n");
            else sb.append("NO BRAINS\n");
        }
        br.close();

        System.out.print(sb);
    }
}
