import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2845 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());

        int val = L * P;

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int cur = Integer.parseInt(st.nextToken());
            sb.append(cur - val).append(" ");
        }
        br.close();
        System.out.println(sb);
    }
}
