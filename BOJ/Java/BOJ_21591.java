import java.io.*;
import java.util.StringTokenizer;

public class BOJ_21591 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int wc = Integer.parseInt(st.nextToken()), hc = Integer.parseInt(st.nextToken());
        int ws = Integer.parseInt(st.nextToken()), hs = Integer.parseInt(st.nextToken());

        if ((wc - ws) >= 2 && (hc - hs) >= 2) System.out.println(1);
        else System.out.println(0);
        br.close();
    }
}
