import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2530 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(br.readLine());
        br.close();

        C = (C + D);

        B = (B + (C / 60));
        C %= 60;

        A = (A + (B / 60));
        B %= 60;
        A %= 24;

        System.out.println(A + " " + B + " " + C);
    }
}
