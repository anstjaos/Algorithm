import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2420 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        long N = Long.parseLong(st.nextToken()), M = Long.parseLong(st.nextToken());

        System.out.println(Math.abs(N - M));
    }
}
