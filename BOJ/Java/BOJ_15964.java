import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15964 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());

        System.out.println((a + b) * (a -b));
    }
}
