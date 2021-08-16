import java.io.*;
import java.util.StringTokenizer;

public class BOJ_6502 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int count = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double r = Double.parseDouble(st.nextToken());
            if (r == 0) break;

            int w = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken());
            boolean isFit = true;
            if (w >= r * 2 || l >= r * 2) isFit = false;
            double temp = Math.sqrt((w * w) + (l * l));
            if (temp > r * 2) isFit = false;
            sb.append("Pizza ").append(count);
            if (isFit) sb.append(" fits on the table.\n");
            else sb.append(" does not fit on the table.\n");
            count++;
        }
        br.close();
        System.out.print(sb);
    }
}
