import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11319 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int consonants = 0, vowels = 0;
            while (st.hasMoreTokens()) {
                String input = st.nextToken().toLowerCase();

                int length = input.length();
                for (int i = 0; i < length; i++) {
                    char cur = input.charAt(i);
                    if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
                        vowels++;
                    } else {
                        consonants++;
                    }
                }
            }

            sb.append(consonants).append(" ").append(vowels).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
