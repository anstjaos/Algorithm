import java.io.*;

public class BOJ_10205 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();

            for (int i = 0; i < input.length(); i++) {
                if (N == 0) break;
                char cur = input.charAt(i);
                if (cur == 'c') N++;
                else N--;
            }

            sb.append("Data Set ").append(t).append(":\n").append(N).append("\n\n");
        }
        br.close();

        System.out.print(sb);
    }
}
