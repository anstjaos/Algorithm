import java.io.*;

public class BOJ_5692 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] factorial = new int[6];
        factorial[0] = factorial[1] = 1;
        for (int i = 2; i < 6; i++) factorial[i] = factorial[i-1] * i;

        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int count = 1;
            int result = 0;
            while (N != 0) {
                result += (N % 10) * factorial[count];
                N /= 10;
                count++;
            }

            sb.append(result).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
