import java.io.*;

public class BOJ_5789 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String input = br.readLine();
            int length = input.length();

            sb.append((input.charAt(length / 2 - 1) == input.charAt(length / 2) ? "Do-it" : "Do-it-Not")).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
