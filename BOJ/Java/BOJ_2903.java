import java.io.*;

public class BOJ_2903 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N  = Integer.parseInt(br.readLine());
        br.close();

        int cur = 3;
        for (int i = 2; i <= N; i++) {
            cur = cur * 2 - 1;
        }

        System.out.println(cur* cur);
    }
}
