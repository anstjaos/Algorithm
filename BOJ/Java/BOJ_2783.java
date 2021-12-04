import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2783 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double price = Double.parseDouble(st.nextToken()), weight = Double.parseDouble(st.nextToken());
        double minVal = (1000.0 / weight) * price;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            price = Double.parseDouble(st.nextToken());
            weight = Double.parseDouble(st.nextToken());

            minVal = Math.min(minVal, (1000.0 / weight) * price);
        }
        br.close();

        System.out.printf("%.2f%n", minVal);
    }
}
