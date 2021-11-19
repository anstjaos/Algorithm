import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2526 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int N = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());

        int[] next = new int[1005];
        int cur = N, idx = 0;
        boolean isFound = false;
        while (!isFound) {
            cur = N * cur % P;

            for (int i = 0; i < idx; i++) {
                if (next[i] == cur) {
                    isFound = true;
                    System.out.println(idx - i);
                    break;
                }
            }

            next[idx] = cur;
            idx++;
        }
    }
}
