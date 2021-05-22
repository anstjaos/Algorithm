import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken()) - 1, S = Integer.parseInt(st.nextToken()) - 1, M = Integer.parseInt(st.nextToken()) -1;
        br.close();

        int year = S;
        while (true) {
            if (year % 15 == E && year % 28 == S && year % 19 == M) break;
            year += 28;
        }

        System.out.println(year + 1);
    }
}
