import java.io.*;

public class BOJ_2010 {
    public static void main(String[] args) throws IOException {
        int N, result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            result += Integer.parseInt(br.readLine());
        }

        result -= N-1;

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(result).toString());
    }
}
