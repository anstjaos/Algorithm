import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1007 {
    private static int N;
    private static double result;
    private static double[] xArr, yArr;
    private static boolean[] isMinus;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            N = Integer.parseInt(br.readLine());
            xArr = new double[N];
            yArr = new double[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                xArr[i] = Double.parseDouble(st.nextToken());
                yArr[i] = Double.parseDouble(st.nextToken());
            }

            isMinus = new boolean[N];
            result = Double.MAX_VALUE;
            solve(0, 0);
            System.out.printf("%.6f\n", result);
        }
        br.close();
    }

    private static void solve(int count, int index) {
        if (count == N / 2) {
            double x = 0, y = 0;

            for (int i = 0; i < N; i++) {
                if (isMinus[i]) {
                    x -= xArr[i];
                    y -= yArr[i];
                } else {
                    x += xArr[i];
                    y += yArr[i];
                }
            }

            result = Math.min(result, Math.sqrt((x * x) + (y* y)));
            return;
        }
        if (index == N) return;

        solve(count, index + 1);
        isMinus[index] = true;
        solve(count+1, index + 1);
        isMinus[index] = false;
    }
}
