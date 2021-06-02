import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2005];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken()) + 1000;
            arr[num] = true;
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2005; i++) {
            if (arr[i]) sb.append(i - 1000).append(" ");
        }

        System.out.println(sb);
    }
}
