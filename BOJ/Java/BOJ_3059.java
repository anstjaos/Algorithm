import java.io.*;
import java.util.Arrays;

public class BOJ_3059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            boolean[] isIn = new boolean[26];
            Arrays.fill(isIn, false);
            String input = br.readLine();
            int length = input.length();

            for (int i = 0; i < length; i++) {
                isIn[input.charAt(i) - 'A'] = true;
            }

            int result = 0;
            for (int i = 0; i < 26; i++) {
                if (!isIn[i]) {
                    result += (int)('A' + i);
                }
            }

            sb.append(result).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
