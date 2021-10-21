import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2804 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        String a = st.nextToken(), b = st.nextToken();

        int aIndex = -1, bIndex = -1;
        int aLength = a.length(), bLength = b.length();

        for (int i = 0; i < aLength; i++) {
            for (int j = 0; j < bLength; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    aIndex = i;
                    bIndex = j;
                    break;
                }
            }

            if (aIndex != -1) break;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bLength; i++) {
            if (i == bIndex) {
                sb.append(a).append("\n");
                continue;
            }

            for (int j = 0; j < aLength; j++) {
                if (j == aIndex) sb.append(b.charAt(i));
                else sb.append(".");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
