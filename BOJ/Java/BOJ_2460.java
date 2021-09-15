import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2460 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int count = 0, result = 0;
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            count -= Integer.parseInt(st.nextToken());
            count += Integer.parseInt(st.nextToken());

            result = Math.max(result, count);
        }
        br.close();
        System.out.println(result);
    }
}
