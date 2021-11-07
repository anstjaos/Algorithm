import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11024 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int result = 0;

            while (st.hasMoreTokens()) {
                result += Integer.parseInt(st.nextToken());
            }
            sb.append(result).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
