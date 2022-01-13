import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3058 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int result = 0, minVal = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 7; i++) {
                int num = Integer.parseInt(st.nextToken());
                if ((num & 1) == 0) {
                    result += num;
                    minVal = Math.min(minVal, num);
                }
            }

            sb.append(result).append(" ").append(minVal).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
