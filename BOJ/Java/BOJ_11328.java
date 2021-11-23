import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11328 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String a = st.nextToken(), b = st.nextToken();
            if (a.length() != b.length()) {
                sb.append("Impossible\n");
                continue;
            }

            int[] count = new int[30];
            int aLength = a.length();
            for (int j = 0; j < aLength; j++) {
                count[a.charAt(j) - 'a']++;
            }

            int bLength = b.length();
            boolean isPossible = true;
            for (int j = 0; j < bLength; j++) {
                int curCount = --count[b.charAt(j) - 'a'];
                if (curCount < 0) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) sb.append("Possible\n");
            else sb.append("Impossible\n");
        }
        br.close();

        System.out.print(sb);
    }
}
