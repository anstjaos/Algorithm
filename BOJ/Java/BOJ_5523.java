import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5523 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        int aWinCount = 0, bWinCount = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());

            if (A > B) aWinCount++;
            else if (A < B) bWinCount++;
        }
        br.close();

        System.out.println(aWinCount + " " + bWinCount);
    }
}
