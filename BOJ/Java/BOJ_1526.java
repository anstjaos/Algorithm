import java.io.*;

public class BOJ_1526 {
    private static int maxVal = 0, N = 0;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        N = Integer.parseInt(br.readLine());
        br.close();

        solve(0);
        System.out.println(maxVal);
    }

    private static void solve(int num) {
        if (num > N) return;
        maxVal = Math.max(maxVal, num);

        solve(num * 10 + 4);
        solve (num * 10 + 7);
    }
}
