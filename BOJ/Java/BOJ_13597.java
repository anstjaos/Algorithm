import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13597 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        if (A != B) {
            System.out.println(Math.max(A, B));
        } else {
            System.out.println(A);
        }
        br.close();
    }
}
