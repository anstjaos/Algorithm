import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1547 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int M = Integer.parseInt(br.readLine());

        int cup = 1;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            if (cup == x) cup = y;
            else if (cup == y) cup = x;
        }
        br.close();

        System.out.println(cup);
    }
}
