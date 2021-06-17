import java.io.*;

public class BOJ_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int temp = N;
        int count = 0;
        while (true) {
            int next = (temp % 10) * 10 + (((temp / 10) + (temp % 10)) % 10);
            count++;
            if (next == N) break;
            temp = next;
        }
        System.out.println(count);
        br.close();
    }
}
