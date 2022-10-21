import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20254 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Ur = Integer.parseInt(st.nextToken()), Tr = Integer.parseInt(st.nextToken());
        int Uo = Integer.parseInt(st.nextToken()), To = Integer.parseInt(st.nextToken());

        System.out.println(56 * Ur + 24 * Tr + 14 * Uo + 6 * To);
        br.close();
    }
}
