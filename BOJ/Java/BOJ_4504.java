import java.io.*;

public class BOJ_4504 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;

            boolean isMulti = (num % n == 0);

            if (!isMulti) sb.append(num).append(" is NOT a multiple of ").append(n).append(".\n");
            else sb.append(num).append(" is a multiple of ").append(n).append(".\n");
        }
        br.close();
        System.out.print(sb);
    }
}
