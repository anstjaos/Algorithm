import java.io.*;
import java.math.BigInteger;

public class BOJ_2935 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BigInteger a = new BigInteger(br.readLine());
        String operator = br.readLine();
        BigInteger b = new BigInteger(br.readLine());
        br.close();

        if (operator.equals("*")) System.out.println(a.multiply(b));
        else System.out.println(a.add(b));
    }
}
