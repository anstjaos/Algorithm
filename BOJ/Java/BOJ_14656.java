import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14656 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int count = 0;
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur != i) count++;
        }

        System.out.println(count);
    }
}
