import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16430 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        System.out.println((B - A) + " " + B);
    }
}
