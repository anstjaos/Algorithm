import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16673 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());
        br.close();

        long result = 0;
        for (int i = 1; i <= C; i++) {
            result += (((long) K * i) + ((long) P * i * i));
        }

        System.out.println(result);
    }
}
