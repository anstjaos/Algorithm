import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            int result = 0;

            if (a == 0) result += 0;
            else if (a == 1) result += 5000000;
            else if (a <= 3) result += 3000000;
            else if (a <= 6) result += 2000000;
            else if (a <= 10) result += 500000;
            else if (a <= 15) result += 300000;
            else if (a <= 21) result += 100000;

            if (b == 0) result += 0;
            else if (b == 1) result += 5120000;
            else if (b <= 3) result += 2560000;
            else if (b <= 7) result += 1280000;
            else if (b <= 15) result += 640000;
            else if (b <= 31) result += 320000;

            sb.append(result).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
