import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14910 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        boolean isAscending = true;
        int before = Integer.MIN_VALUE;
        while (st.hasMoreTokens()) {
            int cur = Integer.parseInt(st.nextToken());
            if (before > cur) {
                isAscending = false;
                break;
            }

            before = cur;
        }

        System.out.println(isAscending ? "Good" : "Bad");
    }
}
