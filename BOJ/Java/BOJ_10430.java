import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        br.close();

        StringBuilder sb = new StringBuilder();
        sb.append((A + B) % C).append("\n").append(((A % C) + (B % C)) % C).append("\n").append((A * B) % C).append("\n").append(((A % C) * (B % C)) % C);
        System.out.println(sb);
    }
}
