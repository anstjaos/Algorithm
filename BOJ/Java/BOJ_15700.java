import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15700 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken()), M = Long.parseLong(st.nextToken());
        System.out.println((N * M) / 2);
        br.close();
    }
}
