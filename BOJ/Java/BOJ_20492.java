import java.io.*;

public class BOJ_20492 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        long N = Integer.parseInt(br.readLine());

        System.out.println((N * 78 / 100) + " " + (N * 80 / 100 + (N * 20 / 100 * 78 / 100)));
        br.close();
    }
}
