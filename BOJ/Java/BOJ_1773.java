import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1773 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int count = 0;
        for (int i = 1; i <= C; i++) {
            boolean isBomb = false;
            for (int j = 0; j < N; j++) {
                if (i % arr[j] == 0) {
                    isBomb = true;
                    break;
                }
            }

            if (isBomb) count++;
        }
        System.out.println(count);
    }
}
