import java.io.*;

public class BOJ_10158 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        int W = Integer.parseInt(input.split(" ")[0]), H = Integer.parseInt(input.split(" ")[1]);

        input = br.readLine();
        int curX = Integer.parseInt(input.split(" ")[0]), curY = Integer.parseInt(input.split(" ")[1]);
        int t = Integer.parseInt(br.readLine());
        int x = (curX + t) % (2 * W);
        int y = (curY + t) % (2 * H);

        x = W - Math.abs(W-x);
        y = H - Math.abs(H-y);

        System.out.println(x+" "+y);
    }
}
