import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17269 {
    private static int[] count = {3,2,1,2,4,3,1,3,1,1,3,1,3,2,1,2,2,2,1,2,1,1,1,2,2,1};
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        br.close();

        int[] cur = new int[300];
        int curIdx = 0;
        String A = st.nextToken(), B = st.nextToken();
        for (int i = 0; i < Math.max(N, M); i++) {
            if (i < N) {
                cur[curIdx++] = count[A.charAt(i) - 'A'];
            }
            if (i < M) {
                cur[curIdx++] = count[B.charAt(i) - 'A'];
            }
        }

        while (curIdx != 2) {
            int[] temp = new int[300];
            for (int i = 0; i < curIdx - 1; i++) {
                temp[i] = (cur[i] + cur[i + 1]) % 10;
            }
            curIdx--;
            cur = temp;
        }

        int result = cur[0] * 10 + cur[1];

        System.out.println(result + "%");
    }
}
