import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_1271 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        BigInteger n = new BigInteger(st.nextToken()), m = new BigInteger(st.nextToken());
        System.out.println(n.divide(m));
        System.out.println(n.mod(m));
    }
}
