import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

        int count = 0;
        while (true) {
            int diffAB = B - A;
            int diffBC = C - B;

            if (diffAB == 1 && diffBC == 1) break;

            if (diffAB > diffBC) {
                int temp = B;
                B = A + 1;
                C = temp;
            } else {
                A = B;
                B = B + 1;
            }
            count++;
        }
        System.out.println(count);
    }
}
