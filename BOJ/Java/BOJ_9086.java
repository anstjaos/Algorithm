import java.io.*;

public class BOJ_9086 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String input = br.readLine();
            sb.append(input.charAt(0)).append(input.charAt(input.length() - 1)).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
