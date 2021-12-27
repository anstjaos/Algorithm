import java.io.*;

public class BOJ_11729 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        sb.append((int) Math.pow(2, N) - 1).append("\n");

        solve(N, 1, 2, 3);
        System.out.print(sb);
    }

    private static void solve(int N, int start, int mid, int to) {
        if (N == 1) {
            sb.append(start + " " + to).append("\n");
            return;
        }

        solve(N-1, start, to, mid);
        sb.append(start).append(" ").append(to).append("\n");
        solve(N-1, mid, start, to);
    }
}
