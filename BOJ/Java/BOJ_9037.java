import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9037 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] % 2 == 1) arr[i]++;
            }

            int count = 0;
            while (!isAllSame(N, arr)) {
                int[] half = new int[N];
                for (int i = 0; i < N; i++) {
                    half[i] = arr[i] / 2;
                    arr[i] /= 2;
                }

                for (int i = 0; i < N; i++) {
                    arr[i] += half[(i - 1 + N) % N];
                    if (arr[i] % 2 == 1) arr[i]++;
                }
                count++;
            }

            sb.append(count).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    private static boolean isAllSame(int N, int[] arr) {
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] != arr[i + 1]) return false;
        }
        return true;
    }
}
