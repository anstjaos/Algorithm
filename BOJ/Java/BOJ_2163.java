import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        br.close();

        int result = N * M - 1;
        System.out.println(result);
    }
}
