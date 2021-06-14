import java.io.*;

public class BOJ_5565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.parseInt(br.readLine());
        for (int i = 0; i < 9; i++) {
            result -= Integer.parseInt(br.readLine());
        }
        br.close();
        System.out.println(result);
    }
}
