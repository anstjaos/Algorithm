import java.io.*;

public class BOJ_10808 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        int length = input.length();
        int[] count = new int[26];
        for (int i = 0; i < length; i++) {
            count[input.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) sb.append(count[i]).append(" ");
        System.out.println(sb);
    }
}
