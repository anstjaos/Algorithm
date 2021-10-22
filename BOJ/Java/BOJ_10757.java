import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_10757 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        BigInteger a = new BigInteger(st.nextToken()), b = new BigInteger(st.nextToken());
        System.out.println(a.add(b));
    }
}
