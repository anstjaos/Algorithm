import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2914 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int A = Integer.parseInt(st.nextToken()), I = Integer.parseInt(st.nextToken());

        int result = A * (I - 1);

        while (true) {
            int temp = (int) Math.ceil((double) result / A);
            if (temp == I) break;
            result++;
        }

        System.out.println(result);
    }
}
