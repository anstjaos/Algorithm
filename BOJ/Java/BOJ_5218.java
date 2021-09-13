import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5218 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append("Distances: ");

            String a = st.nextToken(), b = st.nextToken();
            int len = a.length();

            for (int i = 0; i < len; i++) {
                int charA = a.charAt(i) - 'A';
                int charB = b.charAt(i) - 'A';

                if (charB >= charA) sb.append(charB - charA).append(" ");
                else sb.append((charB + 26) - charA).append(" ");
            }
            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
