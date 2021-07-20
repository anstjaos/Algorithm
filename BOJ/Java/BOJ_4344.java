import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (c-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            double sum = 0.0;
            double[] arr = new double[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Double.parseDouble(st.nextToken());
                sum += arr[i];
            }
            double avg = sum / N;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > avg) count++;
            }
            sb.append(String.format("%.3f", (double)count / (double)N * 100)).append("%\n");
        }
        br.close();
        System.out.print(sb);
    }
}
