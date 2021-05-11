import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arrX = new long[N+1];
        long[] arrY = new long[N+1];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arrX[i] = Integer.parseInt(st.nextToken());
            arrY[i] = Integer.parseInt(st.nextToken());
        }

        arrX[N] = arrX[0];
        arrY[N] = arrY[0];
        br.close();

        long sumA = 0, sumB = 0;
        for (int i = 0; i < N; i++) {
            sumA += arrX[i] * arrY[i+1];
            sumB += arrX[i+1] * arrY[i];
        }

        String result = String.format("%.1f", (Math.abs(sumA - sumB) / 2.0));
        System.out.println(result);
    }
}
