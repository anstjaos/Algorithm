import java.io.*;

public class BOJ_11721 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        int length = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= length; i++) {
            sb.append(input.charAt(i-1));
            if (i % 10 == 0) sb.append("\n");
        }

        System.out.println(sb);
    }
}
