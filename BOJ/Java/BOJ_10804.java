import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10804 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] cards = new int[21];
        for (int i = 1; i <= 20; i++) cards[i] = i;

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
            int mid = (to - from) / 2;

            for (int j = 0; j <= mid; j++) {
                int cur = cards[from + j], next = cards[to - j];
                cards[to-j] = cur;
                cards[from+j] = next;
            }
        }
        br.close();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 20; i++) sb.append(cards[i]).append(" ");
        System.out.println(sb);
    }
}
