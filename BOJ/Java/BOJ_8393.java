import java.io.*;

public class BOJ_8393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        long result = 0;
        for (int i = 1; i <= n; i++) result += i;
        System.out.println(result);
    }
}
