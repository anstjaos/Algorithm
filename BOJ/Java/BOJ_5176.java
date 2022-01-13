import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5176 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

            boolean[] isVisit = new boolean[M + 5];

            int notSit = 0;
            for (int i = 0; i < P; i++) {
                int num = Integer.parseInt(br.readLine());

                if (isVisit[num]) notSit++;
                else isVisit[num] = true;
            }

            sb.append(notSit).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
