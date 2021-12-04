import java.io.*;

public class BOJ_2789 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String cambridge = "CAMBRIDGE";
        String input = br.readLine();
        boolean[] isCambridge = new boolean[26];
        for (int i = 0; i < cambridge.length(); i++) {
            isCambridge[cambridge.charAt(i) - 'A'] = true;
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char cur = input.charAt(i);
            if (!isCambridge[cur - 'A']) sb.append(cur);
        }

        System.out.println(sb);
    }
}
