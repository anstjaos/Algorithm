import java.io.*;

public class BOJ_15917 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int n = Integer.parseInt(br.readLine());

            if ((n & (n * -1)) == n) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
