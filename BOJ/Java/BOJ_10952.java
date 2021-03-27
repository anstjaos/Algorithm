import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s;

        StringBuilder sb = new StringBuilder();
        while ( (s = br.readLine()) != null) {
            int A = s.charAt(0) - '0';
            int B = s.charAt(2) - '0';

            if ( A == 0 && B == 0) break;
            sb.append(A+B + "\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
