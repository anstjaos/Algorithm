import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class BOJ_2386 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            if (c == '#') break;

            int count = 0;
            while (st.hasMoreTokens()) {
                String next = st.nextToken().toLowerCase(Locale.ROOT);
                int length = next.length();
                for (int i = 0; i < length; i++) {
                    if (next.charAt(i) == c) count++;
                }
            }

            sb.append(c).append(" ").append(count).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
