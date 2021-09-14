import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10214 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int yonsei = 0, korea = 0;
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                yonsei += Integer.parseInt(st.nextToken());
                korea += Integer.parseInt(st.nextToken());
            }

            if (yonsei > korea) sb.append("Yonsei\n");
            else if (yonsei == korea) sb.append("Draw\n");
            else sb.append("Korea\n");
        }
        br.close();

        System.out.print(sb);
    }
}
