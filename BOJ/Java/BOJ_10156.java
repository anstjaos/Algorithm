import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10156 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int K = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        if (K * N > M) System.out.println((K* N )- M);
        else System.out.println(0);
    }
}
