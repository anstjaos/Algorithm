import java.io.*;

public class BOJ_1264 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("#")) break;

            int length = input.length();
            int count = 0;
            for (int i = 0; i < length; i++) {
                char cur = input.charAt(i);
                if ('A' <= cur && cur <= 'Z') cur = (char) ((cur - 'A') + 'a');
                if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') count++;
            }
            sb.append(count).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
