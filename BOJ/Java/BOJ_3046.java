import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println(S * 2 - r1);
    }
}
