import java.io.*;
import java.math.BigInteger;

public class BOJ_2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger num = new BigInteger(br.readLine());
        br.close();

        BigInteger result = num.sqrt();
        if ((result.multiply(result)).compareTo(result) >= 0) result = result.add(BigInteger.ONE);

        System.out.println(result);
    }
}
