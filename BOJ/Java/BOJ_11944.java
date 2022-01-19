import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11944 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(N);
        br.close();

        System.out.println(sb.length() > M ? sb.substring(0, M) : sb);
    }
}
