import java.io.*;

public class BOJ_1371 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] num = new int[26];

        String input = "";
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            int len = input.length();
            for (int i = 0; i < len; i++) {
                char cur = input.charAt(i);
                if (cur == ' ') continue;

                num[cur - 'a']++;
            }
        }
        br.close();

        int maxNum = 0;
        for (int i = 0; i < 26; i++) {
            maxNum = Math.max(maxNum, num[i]);
        }

        for (int i = 0; i < 26; i++) {
            if (num[i] == maxNum) sb.append((char) (i + 'a'));
        }
        System.out.println(sb);
    }
}
