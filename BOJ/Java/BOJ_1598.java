import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1598 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
        br.close();

        int xw = (x - 1) / 4, yw = (y - 1) / 4;
        int xh = (x - 1) % 4, yh = (y - 1) % 4;

        System.out.println(Math.abs(yw - xw) + Math.abs(yh - xh));
    }
}
