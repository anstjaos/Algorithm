import java.io.*;

public class BOJ_2495 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String input = br.readLine();

            int maxLength = 1;
            int length = input.length();
            char before = 'a';
            int count = 0;
            for (int j = 0; j < length; j++) {
                char cur = input.charAt(j);
                if (cur != before) {
                    maxLength = Math.max(maxLength, count);
                    before = cur;
                    count = 1;
                } else {
                    count++;
                }
            }
            maxLength = Math.max(maxLength, count);

            sb.append(maxLength).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
