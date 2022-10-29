import java.io.*;
import java.util.StringTokenizer;

public class BOJ_23825 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int result = Math.min(N / 2, M / 2);
        System.out.println(result);
        br.close();
    }
}
