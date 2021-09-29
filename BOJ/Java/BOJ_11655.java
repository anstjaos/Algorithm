import java.io.*;

public class BOJ_11655 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == ' ' || ('0' <= cur && cur <= '9')) {
                sb.append(cur);
                continue;
            }

            if ('a' <= cur && cur <= 'z') {
                sb.append((char) ((cur - 'a' + 13) % 26 + 'a'));
            } else {
                sb.append((char) ((cur - 'A' + 13) % 26 + 'A'));
            }
        }
        br.close();
        System.out.println(sb);
    }
}
