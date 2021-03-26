import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String input = st.nextToken();

            StringBuilder sb = new StringBuilder();
            int inputLength = input.length();
            for (int i = 0; i < inputLength; i++) {
                for (int j = 0; j < R; j++) {
                    sb.append(input.charAt(i));
                }
            }
            sb.append("\n");
            bw.write(sb.toString());
            bw.flush();
        }

        bw.close();
        br.close();
    }
}
