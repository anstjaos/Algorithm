import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2476 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

            if (a == b && b == c) result = Math.max(result, a * 1000 + 10000);
            else if (a == b || a == c) result = Math.max(result, a * 100 + 1000);
            else if (b == c) result = Math.max(result, b * 100 + 1000);
            else {
                int maxVal = Math.max(a, Math.max(b, c));
                result = Math.max(result, maxVal * 100);
            }
        }
        br.close();
        System.out.println(result);
    }
}
