import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int reverseA = 0, reverseB = 0;

        while (A != 0) {
            reverseA = reverseA * 10 + (A % 10);
            A /= 10;
        }
        while (B != 0) {
            reverseB = reverseB * 10 + (B % 10);
            B /= 10;
        }

        System.out.println(Math.max(reverseA, reverseB));
        br.close();
    }
}
