import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3003 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int[] chess = {1, 1, 2, 2, 2, 8};
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            sb.append(chess[i] - Integer.parseInt(st.nextToken())).append(" ");
        }
        br.close();
        System.out.println(sb);
    }
}
