import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1357 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        StringBuilder X = new StringBuilder(st.nextToken()), Y = new StringBuilder(st.nextToken());
        int sum = Integer.parseInt(X.reverse().toString()) + Integer.parseInt(Y.reverse().toString());
        System.out.println(Integer.parseInt(new StringBuilder(String.valueOf(sum)).reverse().toString()));
    }
}
