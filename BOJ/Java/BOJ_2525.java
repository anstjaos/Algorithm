import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());
        br.close();

        B += C;
        A = (A + (B / 60)) % 24;
        B %= 60;

        System.out.println(A + " " + B);
    }
}
