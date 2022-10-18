import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17010 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            String input = st.nextToken();
            for (int i = 0; i < num; i++) {
                sb.append(input);
            }
            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
