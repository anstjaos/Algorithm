import java.io.*;

public class BOJ_10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String input = br.readLine();
            sb.append((input.charAt(0) - '0') + (input.charAt(2) - '0')).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
