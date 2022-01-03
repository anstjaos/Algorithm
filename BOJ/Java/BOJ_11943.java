import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11943 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken());
        br.close();

        int diff1 = A + D, diff2 = C + B;
        System.out.println(Math.min(diff1, diff2));
    }
}
