import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4101 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;

            if (a > b) sb.append("Yes\n");
            else sb.append("No\n");
        }
        br.close();

        System.out.print(sb);
    }
}
