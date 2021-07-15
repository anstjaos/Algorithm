import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10797 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        for (int i = 0; i < 5; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp % 10 == num) count++;
        }
        br.close();
        System.out.println(count);
    }
}
