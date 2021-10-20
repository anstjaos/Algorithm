import java.io.*;
import java.util.Arrays;

public class BOJ_11656 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        int length = input.length();
        String[] list = new String[length];

        for (int i = 0; i < length; i++) {
            String cur = input.substring(i, length);
            list[i] = cur;
        }

        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(list[i]).append("\n");
        }

        System.out.print(sb);
    }
}
