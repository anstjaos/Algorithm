import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11549 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 0; i < 5; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (T == cur) count++;
        }
        br.close();
        System.out.println(count);
    }
}
