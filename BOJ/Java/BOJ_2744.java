import java.io.*;

public class BOJ_2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        StringBuilder sb = new StringBuilder();
        int len = input.length();
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if ('a' <= c && c <= 'z') sb.append((char) (c - 'a' + 'A'));
            else sb.append((char) (c - 'A' + 'a'));
        }

        System.out.println(sb);
    }
}
