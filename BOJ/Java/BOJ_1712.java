import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1712 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        br.close();

        int diff = C - B;
        if (diff == -1 || diff == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(A / diff + 1);
    }
}
