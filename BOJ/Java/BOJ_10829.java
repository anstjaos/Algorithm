import java.io.*;
import java.math.BigInteger;

public class BOJ_10829 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BigInteger N = new BigInteger(br.readLine());
        StringBuilder sb = new StringBuilder();
        br.close();

        while (!N.equals(BigInteger.ZERO)) {
            sb.append(N.mod(BigInteger.TWO));
            N = N.divide(BigInteger.TWO);
        }

        System.out.println(sb.reverse());
    }
}
