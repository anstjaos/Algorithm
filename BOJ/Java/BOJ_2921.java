import java.io.*;

public class BOJ_2921 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = i; j <= N; j++) result += i + j;
        }
        br.close();

        System.out.println(result);
    }
}
