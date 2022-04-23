import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3034 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken());

        double maxLength = Math.sqrt(Math.pow(W, 2) + Math.pow(H, 2));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int length = Integer.parseInt(br.readLine());
            if (length <= W || length <= H || length <= maxLength) {
                sb.append("DA\n");
            } else {
                sb.append("NE\n");
            }
        }

        br.close();

        System.out.print(sb);
    }
}
