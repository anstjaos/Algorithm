import java.io.*;

public class BOJ_2023 {
    private static StringBuilder sb;
    private static int N;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        N = Integer.parseInt(br.readLine());
        br.close();

        sb = new StringBuilder();
        for (int i = 2; i < 10; i++) {
            solve(1, i);
        }
        System.out.print(sb);
    }

    private static void solve(int count, int num) {
        if (!isPrime(num)) return;

        if (count == N) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 1; i < 10; i++) {
            solve(count + 1, num * 10 + i);
        }
    }

    private static boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);

        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
