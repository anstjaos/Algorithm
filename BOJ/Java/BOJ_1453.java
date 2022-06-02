import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1453 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        boolean[] isSit = new boolean[105];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            int sit = Integer.parseInt(st.nextToken());
            if (isSit[sit]) {
                count++;
            }
            isSit[sit] = true;
        }
        br.close();
        System.out.println(count);
    }
}
