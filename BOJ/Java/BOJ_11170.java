import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11170 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());

            int count = 0;
            for (int i = start; i <= end; i++) {
                int num = i;
                if (num == 0) {
                    count++;
                    continue;
                }

                while (num > 0) {
                    if (num % 10 == 0) count++;
                    num /= 10;
                }
            }

            sb.append(count).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
