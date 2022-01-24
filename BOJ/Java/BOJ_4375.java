import java.io.*;
import java.math.BigInteger;

public class BOJ_4375 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        String input = "";
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            long N = Long.parseLong(input);

            BigInteger result = BigInteger.ONE;
            int count = 1;
            while (!result.mod(BigInteger.valueOf(N)).equals(BigInteger.ZERO)) {
                result = result.multiply(BigInteger.valueOf(10)).add(BigInteger.ONE);
                count++;
            }
            sb.append(count).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
