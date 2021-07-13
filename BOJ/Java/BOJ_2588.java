import java.io.*;

public class BOJ_2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine()), B = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        int result = 0;
        for (int i = 0; i < 3; i++) {
            int temp = A * (B % 10);
            int multi = 1;
            for (int j = 0; j < i; j++) multi *= 10;
            result += temp * multi;
            sb.append(temp).append("\n");
            B /= 10;
        }
        sb.append(result);
        System.out.println(sb);
    }
}
