import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2828 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int left = 0;
        int right = M - 1;
        int result = 0;
        for (int i = 0; i < J; i++) {
            int apple = Integer.parseInt(br.readLine()) - 1;

            if (apple > right) {
                result += apple - right;
                right = apple;
                left = apple - (M - 1);
            } else if (apple < left) {
                result += left - apple;
                left = apple;
                right = apple + (M - 1);
            }
        }
        br.close();
        System.out.println(result);
    }
}
