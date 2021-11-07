import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11023 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        while (st.hasMoreTokens()) {
            result += Integer.parseInt(st.nextToken());
        }
        br.close();

        System.out.println(result);
    }
}
