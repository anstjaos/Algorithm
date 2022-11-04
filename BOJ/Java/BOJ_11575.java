import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11575 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            String input = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                sb.append((char)(((((input.charAt(i) - 'A') * a + b) % 26) + 'A')));
            }
            result.append(sb).append("\n");
        }
        br.close();
        System.out.print(result);
    }
}
