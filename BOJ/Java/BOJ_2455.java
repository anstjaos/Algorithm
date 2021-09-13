import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2455 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int count = 0;
        int result = 0;
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            count -= Integer.parseInt(st.nextToken());
            result = Math.max(count, result);
            count += Integer.parseInt(st.nextToken());
            result = Math.max(count, result);
        }
        br.close();

        System.out.println(result);
    }
}
