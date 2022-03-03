import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5063 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int notAdvertise = Integer.parseInt(st.nextToken()), advertise = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());

            if (notAdvertise < advertise) sb.append("advertise\n");
            else if ( notAdvertise > advertise) sb.append("do not advertise\n");
            else sb.append("does not matter\n");
        }
        br.close();

        System.out.print(sb);
    }
}
