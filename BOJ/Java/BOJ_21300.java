import java.io.*;
import java.util.StringTokenizer;

public class BOJ_21300 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += Integer.parseInt(st.nextToken()) * 5;
        }
        br.close();
        System.out.println(sum);
    }
}
