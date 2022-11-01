import java.io.*;

public class BOJ_15372 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            long num = Long.parseLong(br.readLine());
            sb.append(num * num).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
