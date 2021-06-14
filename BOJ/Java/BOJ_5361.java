import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5361 {
    private static long[] price = {35034, 23090, 19055, 12530, 18090};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            long result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 5; i++) {
                result += price[i] * Integer.parseInt(st.nextToken());
            }
            String other = String.format("%02d", result % 100);
            sb.append("$").append(result / 100).append('.').append(other).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
