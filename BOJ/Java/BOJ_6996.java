import java.io.*;
import java.util.StringTokenizer;

public class BOJ_6996 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken(), B = st.nextToken();

            if (A.length() != B.length()) {
                sb.append(A).append(" & ").append(B).append(" are NOT anagrams.\n");
                continue;
            }

            int[] aCount = new int[26], bCount = new int[26];

            for (int i = 0; i < A.length(); i++) {
                aCount[A.charAt(i) - 'a']++;
            }
            for (int i = 0; i < B.length(); i++) {
                bCount[B.charAt(i) - 'a']++;
            }

            boolean isAnagram = true;
            for (int i = 0; i < 26; i++) {
                if (aCount[i] != bCount[i]) {
                    isAnagram = false;
                    break;
                }
            }

            sb.append(A).append(" & ").append(B);
            if (isAnagram) {
                sb.append(" are anagrams.\n");
            } else {
                sb.append(" are NOT anagrams.\n");
            }
        }
        br.close();
        System.out.print(sb);
    }
}
