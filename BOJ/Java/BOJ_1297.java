import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1297 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int D = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());

        double result = Math.sqrt(Math.pow(D, 2) / (Math.pow(H, 2) + Math.pow(W, 2)));
        System.out.println((int) Math.floor(result * H) + " " + (int) Math.floor(result * W));
    }
}
