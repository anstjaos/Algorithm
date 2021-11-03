import java.io.*;

public class BOJ_5988 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
           String input = br.readLine();
           int endNum = (input.charAt(input.length() - 1) - '0');
           if ((endNum & 1) == 1) sb.append("odd\n");
           else sb.append("even\n");
        }
        br.close();
        System.out.print(sb);
    }
}
