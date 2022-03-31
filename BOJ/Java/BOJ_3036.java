import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3036 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        int[] rings = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) rings[i] = Integer.parseInt(st.nextToken());
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            int gcd = getGcd(rings[0], rings[i]);
            sb.append(rings[0] / gcd).append("/").append(rings[i] / gcd).append("\n");
        }

        System.out.print(sb);
    }

    private static int getGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
