import java.io.*;
import java.util.StringTokenizer;

public class BOJ_25238 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double a = Double.parseDouble(st.nextToken()), b = Double.parseDouble(st.nextToken());

        double result = a - (a * b / 100);

        if (result >= 100.0) System.out.println(0);
        else System.out.println(1);
        br.close();
    }
}
