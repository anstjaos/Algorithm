import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20332 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int sum = 0 ;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
        }
        if (sum % 3 == 0) System.out.println("yes");
        else System.out.println("no");
        br.close();
    }
}
