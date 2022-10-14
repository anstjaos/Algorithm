import java.io.*;

public class BOJ_25372 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String input = br.readLine();
            if (6 <= input.length() && input.length() <= 9) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        br.close();
        System.out.print(sb);
    }
}
