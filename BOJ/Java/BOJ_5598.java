import java.io.*;

public class BOJ_5598 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            int idx = (cur - 'A' - 3 + 26) % 26;
            sb.append((char) ('A' + idx));
        }

        System.out.println(sb);
    }
}
