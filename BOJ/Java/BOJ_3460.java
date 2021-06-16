import java.io.*;

public class BOJ_3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int count = 0;
            int num = Integer.parseInt(br.readLine());

            while (num > 0) {
                if ((num % 2) == 1) sb.append(count).append(" ");
                num /= 2;
                count++;
            }
            sb.append("\n");
        }

        br.close();
        System.out.print(sb);
    }
}
