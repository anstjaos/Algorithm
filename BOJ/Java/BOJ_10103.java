import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10103 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine());
        int a = 100, b = 100;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int aScore = Integer.parseInt(st.nextToken()), bScore = Integer.parseInt(st.nextToken());

            if (aScore > bScore) b -= aScore;
            else if (aScore < bScore) a -= bScore;
        }
        br.close();

        System.out.println(a);
        System.out.println(b);
    }
}
