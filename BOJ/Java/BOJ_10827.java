import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class BOJ_10827 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        BigDecimal a = new BigDecimal(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(a.pow(b).toPlainString());
    }
}
